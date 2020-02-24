package br.com.sicredi.liquidacao.handler;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;

import br.com.sicredi.liquidacao.model.Doc;
import br.com.sicredi.liquidacao.repository.DocRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LiquidacaoCentralizadaHandler {

	@Value(value = "${file.path.in.name}")
	private String filePathInName;

	@Autowired
	private DocRepository liquidacaoCentralizadaRepository;

	public void processFile() throws IOException {
		log.info("Inicio do processamento do arquivo");

		FileReader reader = new FileReader(filePathInName);

		XStream xstream = new XStream();
		xstream.allowTypesByRegExp(new String[] { ".*" });
		xstream.processAnnotations(Doc.class);
		
		log.info("Iniciando a conversão do arquivo para o objeto Doc");
		
		Doc doc = (Doc) xstream.fromXML(reader);
		
		log.info("Finalizando a conversão do arquivo para o objeto Doc");

		
		log.info("Iniciando a persistência do objeto convertido na base de dados.");
		
		liquidacaoCentralizadaRepository.save(doc);
		
		log.info("Persistência do objeto convertido na base de dados finalizada, documento salvo: {}", doc);
		
		log.info("Fim do processamento, documento salvo com sucesso");

	}
}
