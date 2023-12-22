package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Catalogo;
import it.corso.service.CatalogoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {

	@Autowired
	private CatalogoService catalogoService;
	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(Model model, @RequestParam("name") int id, HttpSession session) {
		
		List<Catalogo> articoli = (List<Catalogo>) session.getAttribute("articoli");
		model.addAttribute("articoli", articoli);
		model.addAttribute("name", id);
		return "dettaglio";
	}
	
	@GetMapping("/aggiungi")
	public String aggiungiACarrello(@RequestParam("id") int idArticolo, HttpSession session) {
		System.out.println("Hai scelto il prodotto "+idArticolo);
		catalogoService.gestisciCarrello(session, idArticolo);
		return "redirect:/dettaglio?name="+idArticolo;
	}
	
}
