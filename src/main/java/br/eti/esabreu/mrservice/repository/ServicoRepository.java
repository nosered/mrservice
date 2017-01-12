package br.eti.esabreu.mrservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eti.esabreu.mrservice.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer>{

}
