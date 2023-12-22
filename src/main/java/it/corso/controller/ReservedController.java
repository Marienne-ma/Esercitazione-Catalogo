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
@RequestMapping("/reserved")
public class ReservedController {

	@Autowired
	private CatalogoService catalogoService;
	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(HttpSession session, Model model) {
		if(session.getAttribute("utente") == null)
			return "redirect:/login";

		List<Catalogo> carrello = (List<Catalogo>) session.getAttribute("carrello");
		model.addAttribute("carrello", carrello);
		return "reserved";
	}
	
	@GetMapping("/rimuovi")
	public String cancellaProdotto(@RequestParam("id") int idArticolo, HttpSession session) {
		System.out.println("Il prodotto "+idArticolo+" è stato cancellato");
		catalogoService.cancellaProdotto(session, idArticolo);
		return "redirect:/reserved";
	}
}
