package dao.utente;

import java.util.List;

import dao.IBaseDao;
import jakarta.persistence.EntityManager;
import model.Utente;

public class UtenteDao implements IBaseDao<Utente, Long> {
	
	private final EntityManager em;
	
	public UtenteDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Utente> findAll() {
		return this.em.createQuery("FROM utente", Utente.class).getResultList();
	}

	@Override
	public Utente findById(Long id) {
		return this.em.find(Utente.class, id);
	}

	@Override
	public void persist(Utente elemento) {
		this.em.persist(elemento);
		
	}

	@Override
	public Utente merge(Utente elemento) {
		return this.em.merge(elemento);
	}

	@Override
	public void remove(Utente daCancellare) {
		this.em.remove(daCancellare);
		
	}

}
