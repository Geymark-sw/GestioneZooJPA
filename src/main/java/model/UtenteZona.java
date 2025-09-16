package model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "utente_zona")
public class UtenteZona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtenteZona;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utente", nullable = false)
	private Utente utente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_zona", nullable = false)
	private Zona zona;
	

	public UtenteZona() {
		super();
	}

	public UtenteZona(Utente utente, Zona zona) {
		super();
		this.utente = utente;
		this.zona = zona;
	}

	public UtenteZona(Long idUtenteZona, Utente utente, Zona zona) {
		super();
		this.idUtenteZona = idUtenteZona;
		this.utente = utente;
		this.zona = zona;
	}

	public Long getIdUtenteZona() {
		return idUtenteZona;
	}

	public void setIdUtenteZona(Long idUtenteZona) {
		this.idUtenteZona = idUtenteZona;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "UtenteZona [idUtenteZona=" + idUtenteZona + ", utente=" + utente + ", zona=" + zona + "]";
	}
	
	
	

}
