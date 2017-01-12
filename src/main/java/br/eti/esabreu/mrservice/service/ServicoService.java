package br.eti.esabreu.mrservice.service;

import java.util.List;

import br.eti.esabreu.mrservice.model.Servico;

public interface ServicoService {

	void salvar(Servico servico);
	void remover(Integer idServico);
	Servico buscar(Integer idServico);
	List<Servico> buscar();
}
