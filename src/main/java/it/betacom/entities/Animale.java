package it.betacom.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "animali")
public class Animale {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_animale")
	private int id;
	
	@Column(name = "tipo_animale", nullable = false)
	private String tipoAnimale;
	
	@Column(name = "nome_animale", nullable = true)
	private String nome;
	
	@Column(name = "matricola", nullable = false)
	private String matricola;
	
	@Column(name = "data_acquisto", nullable = false)
	private LocalDate dataAcquisto;
	
	@Column(name = "prezzo", nullable = false)
	private double prezzo;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk") // Specifica il nome della colonna che rappresenta la chiave esterna
    private Cliente cliente;
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public int getIdCliente() {
		return this.cliente.getId();
	}

	public Animale(String tipoAnimale, String nome, String matricola, String dataAcquisto, double prezzo) {
		super();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		this.tipoAnimale = tipoAnimale;
		this.nome = nome;
		this.matricola = matricola;
		this.dataAcquisto = LocalDate.parse(dataAcquisto, formatter);
		this.prezzo = prezzo;
		
	}
	
	public Animale(String tipoAnimale, String nome, String matricola, LocalDate dataAcquisto, double prezzo) {
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

	public LocalDate getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(LocalDate dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
	
}
