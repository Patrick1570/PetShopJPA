	package it.betacom.printservices.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import it.betacom.database.DBHandler;
import it.betacom.entities.Animale;
import it.betacom.entities.Cliente;
import it.betacom.printservices.PrintService;
import jakarta.persistence.EntityManager;

public class PrintServiceImpl implements PrintService {
	
	private EntityManager em = null;
	private DBHandler dbHandler = null;
	private String folderPath;
	
	public PrintServiceImpl(EntityManager em) {
		this.em = em;
		this.dbHandler = new DBHandler(em);
		
		String userHome = System.getProperty("user.home");
		this.folderPath = userHome + File.separator + "Documents" + File.separator + "PetShop";
	}
	
	public PrintServiceImpl(EntityManager em, String path) {
		this.em = em;
		this.dbHandler = new DBHandler(em);
		this.folderPath = path;
	}

	@Override
	public void salvaListaClientiRegistrati() {
		String filePath = folderPath + File.separator + "listaClienti.txt";

		// Crea le cartelle se non esistono
		File directory = new File(folderPath);
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

			for(Cliente c : DBHandler.getAllClienti(this.em)) {

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

	@Override
	public void salvaListaAnimaliVenduti() {

		String filePath = folderPath + File.separator + "listaAnimali.txt";

		// Crea le cartelle se non esistono
		File directory = new File(folderPath);
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

			writer.append("Animali presenti nel database: \n\n");
			writer.append(String.format("%20s %-15s %-15s %-25s %-15s %-10s %n"
					, "DATA ACQUISTO"
					, "MATRICOLA"
					, "ID ANIMALE"
					, "NOME"
					, "ID PROPRIETARIO"
					, "PREZZO"));

			System.out.print("Elaborazione in corso");

			for(Animale a : dbHandler.getAllAnimali()) {

				System.out.print('.');
				writer.append(String.format("%20s %-15s %-15s %-25s %-15s %-10s€ %n"
						, a.getDataAcquisto()
						, a.getMatricola()
						, a.getId()
						, a.getNome()
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

	@Override
	public void salvaAnimaliAcquistatiDaCliente() {
		// TODO Auto-generated method stub

	}

	public String getFolderPath() {
		return folderPath;
	}

	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}

}
