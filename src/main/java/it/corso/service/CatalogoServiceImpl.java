package it.corso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.corso.model.Catalogo;
import jakarta.servlet.http.HttpSession;

@Service
public class CatalogoServiceImpl implements CatalogoService {

	@Override
	public List<Catalogo> getArticoli(HttpSession session) {
		
		List<Catalogo> articoli = new ArrayList<>();
		
			Catalogo articolo1 = new Catalogo();
			articolo1.setId(1);
			articolo1.setMarchio("Samsung");
			articolo1.setModello("SM-A13");
			articolo1.setOs("Android 12");
			articolo1.setMemoria(32);
			articolo1.setPrezzo(143.89);
			articolo1.setDescrizione("Samsung Galaxy A13 Smartphone Android, Processore Dual+Exa Core, Display Infinity-V da 6.6, Android 12.3 GB RAM, 32 GB di Memoria Interna Espandibile, Batteria 5.000 mAh");
			articoli.add(articolo1);
			
			
			Catalogo articolo2 = new Catalogo();
	        articolo2.setId(2);
	        articolo2.setMarchio("Samsung");
	        articolo2.setModello("A-32");
	        articolo2.setOs("Android 4.0, Android 11.0");
	        articolo2.setMemoria(128);
	        articolo2.setPrezzo(212.00);
	        articolo2.setDescrizione("Samsung Galaxy A32 4G Smartphone Android Senza SIM 6.4 Pollici, Display Infinity-U FHD+, 4 Fotocamere Posteriori, 4GB RAM e 128GB, Batteria 5.000 mAh");
	        articoli.add(articolo2);
	        
	        Catalogo articolo3 = new Catalogo();
	        articolo3.setId(3);
	        articolo3.setMarchio("Samsung");
	        articolo3.setModello("Galaxy A52s");
	        articolo3.setOs("Android 11, Android 10.0");
	        articolo3.setMemoria(6);
	        articolo3.setPrezzo(325.00);
	        articolo3.setDescrizione("Samsung Galaxy A52s 5G Smartphone, Display Infinity-O FHD+ da 6,5 pollici, 6GB RAM e 128GB di memoria interna espandibile, Batteria 4.500 mAh e Ricarica Ultra-Rapida");
	        articoli.add(articolo3);
	        
	        session.setAttribute("articoli", articoli);

		
		return articoli;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void gestisciCarrello(HttpSession session, int idArticolo) {
		List<Catalogo> articoli = (List<Catalogo>) session.getAttribute("articoli");
		
		List<Catalogo> carrello = session.getAttribute("carrello") == null ? new ArrayList<>() : (List<Catalogo>) session.getAttribute("carrello"); 
		
		for(Catalogo c : articoli)
			if(c.getId() == idArticolo) {
				carrello.add(c);
				break;
			}
		session.setAttribute("carrello", carrello);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void cancellaProdotto(HttpSession session, int idArticolo) {
		List<Catalogo> carrello = (List<Catalogo>) session.getAttribute("carrello");
		
		for(Catalogo c : carrello)
			if(c.getId() == idArticolo) {
				carrello.remove(c);
				break;
			}
		session.setAttribute("carrello", carrello);
	}
	
	

}
