package br.eti.esabreu.mrservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.mrservice.model.Item;
import br.eti.esabreu.mrservice.repository.ItemRepository;
import br.eti.esabreu.mrservice.service.ItemService;

@Service
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
	
	@Override
	public List<Item> buscarPorNome(String nome) {
		nome = nome.toUpperCase();
		return itemRepository.findAllByNomeContaining(nome);
	}
}
