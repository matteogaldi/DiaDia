package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	private Partita partita;
	private Stanza stanza;
	private Stanza stanzaAdiacente;
	private Comando vai;
	private FabbricaDiComandi fc;
	private IO iO;

	@Before
	public void setUp() {
		iO = new IOConsole();
		partita = new Partita();

		stanza = new Stanza("stanza");
		stanzaAdiacente = new Stanza("stanza adiacente");

		stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
		partita.setStanzaCorrente(stanza);

		fc = new FabbricaDiComandiFisarmonica();
		vai = new ComandoVai();
	}

	@Test
	public void esegui_testParametro() {
		vai = fc.costruisciComando("vai nord");
		vai.setIO(iO);
		vai.esegui(partita);
		assertEquals("Dovrebbe ritornare la stanza adiacente", stanzaAdiacente, partita.getStanzaCorrente());
	}
	
	@Test
	public void esegui_testNoParametro() {
		vai = fc.costruisciComando("vai");
		vai.setIO(iO);
		vai.esegui(partita);
		assertEquals("Dovrebbe ritornare la stanza corrente", this.stanza, partita.getStanzaCorrente());
	}

}
