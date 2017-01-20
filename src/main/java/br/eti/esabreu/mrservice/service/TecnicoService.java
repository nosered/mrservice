package br.eti.esabreu.mrservice.service;

import java.util.List;

import br.eti.esabreu.mrservice.model.Tecnico;

public interface TecnicoService {

	void salvar(Tecnico tecnico);
	void remover(Integer idTecnico);
	Tecnico buscar(Integer idTecnico);
	List<Tecnico> buscar();
}
