package br.eti.esabreu.mrservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.mrservice.model.Cliente;
import br.eti.esabreu.mrservice.repository.ClienteRepository;
import br.eti.esabreu.mrservice.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	@Override
	public void remover(Integer idCliente) {
		clienteRepository.delete(idCliente);
	}
	
	@Override
	public Cliente buscar(Integer idCliente) {
		return clienteRepository.findOne(idCliente);
	}

	@Override
	public List<Cliente> buscar() {
		return clienteRepository.findAll();
	}

}
