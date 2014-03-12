package br.ufc.quixada.npi.ui;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.ufc.quixada.npi.model.Pessoa;
import br.ufc.quixada.npi.service.PessoaService;


public class Main3 {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PessoaService cs = (PessoaService)ctx.getBean("pessoaServiceImpl");
		try {
			cs.inserir();
		} catch (Exception e) {
			System.out.println("Não foi possível realizar a inserção");
		}
		
		List<Pessoa> pessoas = cs.findAll();

	    for (Pessoa p : pessoas) {
	    	System.out.println(p);
	    }
		ctx.close();
	}
	
}
