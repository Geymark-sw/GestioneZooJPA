package model;

import java.util.Objects;

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
	private String razza;

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
	
	

	public Animale() {
		super();
	}



	public Animale(Long idAnimale, String razza, String specie, int eta, double peso, double altezza, Zona zona) {
		super();
		this.idAnimale = idAnimale;
		this.razza = razza;
		this.specie = specie;
		this.eta = eta;
		this.peso = peso;
		this.altezza = altezza;
		this.zona = zona;
	}
	
	

	public Animale(String razza, String specie, int eta, double peso, double altezza, Zona zona) {
		super();
		this.razza = razza;
		this.specie = specie;
		this.eta = eta;
		this.peso = peso;
		this.altezza = altezza;
		this.zona = zona;
	}



	public Long getIdAnimale() {
		return idAnimale;
	}

	public void setIdAnimale(Long idAnimale) {
		this.idAnimale = idAnimale;
	}

	public String getRazza() {
		return razza;
	}

	public void setNomeTipo(String razza) {
		this.razza = razza;
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
		//Long idAnimale, String razza, String specie, int eta, double peso, double altezza, Zona zona
		return "ID: " + this.idAnimale + "\n"
				+ "Razza: " + this.razza + "\n"
				+ "Specie: " + this.specie + "\n"
				+ "Eta': " + this.eta + "\n"
				+ "Peso: " + this.peso + "\n"
				+ "Altezza: " + this.altezza + "\n"
				+ "Zona: \n" + this.zona; 
	}

	@Override
	public int hashCode() {
		return Objects.hash(altezza, eta, idAnimale, razza, peso, specie, zona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animale other = (Animale) obj;
		return Double.doubleToLongBits(altezza) == Double.doubleToLongBits(other.altezza) && eta == other.eta
				&& Objects.equals(idAnimale, other.idAnimale) && Objects.equals(razza, other.razza)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso)
				&& Objects.equals(specie, other.specie) && Objects.equals(zona, other.zona);
	}
	
	
	
	
	
}
