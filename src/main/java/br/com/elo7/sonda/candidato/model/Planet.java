package br.com.elo7.sonda.candidato.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Planet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_planeta")
	@NotNull
	private int id;

	@Column
	private int width;
	@Column
	private int height;

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Planet(int width, int height ) {
		this.width = width;
		this.height = height;
	}

	@OneToMany(mappedBy = "planet", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JsonIgnoreProperties("planet")
	private List<Probe> probeList ;

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Planet) {
			return ((Planet) obj).id == this.id;
		}
		return false;
	}

	public Planet(int id, int width, int height, List<Probe> probeList) {
		this.id = id;
		this.width = width;
		this.height = height;
		this.probeList = probeList;
	}

	public Planet() {};

	public int getId() {
		return id;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public List<Probe> getProbeList() {
		return probeList;
	}

	public void setProbeList(List<Probe> probeList) {
		this.probeList = probeList;
	}
}
