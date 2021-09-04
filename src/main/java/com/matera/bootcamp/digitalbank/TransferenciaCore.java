package com.matera.bootcamp.digitalbank;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("core")
public class TransferenciaCore implements Transferencia {

	@Override
	public void transferir() {
		System.out.println("Transferencia feita pelo core");
		
	}

}
