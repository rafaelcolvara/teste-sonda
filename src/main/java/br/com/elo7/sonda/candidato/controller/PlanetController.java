package br.com.elo7.sonda.candidato.controller;

import br.com.elo7.sonda.candidato.dto.PlanetDTO;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/planet")
public class PlanetController {

    @Autowired
    PlanetService planetService;

    @PostMapping
    public ResponseEntity<Planet> registerPlanet(@RequestBody PlanetDTO planetDTO) {
        return ResponseEntity.ok(planetService.savePlanet(planetDTO));
    }

    @GetMapping
    public ResponseEntity<Planet> getPlanet(@RequestParam Integer id) {
        return ResponseEntity.ok(planetService.getPlanetById(id));
    }


}
