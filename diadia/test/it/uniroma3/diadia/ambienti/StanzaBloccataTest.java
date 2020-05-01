package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {
	private Stanza stanza;
	private Stanza stanzaAdiacente;
	private Attrezzo attrezzo;
	private StringBuilder messaggio = new StringBuilder("La stanza è bloccata, ti serve ");

	@Before
	public void setUp() {
		this.attrezzo = new Attrezzo("attrezzo", 5);
		this.stanza = new StanzaBloccata("stanzaBloccata", "nord", this.attrezzo);
		this.stanzaAdiacente = new Stanza("stanzaAdiacente");
		this.stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
		this.messaggio.append(this.attrezzo.getNome());
	}

	@Test
	public void creazioneStanzaTest() {
		assertNotNull(this.stanza);
	}

	@Test
	public void getDescrizione_testNoCompleta() {
		assertEquals("Descrizione errata", this.messaggio.toString(), this.stanza.getDescrizione());
	}

	@Test
	public void getStanzaAdiacente_bloccata() {
		assertEquals("Ritorna il riferimento sbagliato", this.stanza, this.stanza.getStanzaAdiacente("nord"));
	}

	@Test
	public void getStanzaAdiacente_sbloccata() {
		this.stanza.addAttrezzo(attrezzo);
		assertEquals("Non sblocca la stanza", this.stanzaAdiacente, this.stanza.getStanzaAdiacente("nord"));

	}

}
