package com.matera.bootcamp.digitalbank;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.matera.bootcamp.digitalbank.entity.Cliente;
import com.matera.bootcamp.digitalbank.repository.ClienteRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {
	
	ClienteRepository clienteRepository;
	
	public AppStartupRunner(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
//		Cria registro no banco de dados
		Cliente cliente = new Cliente(null, "Ana", "1245678901", 98764253L, new BigDecimal(1000), 
				"Rua dos Ipes", 43, "Casa", "Jardim Florido", "Hortolândia", "MG", "04512356");
		clienteRepository.save(cliente);
		
	}
	
}
