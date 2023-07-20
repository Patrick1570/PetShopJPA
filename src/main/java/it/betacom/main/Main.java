package it.betacom.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.betacom.entities.Animale;
import it.betacom.factories.AnimaleEntityManagerFactory;

public class Main {

	public static void main(String[] args) {

        // Utilizza la factory "AnimaleEntityManagerFactory" per ottenere un'istanza di "EntityManagerFactory"
        EntityManagerFactory animaleEmf = AnimaleEntityManagerFactory.getEntityManagerFactory();
        EntityManager animaleEm = animaleEmf.createEntityManager();
        
        Animale animale = new Animale("Gatto", "Pippo", "000001", "20/07/2023", 70);
        animaleEm.persist(animale);
        animaleEm.close();
        
		
	}

}
