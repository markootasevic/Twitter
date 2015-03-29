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
	 * @return listu poruka kao objekte tipa TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	// Pomocna metoda koja vraca username korisnika sa indexom 0 u listi poruka
	public String vratiKorisnika() {
		return poruke.get(0).getKorisnik();
	}

	// pomocna metoda koja poredi listu sa listom poruke iz ove klase tako sto uporedjuje 1 po 1 element
	public boolean uporediListe(LinkedList<TwitterPoruka> l1) {
		for (int i = 0; i < l1.size(); i++) {
			if (l1.get(i).getKorisnik().equals(poruke.get(i).getKorisnik())
					&& l1.get(i).getPoruka().equals(poruke.get(i).getPoruka())
					&& l1.get(i).getVreme().equals(poruke.get(i).getVreme())) {

			} else
				return false;
		}
		return true;
	}

	// pomocna metoda koja poredi 2 niza
	public boolean uporedi2Niza(TwitterPoruka[] t1, TwitterPoruka[] t2) {
		for (int i = 0; i < t1.length; i++) {
			if (t1[i].getKorisnik().equals(t2[i].getKorisnik())
					&& t1[i].getPoruka().equals(t2[i].getPoruka())
					&& t1[i].getVreme().equals(t2[i].getVreme())) {

			} else
				return false;
		}
		return true;
	}

	/**
	 * metoda pravi novu tviter poruku i ubacuje je u listu na kraj
	 * 
	 * @param korisnik
	 * @param poruka
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
	 * @param maxBroj
	 * @param tag
	 * @return niz objekata TwitterPoruka
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
