package br.ufc.quixada.npi.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.quixada.npi.model.Contato;
import br.ufc.quixada.npi.model.Pessoa;
import br.ufc.quixada.npi.repository.PessoaRepository;

@Repository
public class JpaPessoaRepositoryImp implements PessoaRepository {

	@PersistenceContext
	private EntityManager em;

	/* (non-Javadoc)
	 * @see br.ufc.quixada.npi.repository.jpa.PessoaRepository#save(br.ufc.quixada.npi.model.Pessoa)
	 */
	public void save(Pessoa p) {
		if (p.getId() == null) {
			em.persist(p);
		} else {
			em.merge(p);
		}
	}

	/* (non-Javadoc)
	 * @see br.ufc.quixada.npi.repository.jpa.PessoaRepository#findAll()
	 */
	public List<Pessoa> findAll() {
		return em.createQuery("from Pessoa", Pessoa.class).getResultList();
	}

}
