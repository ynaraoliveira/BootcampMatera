package com.matera.bootcamp.digitalbank;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.matera.bootcamp.digitalbank.entity.Cliente;
import com.matera.bootcamp.digitalbank.service.ClienteService;

@Component
public class AppStartupRunner implements ApplicationRunner {
	
	ClienteService clienteService;
	
	public AppStartupRunner(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Cliente cliente = new Cliente("Ana", "1245678901", 98764253L, new BigDecimal(1000), 
				"Rua dos Ipes", 43, "Casa", "Jardim Florido", "Hortolândia", "MG", "04512356", null);
		
		Cliente clienteCadastrado = clienteService.cadastra(cliente);
		
		System.out.println(clienteCadastrado.getId());
	}
	
}
