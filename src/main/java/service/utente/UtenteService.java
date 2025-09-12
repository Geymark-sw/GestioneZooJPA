package service.utente;

import java.util.List;

import dao.utente.UtenteDao;
import jakarta.persistence.EntityManager;
import model.Utente;
import service.IBaseService;

public class UtenteService implements IBaseService<Utente, Long>{
	
	private final EntityManager em;
	private final UtenteDao utenteDao;
	
	public UtenteService(EntityManager em, UtenteDao utenteDao) {
		this.em = em;
		this.utenteDao = utenteDao;
	}

	@Override
	public Utente findById(Long id) {
		return this.utenteDao.findById(id);
	}

	@Override
	public List<Utente> findAll() {
		return this.utenteDao.findAll();
	}

	@Override
	public void create(Utente elemento) {
		if(elemento.getIdUtente() == null) {
			try {
				this.em.getTransaction().begin();
				this.utenteDao.persist(elemento);
				this.em.getTransaction().commit();
				
			}catch(Exception e) {
				this.em.getTransaction().rollback();
			}
		}
	}

	@Override
	public Utente update(Utente elemento) {
		Utente updated = null;
		if(elemento.getIdUtente() != null) {
			try {
				this.em.getTransaction().begin();
				updated = this.utenteDao.merge(elemento);
				this.em.getTransaction().commit();
			} catch (Exception e) {
				this.em.getTransaction().rollback();
				e.printStackTrace();
			}
		}
		return updated;
	}

	@Override
	public void delete(Utente elemento) {
		try {
			this.em.getTransaction().begin();
			this.utenteDao.remove(elemento);
			this.em.getTransaction().commit();
		}catch(Exception e) {
			this.em.getTransaction().rollback();
		}
	}

}
