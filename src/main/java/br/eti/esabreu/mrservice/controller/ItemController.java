package br.eti.esabreu.mrservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.eti.esabreu.mrservice.model.Item;
import br.eti.esabreu.mrservice.service.ItemService;

import static br.eti.esabreu.mrservice.util.PageConstantes.FORM_ITEM;
import static br.eti.esabreu.mrservice.util.PageConstantes.LISTAR_ITENS;
import static br.eti.esabreu.mrservice.util.PageConstantes.DETALHES_ITEM;
import static br.eti.esabreu.mrservice.util.RedirectConstantes.REDIRECT_LISTAR_ITENS;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/form")
	public ModelAndView form(Item item) {
		ModelAndView mView = new ModelAndView(FORM_ITEM);
		mView.addObject("tipos", Item.Tipo.values());
		mView.addObject("condicoes", Item.Condicao.values());
		mView.addObject("item", item);
		return mView;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@ModelAttribute Item item) {
		ModelAndView mView = new ModelAndView(REDIRECT_LISTAR_ITENS);
		itemService.salvar(item);
		return mView;
	}
	
	@GetMapping("/editar/{idItem}")
	public ModelAndView editar(@PathVariable("idItem") Item item) {
		return form(item);
	}
	
	@GetMapping("/remover/{idItem}")
	public ModelAndView remover(@PathVariable("idItem") Integer idItem) {
		ModelAndView mView = new ModelAndView(REDIRECT_LISTAR_ITENS);
		itemService.remover(idItem);
		return mView;
	}
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mView = new ModelAndView(LISTAR_ITENS);
		mView.addObject("itens", itemService.buscar());
		return mView;
	}
	
	@GetMapping("/detalhes/{idItem}")
	public ModelAndView detalhes(@PathVariable("idItem") Item item) {
		ModelAndView mView = new ModelAndView(DETALHES_ITEM);
		mView.addObject("item", item);
		return mView;
	}
}
