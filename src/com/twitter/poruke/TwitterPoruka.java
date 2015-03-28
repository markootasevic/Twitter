package com.twitter.poruke;

import java.util.GregorianCalendar;
/**
 * Predstavlja 1 poruku na twitter-u
 * @author Marko
 *
 */

public class TwitterPoruka {
	/**
	 * predstavlja username korisnika
	 */
	private String korisnik;
	/**
	 * predstavlja tekst poruke tj tvita
	 */
	private String poruka;
	/**
	 * vreme kada je tvit postavljen
	 */
	private GregorianCalendar vreme = new GregorianCalendar();
	

	/**
	 *  vraca vreme kada je postavljen tvit
	 * @return vreme kao GregorianCalendar
	 */
	public GregorianCalendar getVreme() {
		return vreme;
	}

	/**
	 * vraca username korisnika
	 * @return korisnik kao String
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * postavlja username korisnika na unetu vrednost kao String
	 * @param korisnik
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * vraca poruku koju je korisnik postavio
	 * @return poruka kao String
	 */
	public String getPoruka() {
		return poruka;
	}

	/**
	 * postavlja poruku na unetu vrednost kao Sting
	 * @param poruka
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * vraca podatke o 1 tvitu
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " VREME:" + vreme.getTime()
				+ " PORUKA:" + poruka;
	}
}
