package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	private Labirinto labirinto, builder;
	
	@Before
	public void setUp() {
		this.builder = new LabirintoBuilder()
				.addStanzaIniziale("iniziale")
				.addStanzaVincente("vincente")
				.getLabirinto();
		this.labirinto = builder;
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
