package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
	}
	
	@Test
	public void testStanzaVincente() {
		assertNotNull("Stanza vincente non inizializzata", this.labirinto.getStanzaVincente());
	}
	
	@Test
	public void testStanzaIniziale() {
		assertNotNull("Stanza iniziale non inizializzata", this.labirinto.getStanzaIniziale());
	}

}
