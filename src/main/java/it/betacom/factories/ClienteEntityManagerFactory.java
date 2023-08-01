package it.betacom.factories;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClienteEntityManagerFactory {
	
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
