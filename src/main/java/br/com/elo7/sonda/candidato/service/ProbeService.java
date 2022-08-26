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
	
	public List<Probe> landProbes(InputDTO inputDTO) {

		return probes.saveAll(convertAndMoveProbes(inputDTO, planets.save(mapper.inputDTOToPlanet(inputDTO))));
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

		if (validMoveProbe(probe, newX, newY)){
			probe.setX(newX);
			probe.setY(newY);
		}
	}

	private Boolean validMoveProbe(Probe probe, int newX, int newY) {
		return !(((probe.getPlanet().getHeight() <= newX) || (probe.getPlanet().getWidth() <= newY)) || (newX < 0 || newY < 0));
	}

	private List<Probe> convertAndMoveProbes(InputDTO input, Planet planet) {
		return input.getProbes()
						.stream().map(probeDto -> {
							Probe probe = mapper.toProbe(probeDto, planet);

							moveProbeWithAllCommands(probe, probeDto);
							return probe;
						}).collect(Collectors.toList());
	}

	private void moveProbeWithAllCommands(Probe probe, ProbeDTO probeDTO) {
		for (char command : probeDTO.getCommands().toCharArray()) {
			applyCommandToProbe(probe, command);
		}
	}


}
