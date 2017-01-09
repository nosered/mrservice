package br.eti.esabreu.mrservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.eti.esabreu.mrservice.model.Usuario;
import br.eti.esabreu.mrservice.repository.UsuarioRepository;

import static br.eti.esabreu.mrservice.util.ExceptionConstantes.USUARIO_NAO_ENCONTRADO_EXCEPTION;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByLogin(login);
		
		if(usuario == null) {
			throw new UsernameNotFoundException(USUARIO_NAO_ENCONTRADO_EXCEPTION);
		}
		
		return usuario;
	}

}
