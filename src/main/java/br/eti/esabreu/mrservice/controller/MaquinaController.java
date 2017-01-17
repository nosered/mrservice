package br.eti.esabreu.mrservice.controller;

import static br.eti.esabreu.mrservice.util.PageConstantes.FORM_MAQUINA;
import static br.eti.esabreu.mrservice.util.RedirectConstantes.REDIRECT_DETALHES_CLIENTE;
import static br.eti.esabreu.mrservice.util.RedirectConstantes.REDIRECT_LISTAR_CLIENTES;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.eti.esabreu.mrservice.model.Cliente;
import br.eti.esabreu.mrservice.model.Maquina;
import br.eti.esabreu.mrservice.service.ClienteService;
import br.eti.esabreu.mrservice.service.MaquinaService;

@Controller
@RequestMapping(value = "/maquina")
public class MaquinaController {

	@Autowired
	private MaquinaService maquinaService;
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/form/{idCliente}")
	public ModelAndView form(Maquina maquina, @PathVariable("idCliente") Integer idCliente) {
		
		Cliente cliente = clienteService.buscar(idCliente);
		ModelAndView mView = new ModelAndView(FORM_MAQUINA);
		mView.addObject("maquina", maquina);
		mView.addObject("cliente", cliente);
		return mView;
	}

	@PostMapping("/salvar/{idCliente}")
	public ModelAndView salvar(@ModelAttribute("maquina") Maquina maquina, @PathVariable("idCliente") Integer idCliente) {
		
		Cliente cliente = clienteService.buscar(idCliente);
		maquina.setCliente(cliente);
		ModelAndView mView = new ModelAndView(REDIRECT_LISTAR_CLIENTES);
		maquinaService.salvar(maquina);
		return mView;
	}

	@GetMapping("/editar/{idMaquina}")
	public ModelAndView editar(@PathVariable("idMaquina") Maquina maquina) {
		return form(maquina, maquina.getId());
	}

	@GetMapping("/remover/{idMaquina}")
	public ModelAndView remover(@PathVariable("idMaquina") Integer idMaquina) {
		ModelAndView mView = new ModelAndView(REDIRECT_DETALHES_CLIENTE);
		maquinaService.remover(idMaquina);
		return mView;
	}

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mView = new ModelAndView(REDIRECT_DETALHES_CLIENTE);
		mView.addObject("maquinaList", maquinaService.buscar());
		return mView;
	}
}
