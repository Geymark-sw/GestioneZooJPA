package service.utente;

import java.util.List;

import dao.animale.AnimaleDao;
import dao.utente.UtenteDao;
import dao.utenteZona.UtenteZonaDao;
import dao.zona.ZonaDao;
import jakarta.persistence.EntityManager;
import model.Animale;
import model.Utente;
import model.UtenteZona;
import model.Zona;
import service.IBaseService;

public class UtenteService implements IBaseService<Utente, Long>{
	
	private final EntityManager em;
	private final UtenteDao utenteDao;
	private final AnimaleDao animaleDao;
	private final ZonaDao zonaDao;
	private final UtenteZonaDao utenteZonaDao;
	
	public UtenteService(EntityManager em, UtenteDao utenteDao, AnimaleDao animaleDao, ZonaDao zonaDao, UtenteZonaDao utenteZonaDao) {
		this.em = em;
		this.utenteDao = utenteDao;
		this.animaleDao = animaleDao;
		this.zonaDao = zonaDao;
		this.utenteZonaDao = utenteZonaDao;
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
	
	public Utente findByEmail(String email) {
		return this.em.createQuery("FROM utente u WHERE u.email = :email", Utente.class)
				.setParameter("email", email)
				.getResultStream().findFirst().orElse(null);
	}
	
	//Funzioni di business per animali
	public boolean spostaAnimale(Animale a, Zona z) {
		
		try {
			this.em.getTransaction().begin();
			a.getZona().getAnimali().remove(a); //Rimuovo dalla zona iniziale l'animale
			a.setZona(z); 						//Setto la nuova zona dell'animale
			z.getAnimali().add(a); 				//Nella nuova zona aggiungo l'animale
			if(a.getZona() == z) {//Verifico se la nuova zona dell'animale corrisponde alla zona passata come parametro
				this.animaleDao.merge(a);
				this.zonaDao.merge(z);
				this.em.getTransaction().commit();
				return true;
			}
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean aggiungiAnimale(Animale a, Zona z) {
		
		try {
			this.em.getTransaction().begin();
			a.setZona(z);
			z.getAnimali().add(a);
			animaleDao.persist(a);
			zonaDao.merge(z);
			this.em.getTransaction().commit();
			return true;
			} catch (Exception e) {
				this.em.getTransaction().rollback();
				e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean rimuoviAnimale(Animale a, Zona z) {
		try {
			this.em.getTransaction().begin();
			z.getAnimali().remove(a);
			this.animaleDao.remove(a);
			this.zonaDao.merge(z);
			this.em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			this.em.getTransaction().rollback();
		}
		return false;
	}
	
	public Animale trovaAnimale(Long id) {
		return this.animaleDao.findById(id);
	}
	
	public List<Animale> visualizzaAnimaliPerZona(Zona z){
		return z.getAnimali();
		
	}
	
	public List<Animale> visualizzaTuttiAnimali(){
		return this.animaleDao.findAll();
	}
	
	//Funzioni di business per Admin
	public boolean registraDipendete(Utente daRegistrare) {
			try {
				this.em.getTransaction().begin();
				this.utenteDao.persist(daRegistrare);
				this.em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				this.em.getTransaction().rollback();
				e.printStackTrace();
			} 
		
		return false;
	}
	
	public boolean disattivaDipendente(Utente daDisattivare) {
			try {
				this.em.getTransaction().begin();
				daDisattivare.setStato(false);
				this.utenteDao.merge(daDisattivare);
				this.em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				this.em.getTransaction().rollback();
				e.printStackTrace();
			}
		return false;
	}
	
	public boolean rimuoviDipendente(Utente daRimuovere) {
			try {
				this.em.getTransaction().begin();
				this.utenteDao.remove(daRimuovere);
				this.em.getTransaction().commit();
				return true;
			}catch(Exception e) {
				this.em.getTransaction().rollback();
				e.printStackTrace();
			}
		return false;
	}
	
	public boolean assegnaZonaDipendente(Utente daAssegnare, Zona zona) {
		
		try {
			this.em.getTransaction().begin();
			UtenteZona uz = new UtenteZona(daAssegnare, zona); 
			this.utenteZonaDao.persist(uz);
			this.em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			this.em.getTransaction().rollback();
		}
		return false;
	}
	
}
