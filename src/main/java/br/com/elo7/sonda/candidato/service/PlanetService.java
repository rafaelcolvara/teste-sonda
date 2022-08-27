package br.com.elo7.sonda.candidato.service;

import br.com.elo7.sonda.candidato.dto.PlanetDTO;
import br.com.elo7.sonda.candidato.mapper.Mapper;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.persistence.Planets;
import org.springframework.beans.factory.annotation.Autowired;

public class PlanetService {

    @Autowired
    private Planets planets;

    @Autowired
    private Mapper mapper;

    public Planet savePlanet(PlanetDTO planetDTO){
       return planets.save(mapper.toPlanet(planetDTO));
    }

    public Planet getPlanetById(Integer id) {

        return planets.getById(id);

    }
}
