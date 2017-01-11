package br.eti.esabreu.mrservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.eti.esabreu.mrservice.model.Cliente;
import br.eti.esabreu.mrservice.service.ClienteService;

import static br.eti.esabreu.mrservice.util.PageConstantes.FORM_CLIENTE;
import static br.eti.esabreu.mrservice.util.PageConstantes.LISTAR_CLIENTES;
import static br.eti.esabreu.mrservice.util.PageConstantes.DETALHES_CLIENTE;
import static br.eti.esabreu.mrservice.util.RedirectConstantes.REDIRECT_LISTAR_CLIENTES;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/form")
	public ModelAndView form(Cliente cliente) {
		ModelAndView mView = new ModelAndView(FORM_CLIENTE);
		mView.addObject("cliente", cliente);
		return mView;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@ModelAttribute("cliente") Cliente cliente) {
		ModelAndView mView = new ModelAndView(REDIRECT_LISTAR_CLIENTES);
		clienteService.salvar(cliente);
		return mView;
	}
	
	@GetMapping("/editar/{idCliente}")
	public ModelAndView editar(@PathVariable("idCliente") Cliente cliente) {
		return form(cliente);
	}
	
	@GetMapping("/remover/{idCliente}")
	public ModelAndView remover(@PathVariable("idCliente") Integer idCliente) {
		ModelAndView mView = new ModelAndView(REDIRECT_LISTAR_CLIENTES);
		clienteService.remover(idCliente);
		return mView;
	}
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mView = new ModelAndView(LISTAR_CLIENTES);
		mView.addObject("clienteList", clienteService.buscar());
		return mView;
	}
	
	@GetMapping("/detalhes/{idCliente}")
	public ModelAndView detalhes(@PathVariable("idCliente") Cliente cliente) {
		ModelAndView mView = new ModelAndView(DETALHES_CLIENTE);
		mView.addObject("cliente", cliente);
		return mView;
	}
}