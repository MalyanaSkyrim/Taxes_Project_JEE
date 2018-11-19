package crudTaxes.springjpa.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;
@Entity
public class Entreprise implements Serializable{
	@Id @GeneratedValue
	Long code;
	@NonNull
	@Size(min=2,max=10)
	String nom;
	@NonNull
	@Email
	@Size(min=7,max=20)
	String email;
	@NonNull
	@Size(min=2,max=20)
	String raisonSocial;
	@OneToMany(mappedBy="entreprise",fetch=FetchType.LAZY)
	Collection<Taxe> taxes;
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRaisonSocial() {
		return raisonSocial;
	}
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
	public Collection<Taxe> getTaxes() {
		return taxes;
	}
	public void setTaxes(Collection<Taxe> taxes) {
		this.taxes = taxes;
	}
	@Override
	public String toString() {
		return "Entreprise [code=" + code + ", nom=" + nom + ", email=" + email + ", raisonSocial=" + raisonSocial
				+ ", taxes=" + taxes + "]";
	}
	public Entreprise(String nom, String email, String raisonSocial) {
		super();
		this.nom = nom;
		this.email = email;
		this.raisonSocial = raisonSocial;
		
	}
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
