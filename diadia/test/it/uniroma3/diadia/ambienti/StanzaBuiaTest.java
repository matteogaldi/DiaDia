package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private String messaggio;
	private StanzaBuia stanza;
	private Attrezzo attrezzo;

	@Before
	public void setUp() {
		this.messaggio = "qui c'è buio pesto";
		this.attrezzo = new Attrezzo("attrezzo", 3);
		this.stanza = new StanzaBuia("stanza", attrezzo);
	}

	@Test
	public void getDescrizione_testNoAttrezzo() {
		assertEquals("La descrizione non è corretta", this.messaggio, this.stanza.getDescrizione());
	}
	
	@Test
	public void getDescrizione_testAttrezzoPresente() {
		this.stanza.addAttrezzo(attrezzo);
		assertEquals("La descrizione non è corretta", this.stanza.toString(), this.stanza.getDescrizione());
	}

}
