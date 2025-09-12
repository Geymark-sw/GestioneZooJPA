package dao.zona;

import java.util.List;

import dao.IBaseDao;
import jakarta.persistence.EntityManager;
import model.Zona;

public class ZonaDao implements IBaseDao<Zona, Long>{
	
private final EntityManager em;
	
	public ZonaDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Zona> findAll() {
		return this.em.createQuery("FROM zona", Zona.class).getResultList();
	}

	@Override
	public Zona findById(Long id) {
		return this.em.find(Zona.class, id);
	}

	@Override
	public void persist(Zona elemento) {
		this.em.persist(elemento);
		
	}

	@Override
	public Zona merge(Zona elemento) {
		return this.em.merge(elemento);
	}

	@Override
	public void remove(Zona daCancellare) {
		this.em.remove(daCancellare);
		
	}

}
