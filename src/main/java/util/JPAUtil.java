package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_zoo");
	private static final EntityManager em = emf.createEntityManager();
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	
	public static EntityManager getEntityManager() {
		return em;
	}
	
	public static void closeEntityManager() {
		em.close();
	}
	
	public static void shutdown() {
		if(emf != null) {
			emf.close();
		}
	}

}
