package crudTaxes.springjpa.web;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import crudTaxes.springjpa.dao.EntrepriseRepository;
import crudTaxes.springjpa.dao.TaxeRepository;
import crudTaxes.springjpa.entities.Entreprise;

@Controller
public class TaxeControleur {
	@Autowired
	private EntrepriseRepository entRepository;
	
	@Autowired
	private TaxeRepository txRepository;
	
	@GetMapping("/entreprises")
	public String index(Model model,@RequestParam(defaultValue="")String motCle,@RequestParam(defaultValue="0") int page
			,@RequestParam(name="size",defaultValue="5")int s) {
		Page<Entreprise> pageList = entRepository.chercher("%"+motCle+"%",PageRequest.of(page, s)); 
		model.addAttribute("entreprises",pageList.getContent());
		int[] pages = new int[pageList.getTotalPages()];//Number of pages.
		model.addAttribute("pages",pages);
		model.addAttribute("pageCourante",page);
		model.addAttribute("motCle",motCle);
		return "entreprises";
	}
	
	@RequestMapping("/formEntreprise")
	public String formEntreprise(Model model) {
		model.addAttribute("entreprise", new Entreprise());
		return "formEntre";
	}
	
	@RequestMapping("/saveEntreprise")
	public String addEntreprise(@Valid Entreprise e,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "formEntre";
		entRepository.save(e);
		return "redirect:/entreprises"; //Not get page only but change the url
	}
	
	@RequestMapping("/taxes")
	public String taxes(Model model,Long code) {
		model.addAttribute("entreprises",entRepository.findAll());
		model.addAttribute("taxeList",txRepository.findByEntrepriseCode(code));
		return "taxes";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}