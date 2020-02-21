package br.com.sicredi.liquidacao;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LiquidacaoCentralizadaApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(LiquidacaoCentralizadaApplication.class, args);
	}

}
