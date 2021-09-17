package com.matera.bootcamp.digitalbank.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.matera.bootcamp.digitalbank.entity.Cliente;
import com.matera.bootcamp.digitalbank.entity.Conta;
import com.matera.bootcamp.digitalbank.repository.ContaRepository;

@Service
public class ContaService {

	private ContaRepository contaRepository;

	public ContaService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	public Conta cadastra(Cliente cliente) {
		valida(cliente);
		
		Conta conta = new Conta(180, cliente.getTelefone(), BigDecimal.ZERO, "A", cliente, null);
		
		return contaRepository.save(conta);
	}

	private void valida(Cliente cliente) {
		if (contaRepository.findByNumeroConta(cliente.getTelefone()).isPresent()) {
			throw new RuntimeException(
					"Ja existe uma conta com o número de telefone informado. Telefone: " + cliente.getTelefone());
		}

	}

}
