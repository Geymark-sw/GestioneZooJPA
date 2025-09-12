package service.utenteZona;

import java.util.List;

import dao.utenteZona.UtenteZonaDao;
import jakarta.persistence.EntityManager;
import model.UtenteZona;
import service.IBaseService;

public class UtenteZonaService implements IBaseService<UtenteZona, Long> {
	
	private final EntityManager em;
	private final UtenteZonaDao utenteZonaDao;
	
	public UtenteZonaService(EntityManager em, UtenteZonaDao utenteZonaDao) {
		this.em = em;
		this.utenteZonaDao = utenteZonaDao;
	}


	@Override
	public UtenteZona findById(Long id) {
		return this.utenteZonaDao.findById(id);
	}

	@Override
	public List<UtenteZona> findAll() {
		return this.utenteZonaDao.findAll();
	}

	@Override
	public void create(UtenteZona elemento) {
		if(elemento.getIdUtenteZona() == null) {
			try {
				this.em.getTransaction().begin();
				this.utenteZonaDao.persist(elemento);
				this.em.getTransaction().commit();
				
			}catch(Exception e) {
				this.em.getTransaction().rollback();
			}
		}
	}

	@Override
	public UtenteZona update(UtenteZona elemento) {
		UtenteZona updated = null;
		if(elemento.getIdUtenteZona() != null) {
			try {
				this.em.getTransaction().begin();
				updated = this.utenteZonaDao.merge(elemento);
				this.em.getTransaction().commit();
			} catch (Exception e) {
				this.em.getTransaction().rollback();
				e.printStackTrace();
			}
		}
		return updated;
	}

	@Override
	public void delete(UtenteZona elemento) {
		try {
			this.em.getTransaction().begin();
			this.utenteZonaDao.remove(elemento);
			this.em.getTransaction().commit();
		}catch(Exception e) {
			this.em.getTransaction().rollback();
		}
	}

}
