package crudTaxes.springjpa.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TVA")
public class TVA extends Taxe{

	public TVA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TVA(String titre, Date date, double montant, Entreprise entreprise) {
		super(titre, date, montant, entreprise);
		// TODO Auto-generated constructor stub
	}
	

}
