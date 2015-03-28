package com.twitter.poruke;

import java.util.GregorianCalendar;

public class TwitterPoruka {
	private String korisnik;
	private String poruka;
	private GregorianCalendar vreme = new GregorianCalendar();
	

	public GregorianCalendar getVreme() {
		return vreme;
	}

	public String getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	public String getPoruka() {
		return poruka;
	}

	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	public String toString() {
		return "KORISNIK:" + korisnik + " VREME:" + vreme.getTime()
				+ " PORUKA:" + poruka;
	}
}
