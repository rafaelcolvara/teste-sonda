package br.com.elo7.sonda.candidato.dto;

import java.util.List;

public class InputDTO {
	private int width; //x
	private int height; //y
	private List<ProbeDTO> probes;

	public InputDTO(int width, int height, List<ProbeDTO> probes) {
		this.height = height;
		this.width = width;
		this.probes = probes;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public List<ProbeDTO> getProbes() {
		return probes;
	}

}
