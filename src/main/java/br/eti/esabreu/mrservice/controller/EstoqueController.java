package br.eti.esabreu.mrservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import br.eti.esabreu.mrservice.model.Entrada;
import br.eti.esabreu.mrservice.model.Item;
import br.eti.esabreu.mrservice.model.Saida;
import br.eti.esabreu.mrservice.service.EntradaService;
import br.eti.esabreu.mrservice.service.ItemService;
import br.eti.esabreu.mrservice.service.SaidaService;

import static br.eti.esabreu.mrservice.util.PageConstantes.FORM_ENTRADA;
import static br.eti.esabreu.mrservice.util.PageConstantes.FORM_SAIDA;
import static br.eti.esabreu.mrservice.util.PageConstantes.LISTAR_ENTRADAS;
import static br.eti.esabreu.mrservice.util.PageConstantes.LISTAR_SAIDAS;
import static br.eti.esabreu.mrservice.util.RedirectConstantes.REDIRECT_LISTAR_ENTRADAS;
import static br.eti.esabreu.mrservice.util.RedirectConstantes.REDIRECT_LISTAR_SAIDAS;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EntradaService entradaService;
	
	@Autowired
	private SaidaService saidaService;
	
	@Autowired
	private ItemService itemService;
	
	@InitBinder
	public void registerCustomEditors(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, NumberFormat.getNumberInstance(new Locale("pt","BR")),true));
	}
	
	@GetMapping("/entrada/form")
	public ModelAndView formEntrada(Entrada entrada) {
		ModelAndView mView = new ModelAndView(FORM_ENTRADA);
		mView.addObject("entrada", entrada);
		return mView;
	}
	
	@GetMapping("/saida/form")
	public ModelAndView formSaida(Saida saida) {
		ModelAndView mView = new ModelAndView(FORM_SAIDA);
		mView.addObject("saida", saida);
		mView.addObject("itens", itemService.buscar());
		return mView;
	}
	
	@PostMapping("/entrada/salvar")
	public ModelAndView salvarEntrada(@ModelAttribute("entrada") Entrada entrada, @RequestParam("idItem") Item item) {
		ModelAndView mView = new ModelAndView(REDIRECT_LISTAR_ENTRADAS);
		entrada.setItem(item);
		entradaService.salvar(entrada);
		return mView;
	}
	
	@PostMapping("/saida/salvar")
	public ModelAndView salvarSaida(@ModelAttribute("saida") Saida saida) {
		ModelAndView mView = new ModelAndView(REDIRECT_LISTAR_SAIDAS);
		saidaService.salvar(saida);
		return mView;
	}
	
	@GetMapping("/entrada/remover/{idEntrada}")
	public ModelAndView removerEntrada(@PathVariable("idEntrada") Integer idEntrada) {
		ModelAndView mView = new ModelAndView(REDIRECT_LISTAR_ENTRADAS);
		entradaService.remover(idEntrada);
		return mView;
	}
	
	@GetMapping("/saida/remover/{idSaida}")
	public ModelAndView removerSaida(@PathVariable("idSaida") Integer idSaida) {
		ModelAndView mView = new ModelAndView(REDIRECT_LISTAR_SAIDAS);
		saidaService.remover(idSaida);
		return mView;
	}
	
	@GetMapping("/entrada/listar")
	public ModelAndView listarEntradas() {
		ModelAndView mView = new ModelAndView(LISTAR_ENTRADAS);
		mView.addObject("entradas", entradaService.buscar());
		return mView;
	}
	
	@GetMapping("/saida/listar")
	public ModelAndView listarSaidas() {
		ModelAndView mView = new ModelAndView(LISTAR_SAIDAS);
		mView.addObject("saidas", saidaService.buscar());
		return mView;
	}
}
