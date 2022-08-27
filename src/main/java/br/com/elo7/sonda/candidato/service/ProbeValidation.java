package br.com.elo7.sonda.candidato.service;

import br.com.elo7.sonda.candidato.model.Probe;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ProbeValidation {

    public Boolean validMoveProbe(Probe probe, int newX, int newY) {
        return !(((probe.getPlanet().getHeight() <= newX) || (probe.getPlanet().getWidth() <= newY)) || (newX < 0 || newY < 0));
    }

    public Boolean checkColisionProbes(Probe probe){

        List<Probe> probeList = probe.getPlanet().getProbeList()
                .stream().filter(
                        probe1 -> !probe1.equals(probe)
                ).collect(Collectors.toList());

        probeList.stream().forEach(x -> System.out.println(x.getY()));

        return false;
    }
}
