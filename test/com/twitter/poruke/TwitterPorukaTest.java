/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Marko
 * 
 */
public class TwitterPorukaTest {
	private TwitterPoruka poruka;

	/**
	 * @throws java.lang.Exception .
	 */
	@Before
	public void setUp() throws Exception {
		poruka = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception .
	 */
	@After
	public void tearDown() throws Exception {
		poruka = null;
	}

	/**
	 * Test method for
	 * {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		poruka.setKorisnik(null);
	}

	/**
	 * Test method for
	 * {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		poruka.setKorisnik("");
	}

	/**
	 * Test method for
	 * {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnikNekoIme() {
		poruka.setKorisnik("marko");
		assertEquals("marko", poruka.getKorisnik());
	}

	/**
	 * Test method for
	 * {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		poruka.setPoruka("Sto je danas lep i suncan dan");
		assertEquals("Sto je danas lep i suncan dan", poruka.getPoruka());
	}

	/**
	 * Test method for
	 * {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		poruka.setPoruka(null);
	}

	/**
	 * Test method for
	 * {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaDugackaPoruka() {
		poruka.setPoruka("Vertikalne trzisne veze su veze onih koji prethode i onih koji slede. "
				+ "Prostiru se od dobijanja primarne sirovine do krajnje prerade. Istrazivanjem i proucavanjem ove vrste "
				+ "trzisne veze stvara se informaciona osnova za izbor najpovoljnijeg nacina distribucije do krajnjeg potrosaca. "
				+ "Tipican primer vertikalne trzišne veze je: proizvodjac - trgovina na veliko,na malo, maloprodaja.");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		poruka.setKorisnik("Marko");
		poruka.setPoruka("Ovo je jedna ne tako interesantna poruka");
		assertEquals("KORISNIK:Marko" + " VREME:" + new GregorianCalendar().getTime()
				+ " PORUKA:Ovo je jedna ne tako interesantna poruka" ,poruka.toString());
	}

}
