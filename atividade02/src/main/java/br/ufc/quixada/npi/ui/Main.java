package br.ufc.quixada.npi.ui;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.ufc.quixada.npi.model.Contato;
import br.ufc.quixada.npi.service.ContatoService;

public class Main {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContatoService cs = (ContatoService)ctx.getBean("contatoServiceImpl");
		try {
			cs.insere();
		} catch (Exception e) {
			System.out.println("Não foi possível realizar a inserção");
		}
		
		List<Contato> l = cs.findAll();

	    for (Contato c : l) {
	    	System.out.println(c);
	    }
		ctx.close();
	}
	
}
