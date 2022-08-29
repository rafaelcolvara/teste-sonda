package br.com.elo7.sonda.candidato.dto;

import java.util.HashMap;

public class InputDTO {

	private int idPlanet; //x

	private HashMap<Integer, String> probesWithCommands;

	public HashMap<Integer, String> getProbesWithCommands() {
		return probesWithCommands;
	}
}
