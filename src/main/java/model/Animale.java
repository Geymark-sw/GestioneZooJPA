package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Animale")
public class Animale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_animale")
	private Long idAnimale;
	
	@Column(name = "nome_tipo", nullable = false)
	private String nomeTipo;

	@Column(name = "specie", nullable = false)
	private String specie;
	
	@Column(name = "eta", nullable = false)
	private int eta;
	
	@Column(name = "peso", nullable = false)
	private double peso;
	
	@Column(name = "altezza", nullable = false)
	private double altezza;
	
	@ManyToOne
	@JoinColumn(name = "id_zona", nullable = true)
	private Zona zona;

	public Long getIdAnimale() {
		return idAnimale;
	}

	public void setIdAnimale(Long idAnimale) {
		this.idAnimale = idAnimale;
	}

	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltezza() {
		return altezza;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "Animale [idAnimale=" + idAnimale + ", nomeTipo=" + nomeTipo + ", specie=" + specie + ", eta=" + eta
				+ ", peso=" + peso + ", altezza=" + altezza + ", zona=" + zona + "]";
	}
	
	
	
}
