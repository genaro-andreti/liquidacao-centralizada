package br.com.sicredi.liquidacao.scheduler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.sicredi.liquidacao.handler.LiquidacaoCentralizadaHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProcessFilesSheduler {
	
	@Autowired
	private LiquidacaoCentralizadaHandler liquidacaoCentralizadaHandler;
	
	//método inicia o processamento 1 minuto após a anicialização e depois roda a cada hora
    @Scheduled(fixedDelay = 3600000, initialDelay = 1000)
    private void handleFiles() throws IOException {
    	
    	log.info("Iniciando a rotina de processamento do arquivo");
    	
    	liquidacaoCentralizadaHandler.processFile();
    	
    	log.info("Finalizando a rotina de processamento do arquivo");
    }

}
