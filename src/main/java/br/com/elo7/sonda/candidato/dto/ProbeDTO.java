package br.com.elo7.sonda.candidato.dto;

public class ProbeDTO {
	private int x; 
	private int y;
	private char direction;
	private String commands;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public char getDirection() {
		return direction;
	}
	public String getCommands() {
		return commands;
	}
	public void setCommands(String commands) {
		this.commands = commands;
	}
}
