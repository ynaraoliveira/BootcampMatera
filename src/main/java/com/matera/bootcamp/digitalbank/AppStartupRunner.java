package com.matera.bootcamp.digitalbank;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class AppStartupRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("AppStartupRunner");
		
	}

}
