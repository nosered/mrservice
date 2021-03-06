package br.eti.esabreu.mrservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eti.esabreu.mrservice.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	public List<Item> findAllByNomeContaining(String nome);
}
