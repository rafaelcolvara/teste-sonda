package br.com.elo7.sonda.candidato.controller;

import br.com.elo7.sonda.candidato.dto.PlanetDTO;
import br.com.elo7.sonda.candidato.dto.ProbesOnPlanetDTO;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/planet")
public class PlanetController {

    @Autowired
    PlanetService planetService;

    @PostMapping("/save")
    public ResponseEntity<Planet> registerPlanet(@RequestBody PlanetDTO planetDTO) {
        return ResponseEntity.ok(planetService.savePlanet(planetDTO));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Planet> getPlanet(@PathVariable Integer id) {
        return ResponseEntity.ok(planetService.getPlanetById(id));
    }

    @PutMapping("/setProbes")
    public ResponseEntity<Planet> setProbe(@RequestBody ProbesOnPlanetDTO probesOnPlanetDTO ) throws Exception {
        return ResponseEntity.ok(planetService.setProbe(probesOnPlanetDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Planet>> getAllPlanets() {
        return ResponseEntity.ok(planetService.getAllPlanets());
    }

}
