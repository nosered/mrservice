package br.eti.esabreu.mrservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eti.esabreu.mrservice.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public Usuario findByLogin(String login);
}
