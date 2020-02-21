package br.com.sicredi.liquidacao.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.sicredi.liquidacao.model.Doc;

public interface DocRepository extends CrudRepository<Doc, Long>{

}
