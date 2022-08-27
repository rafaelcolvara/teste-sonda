package br.com.elo7.sonda.candidato.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
public class Probe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private int x;
	@Column
	private int y;
	@Column
	@Enumerated(EnumType.STRING)
	private Direction direction;

	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "id_planeta")
	@JsonIgnoreProperties("probeList")
	private Planet planet;

	public Probe() {
	}

	public Probe(int x, int y, Direction direction, Planet planet) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.planet = planet;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
}
