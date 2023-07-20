package it.betacom.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome", nullable = false, unique = false)
	private String nome;
	
	@Column(name = "cognome", nullable = false, unique = false)
	private String cognome;

	@Column(name = "città", nullable = true, unique = false)
	private String città;
	
	@Column(name = "indirizzo", nullable = true, unique = false)
	private String indirizzo;
	
	@Column(name = "telefono", nullable = true, unique = false)
	private String telefono;
	
	@OneToMany(mappedBy = "cliente")
    private List<Animale> animaliAcquistati;
	

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cognome, String città, String indirizzo, String telefono) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.città = città;
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

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
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
