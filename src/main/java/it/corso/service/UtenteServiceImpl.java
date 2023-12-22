package it.corso.service;

import org.springframework.stereotype.Service;

import it.corso.model.Utente;
import jakarta.servlet.http.HttpSession;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Override
	public boolean controlloLogin(String username, String password, HttpSession session) 	{
		if(username.equals(USERNAME_REGISTRATO)&&password.equals(PASSWORD_REGISTRATA)) {
			Utente utente = new Utente();
			utente.setUsername(username);
			utente.setPassword(password);
			session.setAttribute("utente", utente);
			
			return true;
		}
		return false;
	}

}
