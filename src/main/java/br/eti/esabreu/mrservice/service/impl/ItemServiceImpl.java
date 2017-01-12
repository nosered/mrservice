package br.eti.esabreu.mrservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.eti.esabreu.mrservice.model.Item;
import br.eti.esabreu.mrservice.repository.ItemRepository;
import br.eti.esabreu.mrservice.service.ItemService;

public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void salvar(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void remover(Integer idItem) {
		itemRepository.delete(idItem);
	}

	@Override
	public Item buscar(Integer idItem) {
		return itemRepository.findOne(idItem);
	}

	@Override
	public List<Item> buscar() {
		return itemRepository.findAll();
	}
}
