package br.com.elo7.sonda.candidato.mapper;

import br.com.elo7.sonda.candidato.dto.InputDTO;
import br.com.elo7.sonda.candidato.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Probe toProbe(ProbeDTO probeDto, Planet planet) {

        Probe probe = new Probe();
        probe.setPlanet(planet);
        probe.setX(probeDto.getX());
        probe.setY(probeDto.getY());
        probe.setDirection(probeDto.getDirection());
        return probe;
    }

    public Planet InputDTOToPlanet(InputDTO input) {
        Planet planet = new Planet();
        planet.setHeight(input.getHeight());
        planet.setWidth(input.getWidth());
        return planet;
    }

}
