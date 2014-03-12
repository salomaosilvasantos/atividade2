package br.ufc.quixada.npi.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.npi.model.Pessoa;

public interface PessoaService {

	@Transactional
	public abstract void inserir();

	@Transactional
	public abstract List<Pessoa> findAll();

}