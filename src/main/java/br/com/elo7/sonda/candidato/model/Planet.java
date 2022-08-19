package br.com.elo7.sonda.candidato.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Planet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_planeta")
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

	@OneToMany(mappedBy = "planet", fetch = FetchType.EAGER, cascade = CascadeType.ALL )
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

	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}

}
