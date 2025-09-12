package service.animale;

import java.util.List;

import dao.animale.AnimaleDao;
import jakarta.persistence.EntityManager;
import model.Animale;
import service.IBaseService;

public class AnimaleService implements IBaseService<Animale, Long> {
	
	private final EntityManager em;
	private final AnimaleDao animaleDao;
	
	public AnimaleService(EntityManager em, AnimaleDao animaleDao) {
		this.em = em;
		this.animaleDao = animaleDao;
	}

	@Override
	public Animale findById(Long id) {
		return this.animaleDao.findById(id);
	}

	@Override
	public List<Animale> findAll() {
		return this.animaleDao.findAll();
	}

	@Override
	public void create(Animale elemento) {
		if(elemento.getIdAnimale() == null) {
			try {
				this.em.getTransaction().begin();
				this.animaleDao.persist(elemento);
				this.em.getTransaction().commit();
				
			}catch(Exception e) {
				this.em.getTransaction().rollback();
			}
		}
	}

	@Override
	public Animale update(Animale elemento) {
		Animale updated = null;
		if(elemento.getIdAnimale() != null) {
			try {
				this.em.getTransaction().begin();
				updated = this.animaleDao.merge(elemento);
				this.em.getTransaction().commit();
			} catch (Exception e) {
				this.em.getTransaction().rollback();
				e.printStackTrace();
			}
		}
		return updated;
	}

	@Override
	public void delete(Animale elemento) {
		try {
			this.em.getTransaction().begin();
			this.animaleDao.remove(elemento);
			this.em.getTransaction().commit();
		}catch(Exception e) {
			this.em.getTransaction().rollback();
		}
	}

}
