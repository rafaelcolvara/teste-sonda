package br.com.elo7.sonda.candidato.dto;

import br.com.elo7.sonda.candidato.model.Direction;

public class ProbeDTO {
	private int x; 
	private int y;
	private Direction direction;
	private String commands;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public Direction getDirection() {
		return direction;
	}
	public String getCommands() {
		return commands;
	}

}
