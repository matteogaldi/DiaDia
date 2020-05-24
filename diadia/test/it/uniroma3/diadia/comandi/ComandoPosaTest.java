package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private Labirinto labirinto;

	private Comando posa;
	private FabbricaDiComandi fc;

	@Before
	public void setUp() {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("iniziale")
				.getLabirinto();
		fc = new FabbricaDiComandiFisarmonica();
		attrezzo = new Attrezzo("attrezzo", 5);
		partita = new Partita(labirinto);
		partita.getStanzaCorrente();
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);

	}

	@Test
	public void esegui_testParametro() {
		assertNull(partita.getStanzaCorrente().getAttrezzo("attrezzo"));
		posa = fc.costruisciComando("posa attrezzo");
		posa.esegui(partita);
		assertEquals("Dovrebbe stampare attrezzo", attrezzo, partita.getStanzaCorrente().getAttrezzo("attrezzo"));
	}

	@Test
	public void esegui_testNoParametro() {
		posa = fc.costruisciComando("posa");
		posa.esegui(partita);
		assertNull(((ComandoPosa) posa).getParametro());
	}

}
