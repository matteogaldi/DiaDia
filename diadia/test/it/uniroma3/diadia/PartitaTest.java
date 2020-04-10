package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;

public class PartitaTest {

	private Partita partita;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Stanza provaStanza;
	private Labirinto labirinto;


	@Before
	public void setUp() {
		this.partita = new Partita();
		this.labirinto = new Labirinto();
		this.stanzaVincente = this.labirinto.getStanzaVincente();
		this.stanzaCorrente = partita.getStanzaCorrente();

	}

	@Test
	public void testStanzaIniziale() {
		assertEquals("Stanza iniziale non coincide con quella fornita da Labirinto ", stanzaCorrente,
				partita.getStanzaCorrente());
	}
	@Test
	public void testSetStanzaCorrente() {
		partita.setStanzaCorrente(provaStanza);
		assertEquals("StanzaCorrente non è aggiornata correttamente", provaStanza,
				partita.getStanzaCorrente());
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
	public void testStanzaVincenteNull() {
		partita.setStanzaCorrente(null);
		assertNull("Dovrebbe essere null", partita.getStanzaVincente());
	}
	
	// TEST isFinita
	@Test 
	public void testParitaFinitaNoCfu() {
		partita.giocatore.setCfu(0);
		assertTrue("Dovrebbe essere finita", partita.isFinita());
	}
	@Test
	public void testPartitaFinitaSetTrue() {
		partita.setFinita();
		assertTrue("setFinita()@Partita.java non funziona", partita.isFinita());
	}
}
