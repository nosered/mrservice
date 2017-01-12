package br.eti.esabreu.mrservice.service;

import java.util.List;

import br.eti.esabreu.mrservice.model.Item;

public interface ItemService {
	void salvar(Item item);
	void remover(Integer idItem);
	Item buscar(Integer idItem);
	List<Item> buscar();
}
