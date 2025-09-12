package service.zona;

import java.util.List;

import dao.zona.ZonaDao;
import jakarta.persistence.EntityManager;
import model.Zona;
import service.IBaseService;

public class ZonaService implements IBaseService<Zona, Long>{

	private EntityManager em;
	private ZonaDao zonaDao;
	
	public ZonaService(EntityManager em, ZonaDao zonaDao) {
		this.em = em;
		this.zonaDao = zonaDao;
	}

	@Override
	public Zona findById(Long id) {
		return this.zonaDao.findById(id);
	}

	@Override
	public List<Zona> findAll() {
		return this.zonaDao.findAll();
	}

	@Override
	public void create(Zona elemento) {
		if(elemento.getIdZona() == null) {
			try {
				this.em.getTransaction().begin();
				this.zonaDao.persist(elemento);
				this.em.getTransaction().commit();
				
			}catch(Exception e) {
				this.em.getTransaction().rollback();
			}
		}
	}

	@Override
	public Zona update(Zona elemento) {
		Zona updated = null;
		if(elemento.getIdZona() != null) {
			try {
				this.em.getTransaction().begin();
				updated = this.zonaDao.merge(elemento);
				this.em.getTransaction().commit();
			} catch (Exception e) {
				this.em.getTransaction().rollback();
				e.printStackTrace();
			}
		}
		return updated;
	}

	@Override
	public void delete(Zona elemento) {
		try {
			this.em.getTransaction().begin();
			this.zonaDao.remove(elemento);
			this.em.getTransaction().commit();
		}catch(Exception e) {
			this.em.getTransaction().rollback();
		}
	}

}
