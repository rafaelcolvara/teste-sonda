package br.com.elo7.sonda.candidato.service;

import br.com.elo7.sonda.candidato.model.Direction;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProbeServiceTest {

	@Autowired
	private ProbeService subject;

	Planet planet = new Planet(10, 10);
	Probe probe = new Probe(0,0,Direction.S, planet);
	@Test
	public void should_change_probe_direction_from_N_To_W_when_receive_the_command_L() {

		probe.setDirection(Direction.N);
		subject.applyCommandToProbe(probe, 'L');
		assertEquals(Direction.W, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_W_To_S_when_receive_the_command_L() {

		probe.setDirection(Direction.W);
		subject.applyCommandToProbe(probe, 'L');
		assertEquals(Direction.S, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_S_To_E_when_receive_the_command_L() {

		probe.setDirection(Direction.S);
		subject.applyCommandToProbe(probe, 'L');
		assertEquals(Direction.E, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_E_To_N_when_receive_the_command_L() {

		probe.setDirection(Direction.E);
		subject.applyCommandToProbe(probe, 'L');
		assertEquals(Direction.N, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_N_To_E_when_receive_the_command_R() {

		probe.setDirection(Direction.N);
		subject.applyCommandToProbe(probe, 'R');
		assertEquals(Direction.E, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_E_To_S_when_receive_the_command_R() {

		probe.setDirection(Direction.E);
		subject.applyCommandToProbe(probe, 'R');
		assertEquals(Direction.S, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_S_To_W_when_receive_the_command_R() {

		probe.setDirection(Direction.S);
		subject.applyCommandToProbe(probe, 'R');
		assertEquals(Direction.W, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_W_To_N_when_receive_the_command_R() {

		probe.setDirection(Direction.W);
		subject.applyCommandToProbe(probe, 'R');
		assertEquals(Direction.N, probe.getDirection());
	}

	@Test
	public void should_change_probe_position_from_1_1_N_To_1_2_N_when_receive_the_command_M() {

		probe.setX(1);
		probe.setY(1);
		probe.setDirection(Direction.N);
		subject.applyCommandToProbe(probe, 'M');
		assertEquals(2, probe.getY());
		assertEquals(1, probe.getX());
		assertEquals(Direction.N, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_S_To_1_0_S_when_receive_the_command_M() {

		probe.setX(1);
		probe.setY(1);
		probe.setDirection(Direction.S);
		subject.applyCommandToProbe(probe, 'M');
		assertEquals(0, probe.getY());
		assertEquals(1, probe.getX());
		assertEquals(Direction.S, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_W_To_0_1_W_when_receive_the_command_M() {

		probe.setX(1);
		probe.setY(1);
		probe.setDirection(Direction.W);
		subject.applyCommandToProbe(probe, 'M');
		assertEquals(0, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals(Direction.W, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_E_To_2_1_E_when_receive_the_command_M() {

		probe.setX(1);
		probe.setY(1);
		probe.setDirection(Direction.E);
		subject.applyCommandToProbe(probe, 'M');
		assertEquals(2, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals(Direction.E, probe.getDirection());
	}
}
