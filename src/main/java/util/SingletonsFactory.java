package util;

import dao.animale.AnimaleDao;
import dao.utente.UtenteDao;
import dao.utenteZona.UtenteZonaDao;
import dao.zona.ZonaDao;
import jakarta.persistence.EntityManager;
import service.animale.AnimaleService;
import service.utente.UtenteService;
import service.utenteZona.UtenteZonaService;
import service.zona.ZonaService;

public class SingletonsFactory {
	
	private static EntityManager em;
	private static UtenteDao utenteDao;
	private static AnimaleDao animaleDao;
	private static ZonaDao zonaDao;
	private static UtenteZonaDao utenteZonaDao;
	private static UtenteService utenteService;
	private static AnimaleService animaleService;
	private static ZonaService zonaService;
	private static UtenteZonaService utenteZonaService;
	
	public static EntityManager getEntityManager() {
		if(em == null) {
			em = JPAUtil.getEntityManager();
		}
		return em;
	}
	
	public static UtenteDao getUtenteDao() {
		if(utenteDao == null) {
			utenteDao = new UtenteDao(getEntityManager());
		}
		return utenteDao;
	}
	
	public static AnimaleDao getAnimaleDao() {
		if(animaleDao == null) {
			animaleDao = new AnimaleDao(getEntityManager());
		}
		return animaleDao;
	}
	
	public static ZonaDao getZonaDao() {
		if(zonaDao == null) {
			zonaDao = new ZonaDao(getEntityManager());
		}
		return zonaDao;
	}
	
	public static UtenteZonaDao getUtenteZonaDao() {
		if(utenteZonaDao == null) {
			utenteZonaDao = new UtenteZonaDao(getEntityManager());
		}
		return utenteZonaDao;
	}
	
	public static UtenteService getUtenteService() {
		if(utenteService == null) {
			utenteService = new UtenteService(getEntityManager(), getUtenteDao(), getAnimaleDao(), getZonaDao(), getUtenteZonaDao());
		}
		return utenteService;
	}
	
	public static AnimaleService getAnimaleService() {
		if(animaleService == null) {
			animaleService = new AnimaleService(getEntityManager(), getAnimaleDao());
		}
		return animaleService;
	}
	
	public static ZonaService getZonaService() {
		if(zonaService == null) {
			zonaService = new ZonaService(getEntityManager(), getZonaDao());
		}
		return zonaService;
	}
	
	public static UtenteZonaService getUtenteZonaService() {
		if(utenteZonaService == null) {
			utenteZonaService = new UtenteZonaService(getEntityManager(), getUtenteZonaDao());
		}
		return utenteZonaService;
	}

}
