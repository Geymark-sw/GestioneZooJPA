package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente")
	private Long idUtente;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "cognome", nullable = false)
	private String cognome;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "ruolo", nullable = false)
	private Ruolo ruolo;
	
	@Column(name = "stato", nullable = false)
	private boolean stato;
	
	//Collegamento alla tabella di join utente_zona
	@OneToMany(mappedBy = "utente")
	private List<UtenteZona> utentiZone;
	
	public Utente() {
		
	}

	public Utente(Long idUtente, String nome, String cognome, String email, String password, Ruolo ruolo) {
		super();
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
	}

	public Utente(String nome, String cognome, String email, String password, Ruolo ruolo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
	}

	public Long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
	

	public boolean isStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", password=" + password + ", ruolo=" + ruolo + "]";
	}

	public List<UtenteZona> getUtentiZone() {
		return utentiZone;
	}

	public void setUtentiZone(List<UtenteZona> utentiZone) {
		this.utentiZone = utentiZone;
	}
	
	
	

}
