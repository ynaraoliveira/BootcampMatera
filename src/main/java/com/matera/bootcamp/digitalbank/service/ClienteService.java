package com.matera.bootcamp.digitalbank.service;

import org.springframework.stereotype.Service;

import com.matera.bootcamp.digitalbank.entity.Cliente;
import com.matera.bootcamp.digitalbank.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente cadastra(Cliente cliente) {
		validaCadastro(cliente);
		return clienteRepository.save(cliente);
	}

	private void validaCadastro(Cliente cliente) {
		if(clienteRepository.findByCpf(cliente.getCpf()).isPresent()) {
			throw new RuntimeException("Já existe um cliente com esse CPF.");
		}
		
	}

}
