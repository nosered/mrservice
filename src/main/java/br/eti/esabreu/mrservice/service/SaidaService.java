package br.eti.esabreu.mrservice.service;

import java.util.List;

import br.eti.esabreu.mrservice.model.Saida;

public interface SaidaService {

	void salvar(Saida saida);
	void remover(Integer idSaida);
	Saida buscar(Integer idSaida);
	List<Saida> buscar();
}
