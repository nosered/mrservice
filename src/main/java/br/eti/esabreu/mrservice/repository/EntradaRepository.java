package br.eti.esabreu.mrservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eti.esabreu.mrservice.model.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Integer>{

}
