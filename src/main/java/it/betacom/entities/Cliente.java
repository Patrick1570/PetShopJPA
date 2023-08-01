package it.betacom.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clienti")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private int id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "cognome", nullable = false)
	private String cognome;

	@Column(name = "citt�", nullable = true)
	private String citt�;
	
	@Column(name = "indirizzo", nullable = true)
	private String indirizzo;
	
	@Column(name = "tel", nullable = true)
	private String telefono;
	
	// Relazione One-to-Many con la classe Animale
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Animale> animaliAcquistati;
	

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cognome, String citt�, String indirizzo, String telefono) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.citt� = citt�;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCitt�() {
		return citt�;
	}

	public void setCitt�(String citt�) {
		this.citt� = citt�;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Animale> getAnimaliAcquistati() {
		return animaliAcquistati;
	}

	public void setAnimaliAcquistati(List<Animale> animaliAcquistati) {
		this.animaliAcquistati = animaliAcquistati;
	}
}
