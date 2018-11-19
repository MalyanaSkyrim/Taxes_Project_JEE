package crudTaxes.springjpa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.CommandLinePropertySource;

import crudTaxes.springjpa.dao.EntrepriseRepository;
import crudTaxes.springjpa.dao.TaxeRepository;
import crudTaxes.springjpa.entities.Entreprise;
import crudTaxes.springjpa.entities.IR;
import crudTaxes.springjpa.entities.TVA;

@SpringBootApplication
public class CrudTaxesApplication implements CommandLineRunner{
	@Autowired
	EntrepriseRepository entRepository;
	@Autowired
	TaxeRepository taxeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudTaxesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Entreprise e1 = entRepository.save(new Entreprise("R1","r1@gmail.com","sarl")),
				   e2 = entRepository.save(new Entreprise("R2","r2@gmail.com","michel"));
		
		
		taxeRepository.save(new TVA("TV HABITATION",new Date(),900,e1));
		taxeRepository.save(new TVA("TV Voiture",new Date(),300,e2));
		taxeRepository.save(new IR("IR 2016",new Date(),200,e1));
		
	}
}
