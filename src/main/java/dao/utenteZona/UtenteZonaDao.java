package dao.utenteZona;

import java.util.List;

import dao.IBaseDao;
import jakarta.persistence.EntityManager;
import model.UtenteZona;

public class UtenteZonaDao implements IBaseDao<UtenteZona, Long> {
	
private final EntityManager em;
	
	public UtenteZonaDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<UtenteZona> findAll() {
		return this.em.createQuery("FROM utente", UtenteZona.class).getResultList();
	}

	@Override
	public UtenteZona findById(Long id) {
		return this.em.find(UtenteZona.class, id);
	}

	@Override
	public void persist(UtenteZona elemento) {
		this.em.persist(elemento);
		
	}

	@Override
	public UtenteZona merge(UtenteZona elemento) {
		return this.em.merge(elemento);
	}

	@Override
	public void remove(UtenteZona daCancellare) {
		this.em.remove(daCancellare);
		
	}
	
}
