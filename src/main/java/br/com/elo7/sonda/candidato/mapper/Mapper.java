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


    public Planet toPlanet(PlanetDTO planetDTO ) {
        return new Planet(planetDTO.getWidth(), planetDTO.getHeight());
    }

    public List<Probe> toListProbe(List<ProbeDTO> probeDTOList) {

        return probeDTOList.stream().map(x-> {
             return new Probe(x.getX(), x.getY(), x.getDirection());
        }).collect(Collectors.toList());

    }


}
