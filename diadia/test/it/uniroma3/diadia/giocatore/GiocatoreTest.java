package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {
	private Giocatore giocatore;
	private int cfu;

	@Before
	public void setUp() {
		this.giocatore = new Giocatore();
		this.cfu = giocatore.getCfu();
	}

	@Test
	public void testSetCfu() {
		assertTrue("Dovrebbe assegnare i CFU", giocatore.setCfu(cfu++));
	}

	@Test
	public void testSetCfuNegativi() {
		assertFalse("Non dovrebbe assegnare cfu minori di 0", giocatore.setCfu(-1));
	}

	@Test
	public void testSetCfuAZero() {
		this.cfu = 1;
		assertTrue("Non dovrebbe assegnare cfu sotto lo 0", giocatore.setCfu(cfu--));
	}


}
