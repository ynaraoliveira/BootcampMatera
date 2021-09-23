package com.matera.bootcamp.digitalbank;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.matera.bootcamp.digitalbank.dto.request.ClienteRequestDTO;
import com.matera.bootcamp.digitalbank.entity.Cliente;
import com.matera.bootcamp.digitalbank.entity.Conta;
import com.matera.bootcamp.digitalbank.service.ClienteService;

@Component
public class AppStartupRunner implements ApplicationRunner {

	private ClienteService clienteService;

	public AppStartupRunner(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		ClienteRequestDTO cliente = ClienteRequestDTO.builder().nome("Ana").cpf("1245678901").telefone(98764253L)
				.rendaMensal(new BigDecimal(1000)).logradouro("Rua dos Ipes").numero(43).complemento("Casa")
				.bairro("Jardim Florido").cidade("Hortolândia").estado("MG").cep("04512356").build();

//		Cadastrando via Service
		Conta conta = clienteService.cadastra(cliente);

//		Consultando por id via Service
		System.out.println("Consulta por id: " + clienteService.consulta(conta.getCliente().getId()));

//		Consulta todos os clientes
		ClienteRequestDTO cliente2 = ClienteRequestDTO.builder().nome("Jose").cpf("1245678922").telefone(98765663L)
				.rendaMensal(new BigDecimal(1000)).logradouro("Rua dos Ipes").numero(43).complemento("Casa")
				.bairro("Jardim Florido").cidade("Hortolândia").estado("MG").cep("04512356").build();

		Cliente cliente2Salvo = clienteService.cadastra(cliente2).getCliente();
		System.out.println("Listar todos os clientes: " + clienteService.consultaTodos());

//		Atualiza cliente
		ClienteRequestDTO dadosAlteracao = ClienteRequestDTO.builder().nome("Jose").cpf("1245678922")
				.telefone(98765663L).rendaMensal(new BigDecimal(2000)).logradouro("Rua dos Ipes").numero(43)
				.complemento("Casa").bairro("Jardim Florido").cidade("Hortolândia").estado("MG").cep("04512356")
				.build();

		clienteService.atualiza(cliente2Salvo.getId(), dadosAlteracao);
		System.out.println("Cliente alterado: " + clienteService.consulta(cliente2Salvo.getId()));
	}

}
