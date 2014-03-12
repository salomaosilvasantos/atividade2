package br.ufc.quixada.npi.web;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.ufc.quixada.npi.model.Pessoa;
import br.ufc.quixada.npi.service.PessoaService;

@ManagedBean
public class PessoaController {

	private static ClassPathXmlApplicationContext ctx;
	private static PessoaService cs;
	private List<Pessoa> pessoas;

	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		cs = (PessoaService) ctx.getBean("pessoaServiceImpl");
	}

	public PessoaController() {
		super();

	}

	public void inserir() {
		try {
			cs.inserir();
		} catch (Exception e) {
			System.out.println("Não foi possível realizar a inserção");
		}

	}

	public List<Pessoa> listar() {

		this.pessoas = cs.findAll();

		return this.pessoas;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
