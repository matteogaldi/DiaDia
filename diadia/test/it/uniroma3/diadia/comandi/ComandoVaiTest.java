package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	private Partita partita;
	private Stanza stanza;
	private Stanza stanzaAdiacente;
	private Comando vai;
	private FabbricaDiComandi fc;
	private IO iO;
	private Labirinto labirinto;

	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder().addStanzaIniziale("iniziale").addStanza("stanza")
				.addAdiacenza("iniziale", "stanza", "nord").getLabirinto();

		iO = new IOConsole();
		partita = new Partita(labirinto);

		this.stanza = new Stanza("iniziale");
		this.stanzaAdiacente = new Stanza("stanza");
		this.stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
		this.stanzaAdiacente.impostaStanzaAdiacente("sud", stanza);

		fc = new FabbricaDiComandiFisarmonica();
		vai = new ComandoVai();
	}

	@Test
	public void esegui_testParametro() {
		vai = fc.costruisciComando("vai nord");
		vai.setIO(iO);
		vai.esegui(partita);
		assertEquals("Dovrebbe ritornare la stanza adiacente", stanzaAdiacente.toString(),
				partita.getStanzaCorrente().toString());
	}

	@Test
	public void esegui_testNoParametro() {
		vai = fc.costruisciComando("vai");
		vai.setIO(iO);
		vai.esegui(partita);
		assertEquals("Dovrebbe ritornare la stanza corrente", this.stanza.toString(),
				partita.getStanzaCorrente().toString());
	}

}
