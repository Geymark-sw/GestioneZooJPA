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
@Table(name = "zona")
public class Zona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_zona")
	private Long idZona;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "area", nullable = false)
	private Double area;
	
	// Non c'è il CASCADE perchè se elimino una zona non devono essere eliminati anche gli animali contenuti in quella zona
	@OneToMany(mappedBy = "zona")
	private List<Animale> animali;
	
	public Zona() {
		
	}

	public Zona(Long idZona, String nome, Double area) {
		super();
		this.idZona = idZona;
		this.nome = nome;
		this.area = area;
	}
	
	public Zona(String nome, Double area) {
		this.nome = nome;
		this.area = area;
	}

	public Long getIdZona() {
		return idZona;
	}

	public void setIdZona(Long idZona) {
		this.idZona = idZona;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Zona [idZona=" + idZona + ", nome=" + nome + ", area=" + area + "]";
	}
	
	
	
	
	
	
}
