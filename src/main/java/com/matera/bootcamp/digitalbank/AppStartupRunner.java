package com.matera.bootcamp.digitalbank;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {
	
	Printer printer;
	
	public AppStartupRunner(Printer printer) {
		this.printer = printer;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		printer.print();
		
	}

}
