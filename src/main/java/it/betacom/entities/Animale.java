package it.betacom.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Animale {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "tipoAnimale", nullable = false)
	private String tipoAnimale;
	
	@Column(name = "nome", nullable = true)
	private String nome;
	
	@Column(name = "matricola", nullable = false)
	private String matricola;
	
	@Column(name = "dataAcquisto", nullable = false)
	private String dataAcquisto;
	
	@Column(name = "prezzo", nullable = false)
	private double prezzo;
	
	@ManyToOne
    private Cliente cliente;

	public Animale(String tipoAnimale, String nome, String matricola, String dataAcquisto, double prezzo) {
		super();
		this.tipoAnimale = tipoAnimale;
		this.nome = nome;
		this.matricola = matricola;
		this.dataAcquisto = dataAcquisto;
		this.prezzo = prezzo;
	}

	public Animale() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoAnimale() {
		return tipoAnimale;
	}

	public void setTipoAnimale(String tipoAnimale) {
		this.tipoAnimale = tipoAnimale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(String dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
	
}
