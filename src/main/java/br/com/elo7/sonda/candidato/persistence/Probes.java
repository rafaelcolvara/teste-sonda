package br.com.elo7.sonda.candidato.persistence;

import java.util.Optional;

import br.com.elo7.sonda.candidato.model.Probe;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Probes extends JpaRepository<Probe, Integer> {


}
