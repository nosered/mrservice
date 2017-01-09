package br.eti.esabreu.mrservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdemServicoController {
	
	@GetMapping("/os/agendar")
	public String formAgendarVisita(){
		return "agendar-visita";
	}
	
	@GetMapping("/os/abrir")
	public String formAbrirOS(){
		return "abrir-os";
	}
	
	@GetMapping("/os/agendamentos")
	public String listarAgendamentos(){
		return "listar-agendamentos";
	}
	
	@GetMapping("/os/detalhes")
	public String visualizarDetalhes(){
		return "detalhes-os";
	}
}
