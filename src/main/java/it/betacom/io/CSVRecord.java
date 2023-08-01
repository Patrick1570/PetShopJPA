package it.betacom.io;

import com.opencsv.bean.CsvBindByPosition;

public class CSVRecord {

	@CsvBindByPosition(position = 0)
	private String nomeCliente;

	@CsvBindByPosition(position = 1)
	private String cognomeCliente;

	@CsvBindByPosition(position = 2)
	private String città;

	@CsvBindByPosition(position = 3)
	private String tel;

	@CsvBindByPosition(position = 4)
	private String indirizzo;

	@CsvBindByPosition(position = 5)
	private String tipoAnimale;

	@CsvBindByPosition(position = 6)
	private String nomeAnimale;

	@CsvBindByPosition(position = 7)
	private String matricola;

	@CsvBindByPosition(position = 8)
	private String dataAcquisto;

	@CsvBindByPosition(position = 9)
	private String prezzo;

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCognomeCliente() {
		return cognomeCliente;
	}

	public void setCognomeCliente(String cognomeCliente) {
		this.cognomeCliente = cognomeCliente;
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTipoAnimale() {
		return tipoAnimale;
	}

	public void setTipoAnimale(String tipoAnimale) {
		this.tipoAnimale = tipoAnimale;
	}

	public String getNomeAnimale() {
		return nomeAnimale;
	}

	public void setNomeAnimale(String nomeAnimale) {
		this.nomeAnimale = nomeAnimale;
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

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}
}

