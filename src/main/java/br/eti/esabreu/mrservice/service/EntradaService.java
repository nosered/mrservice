package br.eti.esabreu.mrservice.service;

import java.util.List;

import br.eti.esabreu.mrservice.model.Entrada;

public interface EntradaService {

	void salvar(Entrada entrada);
	void remover(Integer idEntrada);
	Entrada buscar(Integer idEntrada);
	List<Entrada> buscar();
}
