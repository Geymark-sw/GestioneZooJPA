package dao.animale;

import java.util.List;

import dao.IBaseDao;
import jakarta.persistence.EntityManager;
import model.Animale;

public class AnimaleDao implements IBaseDao<Animale, Long> {
	
private final EntityManager em;
	
	public AnimaleDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Animale> findAll() {
		return this.em.createQuery("FROM animale", Animale.class).getResultList();
	}

	@Override
	public Animale findById(Long id) {
		return this.em.find(Animale.class, id);
	}

	@Override
	public void persist(Animale elemento) {
		this.em.persist(elemento);
		
	}

	@Override
	public Animale merge(Animale elemento) {
		return this.em.merge(elemento);
	}

	@Override
	public void remove(Animale daCancellare) {
		this.em.remove(daCancellare);
		
	}

}
