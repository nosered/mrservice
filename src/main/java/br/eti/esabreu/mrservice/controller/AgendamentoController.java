package br.eti.esabreu.mrservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.eti.esabreu.mrservice.model.Agendamento;

@RestController
@RequestMapping("/data")
public class AgendamentoController {
	
	@RequestMapping("/agendamentos")
	public List<Agendamento> buscarAgendamentos() {
		Agendamento a1 = new Agendamento();
		a1.setId(1);
		a1.setTitle("TESTE 1");
		a1.setStart("2017-01-09");
		a1.setEnd("2017-01-09");
		
		Agendamento a2 = new Agendamento();
		a2.setId(2);
		a2.setTitle("TESTE 2");
		a2.setStart("2017-01-10");
		a2.setEnd("2017-01-10");
		
		Agendamento a3 = new Agendamento();
		a3.setId(3);
		a3.setTitle("TESTE 3");
		a3.setStart("2017-01-11");
		a3.setEnd("2017-01-11");
		
		List<Agendamento> agendamentos = new ArrayList<Agendamento>();
		agendamentos.add(a1);
		agendamentos.add(a2);
		agendamentos.add(a3);
		
		return agendamentos;
	}
}
