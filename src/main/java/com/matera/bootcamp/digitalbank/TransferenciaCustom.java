package com.matera.bootcamp.digitalbank;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("cliente1")
public class TransferenciaCustom implements Transferencia {

	@Override
	public void transferir() {
		System.out.println("Transferiu de forma customizada");

	}

}
