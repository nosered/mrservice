package br.eti.esabreu.mrservice.service;

import java.util.List;

import br.eti.esabreu.mrservice.model.Cliente;

public interface ClienteService {
	void salvar(Cliente cliente); //Adiciona ou Atualiza cliente existente;
	void remover(Integer idCliente);
	Cliente buscar(Integer idCliente);
	List<Cliente> buscar();
}