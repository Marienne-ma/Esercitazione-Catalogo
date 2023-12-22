package it.corso.service;

import java.util.List;

import it.corso.model.Catalogo;
import jakarta.servlet.http.HttpSession;

public interface CatalogoService 
{
	List<Catalogo> getArticoli(HttpSession session);
	void gestisciCarrello(HttpSession session, int idArticolo);
	void cancellaProdotto(HttpSession session, int idArticolo);
	
}

