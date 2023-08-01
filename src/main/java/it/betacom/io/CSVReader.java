package it.betacom.io;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import it.betacom.database.DBHandler;
import it.betacom.entities.Animale;
import it.betacom.entities.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CSVReader {
	
	private static final String PERSISTENCE_UNIT_NAME = "petshop-persistence";
	private DBHandler dbHandler = null;

	public void inizialize() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = emf.createEntityManager();
	    this.dbHandler = new DBHandler(em);

	    try (FileReader fileReader = new FileReader("src\\main\\resources\\CSVs\\PetShop_dati.csv")) {
	        List<CSVRecord> records = new CsvToBeanBuilder<CSVRecord>(fileReader)
	                .withType(CSVRecord.class)
	                .build()
	                .parse();
	        
	        // Rimuovi le prime tre righe (presumo che siano intestazioni del CSV)
	        records.subList(0, 3).clear();

	        em.getTransaction().begin();

	        for (CSVRecord record : records) {
	            String nomeCliente = record.getNomeCliente();
	            String cognomeCliente = record.getCognomeCliente();
	            String cittaCliente = record.getCittà();
	            String telefonoCliente = record.getTel();
	            String indirizzoCliente = record.getIndirizzo();

	            String tipoAnimale = record.getTipoAnimale();
	            String nomeAnimale = record.getNomeAnimale();
	            String matricolaAnimale = record.getMatricola();
	            String dataAcquistoStr = record.getDataAcquisto();
	            double prezzoAnimale;

	            if (record.getPrezzo().isEmpty()) {
	                prezzoAnimale = 0;
	            } else {
	                prezzoAnimale = Double.parseDouble(record.getPrezzo());
	            }

	            // Verifica se il cliente è già presente nel database
	            Cliente cliente = dbHandler.getClienteByNomeCognomeCitta(nomeCliente, cognomeCliente, cittaCliente);
	            if (cliente == null) {
	                cliente = new Cliente(nomeCliente, cognomeCliente, cittaCliente, indirizzoCliente, telefonoCliente);
	                em.persist(cliente);
	            }

	            // Crea oggetto Animale
	            Animale animale = new Animale(tipoAnimale, nomeAnimale, matricolaAnimale, dataAcquistoStr, prezzoAnimale);

	            // Imposta la relazione tra Cliente e Animale
	            animale.setCliente(cliente);

	            // Persisti l'animale nel database
	            em.persist(animale);
	        }

	        em.getTransaction().commit();
	        System.out.println("Dati salvati nel database correttamente!");

	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	        emf.close();
	    }
	}

}
