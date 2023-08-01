package it.betacom.main;

import it.betacom.factories.ClienteEntityManagerFactory;
import it.betacom.io.CSVReader;
import it.betacom.printservices.TxtPrinter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {

	public static void main(String[] args) { 
		
        EntityManagerFactory clienteEmf = ClienteEntityManagerFactory.getEntityManagerFactory();
        EntityManager clienteEm = clienteEmf.createEntityManager();
        
        //TxtPrinter printer = new TxtPrinter(clienteEm);
        
        
        
        //printer.saveClientDetailsAsTxt(null);

		
		CSVReader reader = new CSVReader();
		reader.inizialize();
		
		//List<Cliente> lista = DBHandler.getAllClienti(clienteEm);
//		List<Animale> listaAnimali = DBHandler.getAllAnimali(clienteEm);
		
		//TxtPrinter.saveListClientiAsTxt(lista);
        //TxtPrinter.saveListAnimaliAsTxt(listaAnimali);
        
        //DBHandler.printAnimaliAndClienti(clienteEm);
		//DBHandler.printAnimaliAcquistatiByCliente(clienteEm, 2);
	}

}
