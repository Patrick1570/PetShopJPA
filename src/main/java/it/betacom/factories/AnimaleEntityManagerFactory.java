package it.betacom.factories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AnimaleEntityManagerFactory {
	 
	private static final String PERSISTENCE_UNIT_NAME = "petshop-persistence";
	    private static EntityManagerFactory emf;

	    public static EntityManagerFactory getEntityManagerFactory() {
	        if (emf == null) {
	            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        }
	        return emf;
	    }

	    public static void closeEntityManagerFactory() {
	        if (emf != null && emf.isOpen()) {
	            emf.close();
	        }
	    }
}
