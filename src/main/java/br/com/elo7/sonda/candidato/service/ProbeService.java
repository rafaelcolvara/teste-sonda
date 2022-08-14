package br.com.elo7.sonda.candidato.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.elo7.sonda.candidato.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.annotations.VisibleForTesting;
import br.com.elo7.sonda.candidato.dto.InputDTO;
import br.com.elo7.sonda.candidato.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.model.Command;
import br.com.elo7.sonda.candidato.model.Direction;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.persistence.Planets;
import br.com.elo7.sonda.candidato.persistence.Probes;

@Service
public class ProbeService {
	@Autowired
	private Planets planets;
	@Autowired
	private Probes probes;
	@Autowired
	private Mapper mapper;
	
	public List<Probe> landProbes(InputDTO inputDTO) {
		Planet planet = mapper.inputDTOToPlanet(inputDTO);
		planets.save(planet);
		
		List<Probe> convertedProbes = convertAndMoveProbes(inputDTO, planet);
		convertedProbes.forEach(probe -> probes.save(probe));
		
		return convertedProbes;
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
		probe.setX(newX);
		probe.setY(newY);
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
