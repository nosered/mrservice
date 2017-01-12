package br.eti.esabreu.mrservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.eti.esabreu.mrservice.model.Servico;
import br.eti.esabreu.mrservice.service.ServicoService;

import static br.eti.esabreu.mrservice.util.PageConstantes.DETALHES_SERVICO;
import static br.eti.esabreu.mrservice.util.PageConstantes.FORM_SERVICO;
import static br.eti.esabreu.mrservice.util.PageConstantes.LISTAR_SERVICOS;
import static br.eti.esabreu.mrservice.util.RedirectConstantes.REDIRECT_LISTAR_SERVICOS;

@Controller
@RequestMapping(value = "/servico")
public class ServicoController {

	@Autowired
	private ServicoService servicoService;
	
	@GetMapping("/form")
	public ModelAndView form(Servico servico) {
		ModelAndView mView = new ModelAndView(FORM_SERVICO);
		mView.addObject("servico", servico);
		return mView;
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(@ModelAttribute("servico") Servico servico) {
		ModelAndView mView = new ModelAndView(REDIRECT_LISTAR_SERVICOS);
		servicoService.salvar(servico);
		return mView;
	}
	
	@GetMapping("/editar/{idServico}")
	public ModelAndView editar(@PathVariable("idServico") Servico servico) {
		return form(servico);
	}

	@GetMapping("/remover/{idServico}")
	public ModelAndView remover(@PathVariable("idServico") Integer idServico) {
		ModelAndView mView = new ModelAndView(REDIRECT_LISTAR_SERVICOS);
		servicoService.remover(idServico);
		return mView;
	}
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mView = new ModelAndView(LISTAR_SERVICOS);
		mView.addObject("servicoList", servicoService.buscar());
		return mView;
	}
	
	@GetMapping("/detalhes/{idServico}")
	public ModelAndView detalhes(@PathVariable("idServico") Servico servico) {
		ModelAndView mView = new ModelAndView(DETALHES_SERVICO);
		mView.addObject("servico", servico);
		return mView;
	}
}
