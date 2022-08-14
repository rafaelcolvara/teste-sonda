package br.com.elo7.sonda.candidato.dto;

import java.util.List;

public class InputDTO {
	private int width; 
	private int height;
	private List<ProbeDTO> probes;

	public InputDTO(int width, int height, List<ProbeDTO> probes) {
		this.height = height;
		this.width = width;
		this.probes = probes;
	}


}
