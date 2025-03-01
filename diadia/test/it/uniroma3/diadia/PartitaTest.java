package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;

public class PartitaTest {

	private Partita partita;
	private Stanza stanzaVincente;
	private Stanza provaStanza;
	private Labirinto labirinto;

	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("iniziale")
				.addStanzaVincente("vincente")
				.getLabirinto();
		this.partita = new Partita(labirinto);
		
		this.stanzaVincente = this.labirinto.getStanzaVincente();
		this.provaStanza = new Stanza("Prova");

	}

	@Test
	public void testStanzaIniziale() {
		assertNotNull("Non dovrebbe essere null", partita.getStanzaCorrente());
	}

	@Test
	public void testSetStanzaCorrente() {
		partita.setStanzaCorrente(provaStanza);
		assertNotNull("Non dovrebbe essere null", partita.getStanzaCorrente());
	}

	// TEST getStanzaVincente
	@Test
	public void testStanzaVincente() {
		assertEquals("Stanza vincente non coincide con quella fornita da Labirinto ", stanzaVincente.toString(),
				partita.getStanzaVincente().toString());
	}

	@Test
	public void testPartitaVinta() {
		partita.setStanzaCorrente(stanzaVincente);
		assertEquals("Dovrebbe aver vinto", stanzaVincente.toString(), partita.getStanzaCorrente().toString());
	}

	// TEST isFinita
	@Test
	public void testParitaFinitaNoCfu() {
		partita.getGiocatore().setCfu(0);
		assertTrue("Dovrebbe essere finita", partita.isFinita());
	}

	@Test
	public void testPartitaFinitaSetTrue() {
		partita.setFinita();
		assertTrue("setFinita()@Partita.java non funziona", partita.isFinita());
	}
}
