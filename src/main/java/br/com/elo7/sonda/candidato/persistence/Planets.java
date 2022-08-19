package br.com.elo7.sonda.candidato.persistence;

import java.util.Optional;

import br.com.elo7.sonda.candidato.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Planets extends JpaRepository<Planet, Integer> {

}
