package br.eti.esabreu.mrservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eti.esabreu.mrservice.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
}
