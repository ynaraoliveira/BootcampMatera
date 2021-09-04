package com.matera.bootcamp.digitalbank;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {
	
	Transferencia transferencia;
	
	public AppStartupRunner(Transferencia transferencia) {
		this.transferencia = transferencia;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		transferencia.transferir();
		
	}

}
