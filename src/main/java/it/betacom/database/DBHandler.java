package it.betacom.database;

import java.util.List;

import it.betacom.entities.Animale;
import it.betacom.entities.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class DBHandler {
	
	private EntityManager em = null;
	
	public DBHandler(EntityManager em) {
		this.em = em;
	}
	
	// Metodo di utilità per trovare un cliente dal nome e cognome
    public static Cliente findClienteByNomeAndCognome(EntityManager em, String nome, String cognome) {
        List<Cliente> clienti = em.createQuery("SELECT c FROM Cliente c WHERE c.nome = :nome AND c.cognome = :cognome", Cliente.class)
                .setParameter("nome", nome)
                .setParameter("cognome", cognome)
                .getResultList();

        if (!clienti.isEmpty()) {
            return clienti.get(0);
        }

        return null;
    }
    
    public Animale findAnimaleByMatricola(String matricola) {
        List<Animale> animali = this.em.createQuery("SELECT a FROM Animale a WHERE a.matricola = :matricola", Animale.class)
                .setParameter("matricola", matricola)
                .getResultList();

        if (!animali.isEmpty()) {
            return animali.get(0);
        }

        return null;	
    }
    
    public static List<Cliente> getAllClienti(EntityManager em){

    	List<Cliente> listaClienti = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    	
    	if (!listaClienti.isEmpty()) {
            return listaClienti;
        }

        return null;
    }
    
    public List<Animale> getAllAnimali(){

    	List<Animale> listaAnimali = this.em.createQuery("SELECT a FROM Animale a ", Animale.class).getResultList();
    	
    	if (!listaAnimali.isEmpty()) {
            return listaAnimali;
        }

        return null;
    }
    
    public List<Animale> getAnimaliAcquistati(Cliente cliente){

    	String idClienteFK = String.valueOf(cliente.getId());
    	
    	List<Animale> listaAnimali = this.em.createQuery("SELECT a FROM Animale a WHERE a.id_cliente_fk = :idClienteFK", Animale.class).getResultList();
    	
    	if (!listaAnimali.isEmpty()) {
            return listaAnimali;
        }

        return null;
    }
    
    public void printAnimaliAndClienti() {
        List<Animale> animali = getAllAnimali();

        System.out.println("--------------------------------------------------------------");
        System.out.println("| ID Animale | Tipo Animale | Nome Animale | Cliente Associato |");
        System.out.println("--------------------------------------------------------------");

        for (Animale animale : animali) {
            int idAnimale = animale.getId();
            String tipoAnimale = animale.getTipoAnimale();
            String nomeAnimale = animale.getNome();
            String clienteAssociato = animale.getCliente().getNome() + " " + animale.getCliente().getCognome();

            System.out.printf("| %-10s | %-12s | %-12s | %-18s |%n", idAnimale, tipoAnimale, nomeAnimale, clienteAssociato);
        }

        System.out.println("--------------------------------------------------------------");
    }
    
    public void printAnimaliAcquistatiByCliente(int clienteId) {
        Cliente cliente = this.em.find(Cliente.class, clienteId);

        if (cliente == null) {
            System.out.println("Cliente non trovato.");
            return;
        }

        System.out.println("Cliente: " + cliente.getNome() + " " + cliente.getCognome());
        System.out.println("-------------------------------------------------------------");
        System.out.println("| Data       | Matricola Animale | Nome Animale | Prezzo     |");
        System.out.println("-------------------------------------------------------------");

        List<Animale> animaliAcquistati = cliente.getAnimaliAcquistati();

        for (Animale animale : animaliAcquistati) {
            String dataAcquisto = animale.getDataAcquisto().toString();
            String matricola = animale.getMatricola();
            String nomeAnimale = animale.getNome();
            double prezzo = animale.getPrezzo();

            System.out.printf("| %-10s | %-17s | %-12s | %-10.2f |%n", dataAcquisto, matricola, nomeAnimale, prezzo);
        }

        System.out.println("-------------------------------------------------------------");
    }
    
    public boolean isClientePresente(Cliente cliente) {
        // Recupera tutti i clienti dal database con gli stessi parametri (tranne l'id)
        List<Cliente> clientiEsistenti = this.em.createQuery(
            "SELECT c FROM Cliente c WHERE c.nome = :nome " +
            "AND c.cognome = :cognome " +
            "AND c.città = :città " +
            "AND c.indirizzo = :indirizzo " +
            "AND c.telefono = :telefono", Cliente.class)
            .setParameter("nome", cliente.getNome())
            .setParameter("cognome", cliente.getCognome())
            .setParameter("città", cliente.getCittà())
            .setParameter("indirizzo", cliente.getIndirizzo())
            .setParameter("telefono", cliente.getTelefono())
            .getResultList();

        // Se esistono clienti con gli stessi parametri (tranne l'id), allora il cliente è presente nel database
        return !clientiEsistenti.isEmpty();
    }
    
    public Cliente getClienteByNomeCognomeCitta(String nome, String cognome, String citta) {
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.nome = :nome " +
                                  "AND c.cognome = :cognome " +
                                  "AND c.città = :città", Cliente.class)
                    .setParameter("nome", nome)
                    .setParameter("cognome", cognome)
                    .setParameter("città", citta)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null; // Cliente non trovato, restituisci null
        }
    }

}
