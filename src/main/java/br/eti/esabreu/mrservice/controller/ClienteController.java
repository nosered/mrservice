package br.eti.esabreu.mrservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.eti.esabreu.mrservice.model.Cliente;
import br.eti.esabreu.mrservice.service.ClienteService;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cadastrar")
	public ModelAndView formCadastrarCliente(){
		ModelAndView mView = new ModelAndView("cadastrar-cliente");
		mView.addObject("cliente", new Cliente());
		return mView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrarCliente(@ModelAttribute("cliente") Cliente cliente){
		ModelAndView mView = new ModelAndView();
		mView.setView(new RedirectView("/cliente/listar"));
		clienteService.salvar(cliente);
		return mView;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarCliente(){
		ModelAndView mView = new ModelAndView("listar-clientes");
		mView.addObject("clienteList", clienteService.buscar());
		return mView;
	}
	
	@GetMapping("/detalhes/{idCliente}")
	public ModelAndView detalhesCliente(Model model, @PathVariable("idCliente") Cliente cliente){
		ModelAndView mView = new ModelAndView("detalhes-cliente");
		mView.addObject("cliente", cliente);
		return mView;
	}
}