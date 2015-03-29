/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Marko
 *
 */
public class TwitterTest {
	Twitter tviter;
	TwitterPoruka poruka;
	LinkedList<TwitterPoruka> pomocnaLista;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tviter = new Twitter();
		poruka = new TwitterPoruka();
		pomocnaLista = new LinkedList<TwitterPoruka>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tviter  = null;
		poruka = null;
		pomocnaLista = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePorukeNull() {
		assertEquals(pomocnaLista,tviter.vratiSvePoruke());
	}
	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePorukeJednaPoruka() {
		poruka.setKorisnik("Marko");
		poruka.setPoruka("Ovo je jedna dosadna poruka");
		pomocnaLista.addLast(poruka);
		tviter.unesi("Marko", "Ovo je jedna dosadna poruka");
		assertEquals(true,tviter.uporediListe(pomocnaLista));
	}
	//ovde je primeceno da metoda unesi ne unosi korisnika vec sama postavlja vrednost na "korisnik"

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePorukeVisePoruka() {
		TwitterPoruka p = new TwitterPoruka();
		poruka.setKorisnik("Marko");
		poruka.setPoruka("Ovo je jedna dosadna poruka");
		pomocnaLista.addLast(poruka);
		tviter.unesi(poruka.getKorisnik(), poruka.getPoruka());
		p.setKorisnik("Milica");
		p.setPoruka("Ne mogu stalno sa smisljam nove poruke");
		pomocnaLista.addLast(p);
		tviter.unesi(p.getKorisnik(), p.getPoruka());
		assertEquals(true,tviter.uporediListe(pomocnaLista));
	}
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesiSimulacijaGreske() {
		poruka.setKorisnik("Pera Peric");
		poruka.setPoruka("Najcesce ime u metodama");
		tviter.unesi(poruka.getKorisnik(), poruka.getPoruka());
		pomocnaLista.addLast(poruka);
		assertEquals(poruka.getKorisnik(),tviter.vratiKorisnika()); // dolazi do greske u unosu korisnika
	}
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		poruka.setKorisnik("Pera Peric");
		poruka.setPoruka("Najcesce ime u metodama");
		tviter.unesi(poruka.getKorisnik(), poruka.getPoruka());
		pomocnaLista.addLast(poruka);
		assertEquals(true,tviter.uporediListe(pomocnaLista));
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		TwitterPoruka p1 = new TwitterPoruka();
		TwitterPoruka p2 = new TwitterPoruka();
		TwitterPoruka p3 = new TwitterPoruka();
		TwitterPoruka[] pomocniNiz = new TwitterPoruka[2];
		p1.setKorisnik("Marko");
		p2.setKorisnik("Milica");
		p3.setKorisnik("Zeljko");
		p1.setPoruka("prva poruka");
		p2.setPoruka("druga poruka");
		p3.setPoruka("ova nece da se pojavi u pretrazi");
		tviter.unesi(p1.getKorisnik(), p1.getPoruka());
		tviter.unesi(p2.getKorisnik(), p2.getPoruka());
		tviter.unesi(p3.getKorisnik(), p3.getPoruka());
		pomocniNiz[0] = p1;
		pomocniNiz[1] = p2;
		assertEquals(true, tviter.uporedi2Niza(pomocniNiz, tviter.vratiPoruke(2, "poruka")));
	} // primeceno da dolazi do greske u metodi vratiPoruke,i ako pise da niz ima 2 mesta metoda postavlja element na 3. mesto u nizu

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagJeNull() {
		tviter.vratiPoruke(50, null);
	}
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanTag() {
		tviter.vratiPoruke(50, "");
	}
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test 
	public void testVratiPorukeMaxBrManjiOdNule() {
		TwitterPoruka [] pomocni = tviter.vratiPoruke(-4, "nebitno za pricu,samo da nije prazan string ili null");
		assertEquals(100,pomocni.length);
	}
}
