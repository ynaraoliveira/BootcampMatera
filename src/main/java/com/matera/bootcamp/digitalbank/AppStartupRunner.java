package com.matera.bootcamp.digitalbank;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.matera.bootcamp.digitalbank.entity.Cliente;
import com.matera.bootcamp.digitalbank.repository.ClienteRepository;
import com.matera.bootcamp.digitalbank.service.ClienteService;

@Component
public class AppStartupRunner implements ApplicationRunner {
	
	ClienteRepository clienteRepository;
	ClienteService clienteService;
	
	public AppStartupRunner(ClienteRepository clienteRepository, ClienteService clienteService) {
		this.clienteRepository = clienteRepository;
		this.clienteService = clienteService;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
//		Cria registro no banco de dados
		Cliente cliente = new Cliente("Ana", "1245678901", 98764253L, new BigDecimal(1000), 
				"Rua dos Ipes", 43, "Casa", "Jardim Florido", "Hortolândia", "MG", "04512356", null);
		clienteRepository.save(cliente);
		
		Cliente cliente2 = clienteRepository.findByCpf("1245678901").orElse(null);
		System.out.println("Cliente 2: " + cliente2);
		
		Cliente cliente3 = clienteRepository.buscaPorCpf("1245678901").orElse(null);
		System.out.println("Cliente 3: " + cliente3);
		
		Cliente cliente4 = clienteRepository.buscaPorCpfENome("1245678901", "Ana").orElse(null);
		System.out.println("Cliente 4: " + cliente4);
		
		Cliente cliente5 = clienteRepository.buscaPorCpfNativeQuery("1245678901").orElse(null);
		System.out.println("Cliente 5: " + cliente5);
		
		Cliente cliente6 = clienteRepository.findByCpfAndNome("1245678901", "Ana").orElse(null);
		System.out.println("Cliente 6: " + cliente6);
		
		clienteService.print();
		
	}
	
}
