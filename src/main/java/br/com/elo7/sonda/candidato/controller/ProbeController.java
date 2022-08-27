package br.com.elo7.sonda.candidato.controller;

import br.com.elo7.sonda.candidato.dto.InputDTO;
import br.com.elo7.sonda.candidato.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/probes")
public class ProbeController {
	@Autowired
	private ProbeService probeService;

	@PostMapping("/land")
    public ResponseEntity<List<Probe>> register(@RequestBody InputDTO inputDto) {
		return ResponseEntity.ok(probeService.landProbes(inputDto));

    }

	@PostMapping("/save")
	public ResponseEntity<List<Probe>> saveProbes(@RequestBody List<ProbeDTO> probeDTOList) {
		return ResponseEntity.ok(probeService.saveProbes(probeDTOList));
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Probe>> getAllProbes() {
		return ResponseEntity.ok(probeService.getAllProbes());
	}






}
