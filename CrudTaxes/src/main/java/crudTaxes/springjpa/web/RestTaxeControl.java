package crudTaxes.springjpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import crudTaxes.springjpa.dao.EntrepriseRepository;
import crudTaxes.springjpa.entities.Entreprise;



@RestController
public class RestTaxeControl {
	@Autowired
	EntrepriseRepository entRepository;
	
	@GetMapping("/dataEntre")
	public List<Entreprise> getTaxesList() {
		return entRepository.findAll();
	}
	
}
