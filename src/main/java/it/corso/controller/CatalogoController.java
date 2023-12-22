package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import it.corso.model.Catalogo;
import it.corso.service.CatalogoService;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/")
public class CatalogoController {
	
	@Autowired
	private CatalogoService catalogoService;
	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(Model model, HttpSession session) {
		
		if(session.getAttribute("articoli")==null)
			catalogoService.getArticoli(session);
		
		 List<Catalogo> articoli = (List<Catalogo>) session.getAttribute("articoli");
		 model.addAttribute("articoli", articoli);
		 
		
		
		return "catalogo";
	}
	

}
