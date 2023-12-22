package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import it.corso.service.UtenteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	@Autowired
	private UtenteService utenteService;
	@GetMapping
	public String getPage(HttpSession session) 
	{
		if(session.getAttribute("utente") != null)
			return "redirect:/reserved";
		return "login";
	}
	
	@PostMapping
	public String formManager(@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session) {
		if(utenteService.controlloLogin(username, password, session))
			return "redirect:/reserved";
		return "redirect:/login";
	}
}
