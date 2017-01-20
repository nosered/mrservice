package br.eti.esabreu.mrservice.controller;

import static br.eti.esabreu.mrservice.util.PageConstantes.DETALHES_OS;
import static br.eti.esabreu.mrservice.util.PageConstantes.FORM_OS;
import static br.eti.esabreu.mrservice.util.PageConstantes.LISTAR_OS;
import static br.eti.esabreu.mrservice.util.RedirectConstantes.REDIRECT_LISTAR_OS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.eti.esabreu.mrservice.model.OrdemServico;
import br.eti.esabreu.mrservice.model.OrdemServico.Status;
import br.eti.esabreu.mrservice.model.OrdemServico.Tipo;
import br.eti.esabreu.mrservice.service.ClienteService;
import br.eti.esabreu.mrservice.service.ItemService;
import br.eti.esabreu.mrservice.service.MaquinaService;
import br.eti.esabreu.mrservice.service.OrdemServicoService;
import br.eti.esabreu.mrservice.service.ServicoService;
import br.eti.esabreu.mrservice.service.TecnicoService;

@Controller
@RequestMapping(value = "/ordemServico")
public class OrdemServicoController {
	
	@Autowired
	private OrdemServicoService ordemServicoService;
	@Autowired
	private ClienteService  clienteService;
	@Autowired
	private MaquinaService maquinaService;
	@Autowired
	private ServicoService servicoService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private TecnicoService tecnicoService;
		
	@GetMapping("/form")
	public ModelAndView form(OrdemServico ordemServico) {
		ModelAndView mView = new ModelAndView(FORM_OS);
		
		mView.addObject("ordemServico", ordemServico);
		mView.addObject("tiposList", Tipo.values());
		mView.addObject("statusList", Status.values());
		mView.addObject("clientesList", clienteService.buscar());
		mView.addObject("maquinasList", maquinaService.buscar());
		mView.addObject("servicosList", servicoService.buscar());
		mView.addObject("itensList", itemService.buscar());
		mView.addObject("tecnicosList", tecnicoService.buscar());
		return mView;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@ModelAttribute("ordemServico") OrdemServico ordemServico) {
		ModelAndView mView = new ModelAndView();
		ordemServicoService.salvar(ordemServico);
		mView.setViewName(REDIRECT_LISTAR_OS);
		return mView;
	}
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mView = new ModelAndView(LISTAR_OS);
		mView.addObject("ordemServicoList", ordemServicoService.buscar());
		return mView;
	}
	
	@GetMapping("/editar/{idOrdemServico}")
	public ModelAndView editar(@PathVariable("idOrdemServico") OrdemServico ordemServico) {
		return form(ordemServico);
	}
	
	@GetMapping("/remover/{idOrdemServico}")
	public ModelAndView remover(@PathVariable("idOrdemServico") Integer idOrdemServico) {
		ModelAndView mView = new ModelAndView(REDIRECT_LISTAR_OS);
		ordemServicoService.remover(idOrdemServico);
		return mView;
	}
	
	@GetMapping("/detalhes/{idOrdemServico}")
	public ModelAndView detalhes(@PathVariable("idOrdemServico") OrdemServico ordemServico) {
		ModelAndView mView = new ModelAndView(DETALHES_OS);
		mView.addObject("ordemServico", ordemServico);
		return mView;
	}
	
	@GetMapping("/agendar")
	public String formAgendarVisita(){
		return "ordemServico/agendar-visita";
	}
	
	@GetMapping("/abrir")
	public String formAbrirOS(){
		return "ordemServico/abrir-os";
	}
	
	@GetMapping("/agendamentos")
	public String listarAgendamentos(){
		return "listar-agendamentos";
	}
	
	
}
