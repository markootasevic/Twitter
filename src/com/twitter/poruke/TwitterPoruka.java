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
	 * @return vreme kao GregorianCalendar i predstavlja vreme postavljanja tvita
	 */
	public GregorianCalendar getVreme() {
		return vreme;
	}

	/**
	 * vraca username korisnika
	 * @return korisnik kao String sto predstavlja username korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * postavlja username korisnika na unetu vrednost kao String
	 * @param korisnik koji predstavlja username korisnika kao String
	 * @throws java.lang.RuntimeException ako nije unesen korisnik
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
	 * @param poruka koji predstavlja unesenu poruku kao String
	 * @throws java.lang.RuntimeException ako nije unesena poruka
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



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwitterPoruka other = (TwitterPoruka) obj;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (poruka == null) {
			if (other.poruka != null)
				return false;
		} else if (!poruka.equals(other.poruka))
			return false;
		if (vreme == null) {
			if (other.vreme != null)
				return false;
		} else if (!vreme.equals(other.vreme))
			return false;
		return true;
	}
	
}
