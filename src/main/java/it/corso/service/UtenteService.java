package it.corso.service;

import jakarta.servlet.http.HttpSession;

public interface UtenteService {
	
	String USERNAME_REGISTRATO="mario";
	String PASSWORD_REGISTRATA="abc";
	
	boolean controlloLogin(String username, String password, HttpSession session);
}
