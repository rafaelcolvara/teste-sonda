package br.com.elo7.sonda.candidato.mapper;

import br.com.elo7.sonda.candidato.dto.InputDTO;
import br.com.elo7.sonda.candidato.dto.PlanetDTO;
import br.com.elo7.sonda.candidato.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.model.Direction;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public Probe toProbe(ProbeDTO probeDto, Planet planet) {

        Probe probe = new Probe(probeDto.getX(), probeDto.getY(), probeDto.getDirection(), planet);
        return probe;
    }

    public Planet inputDTOToPlanet(InputDTO input) {
        Planet planet = new Planet(input.getWidth(), input.getHeight() );
        planet.setProbeList(toListProbes(input.getProbes(),planet));
        return planet;
    }

    private List<Probe> toListProbes(List<ProbeDTO> probeDTOList, Planet planet) {
        return  probeDTOList.stream().map(x -> new Probe(x.getX(), x.getY(), x.getDirection(), planet)).collect(Collectors.toList());

    }

    public Planet toPlanet(PlanetDTO planetDTO ) {
        return new Planet(planetDTO.getWidth(), planetDTO.getHeight());

    }

}
