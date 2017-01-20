package br.eti.esabreu.mrservice.service;

import java.util.List;

import br.eti.esabreu.mrservice.model.OrdemServico;

public interface OrdemServicoService {
	
	void salvar(OrdemServico ordemServico); 
	void remover(Integer idOrdemServico);
	OrdemServico buscar(Integer idOrdemServico);
	List<OrdemServico> buscar();

}
