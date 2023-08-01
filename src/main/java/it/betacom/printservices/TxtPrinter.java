package it.betacom.printservices;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import it.betacom.database.DBHandler;
import it.betacom.entities.Animale;
import it.betacom.entities.Cliente;
import jakarta.persistence.EntityManager;

public class TxtPrinter {

	private EntityManager em = null;
	private DBHandler dbHandler = null;

	public TxtPrinter(EntityManager em) {
		this.em = em;
		this.dbHandler = new DBHandler(em);
	}


	public void saveListClientiAsTxt(List<Cliente> listaClienti) {

		String userHome = System.getProperty("user.home");
		String documentsPath = userHome + File.separator + "Documents" + File.separator + "PetShop";
		String filePath = documentsPath + File.separator + "listaClienti.txt";

		// Crea le cartelle se non esistono
		File directory = new File(documentsPath);
		directory.mkdirs();

		FileWriter writer = null;

		try {
			// Crea il file se non esiste
			File file = new File(filePath);
			if (file.createNewFile()) {
				System.out.println("File creato con successo");
			} else {
				System.out.println("Il file esiste già");
			}

			writer = new FileWriter(filePath);

			writer.append("Clienti presenti nel database: \n\n");
			writer.append(String.format("%12s %-30s %-30s %-20s %-15s %-30s %n"
					, "ID CLIENTE"
					, "NOME"
					, "COGNOME"
					, "CITTÀ"
					, "TELEFONO"
					, "INDIRIZZO"));

			System.out.print("Elaborazione in corso");

			for(Cliente c : listaClienti) {

				System.out.print('.');
				writer.append(String.format("%12s %-30s %-30s %-20s %-15s %-30s %n"
						, c.getId()
						, c.getNome()
						, c.getCognome()
						, c.getCittà()
						, c.getTelefono()
						, c.getIndirizzo()));
			}

			System.out.println("\nFile aggiornato con successo");


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void saveListAnimaliAsTxt(List<Animale> listaAnimali) {

		String userHome = System.getProperty("user.home");
		String documentsPath = userHome + File.separator + "Documents" + File.separator + "PetShop";
		String filePath = documentsPath + File.separator + "listaAnimali.txt";

		// Crea le cartelle se non esistono
		File directory = new File(documentsPath);
		directory.mkdirs();

		FileWriter writer = null;

		try {
			// Crea il file se non esiste
			File file = new File(filePath);
			if (file.createNewFile()) {
				System.out.println("File creato con successo");
			} else {
				System.out.println("Il file esiste già");
			}

			writer = new FileWriter(filePath);

			writer.append("Clienti presenti nel database: \n\n");
			writer.append(String.format("%15s %-15s %-30s %-20s %-15s %-10s %n"
					, "ID ANIMALE"
					, "MATRICOLA"
					, "NOME"
					, "DATA ACQUISTO"
					, "ID PROPRIETARIO"
					, "PREZZO"));

			System.out.print("Elaborazione in corso");

			for(Animale a : listaAnimali) {

				System.out.print('.');
				writer.append(String.format("%15s %-15s %-30s %-20s %-15s %-10s %n"
						, a.getId()
						, a.getMatricola()
						, a.getNome()
						, a.getDataAcquisto()
						, a.getIdCliente()
						, a.getPrezzo()));
			}

			System.out.println("\nFile aggiornato con successo");


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void saveClientDetailsAsTxt(Cliente cliente) {
		List<Animale> listaAnimaliAcquistati = dbHandler.getAnimaliAcquistati(cliente);

		for(Animale a : listaAnimaliAcquistati) {
			System.out.println(a.getNome());
		}
	}
}
