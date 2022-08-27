package br.com.elo7.sonda.candidato.service;

import br.com.elo7.sonda.candidato.dto.InputDTO;
import br.com.elo7.sonda.candidato.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.mapper.Mapper;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.persistence.Planets;
import br.com.elo7.sonda.candidato.persistence.Probes;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProbeService {
	@Autowired
	private Planets planets;
	@Autowired
	private Probes probes;
	@Autowired
	private Mapper mapper;

	@Autowired
	private ProbeValidation probeValidation;

	public List<Probe> saveProbes(List<ProbeDTO> probeDTOList ) {

		List<Probe> probeList = mapper.toListProbe(probeDTOList );

		return probes.saveAll(probeList);
	}

	public List<Probe> landProbes(InputDTO inputDTO) {

		return MoveProbes(inputDTO);
	}
	
	@VisibleForTesting
	void applyCommandToProbe(Probe probe, char command) {
		switch (command) {
			case 'R':
				probe.setDirection(probe.getDirection().turnRight());
				break;
			case 'L':
				probe.setDirection(probe.getDirection().turnLeft());
				break;
			case 'M':
				moveProbeForward(probe);
				break;
		}
	}

	private void moveProbeForward(Probe probe) {
		int newX = probe.getX();
		int newY = probe.getY();
		switch (probe.getDirection()) {
			case N:
				newY++;
				break;
			case W:
				newX--;
				break;
			case S:
				newY--;
				break;
			case E:
				newX++;
				break;
		}

		if (probeValidation.validMoveProbe(probe, newX, newY) && probeValidation.checkColisionProbes(probe)){
			probe.setX(newX);
			probe.setY(newY);
		}
	}


	private List<Probe> MoveProbes(InputDTO input) {
		return input.getProbesWithCommands()
				.entrySet()
				.stream()
				.map(probeDto -> {
							Probe probe = probes.getById(probeDto.getKey());
							moveProbeWithAllCommands(probe, probeDto.getValue());
							return probe;
						}).collect(Collectors.toList());
	}

	private void moveProbeWithAllCommands(Probe probe, String commandFromProbe) {
		for (char command : commandFromProbe.toCharArray()) {
			applyCommandToProbe(probe, command);
		}
	}

	public List<Probe> getAllProbes(){
		return probes.findAll();
	}


}
