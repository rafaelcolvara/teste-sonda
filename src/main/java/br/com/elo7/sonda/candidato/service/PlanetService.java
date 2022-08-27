package br.com.elo7.sonda.candidato.service;

import br.com.elo7.sonda.candidato.dto.PlanetDTO;
import br.com.elo7.sonda.candidato.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.dto.ProbesOnPlanetDTO;
import br.com.elo7.sonda.candidato.mapper.Mapper;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.persistence.Planets;
import br.com.elo7.sonda.candidato.persistence.Probes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    @Autowired
    private Planets planets;

    @Autowired
    private ProbeService ProbeService;

    @Autowired
    private Probes probes;


    @Autowired
    private Mapper mapper;

    public Planet savePlanet(PlanetDTO planetDTO){
       return planets.save(mapper.toPlanet(planetDTO));
    }

    public Planet getPlanetById(Integer id) {
        return planets.getById(id);
    }

    public Planet setProbe(ProbesOnPlanetDTO probesOnPlanetDTO) throws Exception {

        List<Probe> probeList = probes.findAllById(probesOnPlanetDTO.getIdProbes());
        Planet planet = planets.findById(probesOnPlanetDTO.getIdPlanet()).orElseThrow(() -> new Exception("Planeta " +probesOnPlanetDTO.getIdPlanet() + "Não encontrado "));
        planet.setProbeList(probeList);
        return planets.save(planet);
    }

    public List<Planet> getAllPlanets() {

        return planets.findAll();
    }


}
