package br.eti.esabreu.mrservice.service;

import java.util.List;

import br.eti.esabreu.mrservice.model.Maquina;

public interface MaquinaService {
	void salvar(Maquina maquina); 
	void remover(Integer idMaquina);
	Maquina buscar(Integer idMaquina);
	List<Maquina> buscar();
}
