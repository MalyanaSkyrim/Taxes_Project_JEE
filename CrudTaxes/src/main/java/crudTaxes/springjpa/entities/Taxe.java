package crudTaxes.springjpa.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",
discriminatorType=DiscriminatorType.STRING,length=3)
public abstract class Taxe implements Serializable{
	@Id @GeneratedValue
	private Long id;
	private String titre;
	private Date date;
	private double montant;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="code_ent")
	private Entreprise entreprise;
	
	
	public Taxe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Taxe(String titre, Date date, double montant, Entreprise entreprise) {
		super();
		this.titre = titre;
		this.date = date;
		this.montant = montant;
		this.entreprise = entreprise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	@Override
	public String toString() {
		return "Taxe [id=" + id + ", titre=" + titre + ", date=" + date + ", montant=" + montant + ", entreprise="
				+ entreprise + "]";
	}

	
	
}
