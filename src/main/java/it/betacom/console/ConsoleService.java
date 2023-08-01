package it.betacom.console;

import java.util.Scanner;

import it.betacom.printservices.TxtPrinter;
import jakarta.persistence.EntityManager;

public class ConsoleService {
	
    private Scanner scanner;
    private TxtPrinter printer;
    private EntityManager em;
    
    public ConsoleService(EntityManager em) {
    	this.em = em;
    	this.printer = new TxtPrinter(em);
        this.scanner = new Scanner(System.in);
    }
	
	public void displayMenu() {
		System.out.println("1. Stampa clienti registrati");
		System.out.println("2. Stampa animali venduti");
		System.out.println("3. Stampa animali acquistati da un cliente");
		System.out.println("6. Esci");
	}
	
	public void start() {
		boolean exit = false;
		
		while(!exit) {
			
			displayMenu();
			int choice = scanner.nextInt();
            scanner.nextLine();
			
			switch(choice) {
			case 1:
				
			}
			
		}
	}
	
	
	
	

}
