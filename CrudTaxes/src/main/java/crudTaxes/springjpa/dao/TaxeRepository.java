package crudTaxes.springjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import crudTaxes.springjpa.entities.Entreprise;
import crudTaxes.springjpa.entities.Taxe;

//JpaRepository extends from CrudRepository
public interface TaxeRepository extends JpaRepository<Taxe, Long>{
	public List<Taxe> findByEntrepriseCode(Long code);
}
