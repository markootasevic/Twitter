package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Predsavlja skup tviter poruka kao i metoda za upravljanje njima
 * 
 * @author Marko
 * 
 */
public class Twitter {
	/**
	 * predstavlja listu tviter poruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * vraca sve tviter poruka
	 * 
	 * @return listu poruka kao objekte tipa TwitterPoruka koja sadrzi sve twitter poruke
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	

	/**
	 * metoda pravi novu tviter poruku i ubacuje je u listu na kraj
	 * 
	 * @param korisnik predstavlja ime korisnika kao String
	 * @param poruka predstavlja poruku na twitter-u kao String
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		// tp.setKorisnik("korisnik"); U ovoj liniji se pojavila greska koja je
		// otkrivena testiranjem ali je ispravljena
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * vraca niz tviter poruka uanpred zadate velicine koje sadrze zadati tag
	 * 
	 * @param maxBroj je maksimalan br rezultata koji medota moze da vrati
	 * @param tag predstavlja parametar za pretrazivanje i unosi se kao String
	 * @return niz objekata TwitterPoruka niz koji predstavlja rezulat pretrage
	 * @throws java.lang.RuntimeException u koliko nije unet tag
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
//					rezultat[brojac + 1] = poruke.get(i);    u ovoj linije je dolazilo do baga koji je sad ispravljen
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
