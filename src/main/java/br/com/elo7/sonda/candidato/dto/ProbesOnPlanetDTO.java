package br.com.elo7.sonda.candidato.dto;

import java.util.List;

public class ProbesOnPlanetDTO {

    Integer idPlanet;

    List<Integer> idProbes;

    public Integer getIdPlanet() {
        return idPlanet;
    }

    public List<Integer> getIdProbes() {
        return idProbes;
    }
}
