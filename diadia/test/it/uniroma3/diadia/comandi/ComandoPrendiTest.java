package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private Labirinto labirinto;

	private Comando prendi;
	private FabbricaDiComandi fc;

	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("iniziale")
				.getLabirinto();
		prendi = new ComandoPrendi();
		fc = new FabbricaDiComandiFisarmonica();
		attrezzo = new Attrezzo("attrezzo", 5);
		partita = new Partita(labirinto);
		partita.getStanzaCorrente().addAttrezzo(attrezzo);

	}

	@Test
	public void esegui_testParametro() {
		assertNull(partita.getGiocatore().getBorsa().getAttrezzo("attrezzo"));
		prendi = fc.costruisciComando("prendi attrezzo");
		prendi.esegui(partita);
		assertEquals("Dovrebbe stampare attrezzo", attrezzo, partita.getGiocatore().getBorsa().getAttrezzo("attrezzo"));
	}

	@Test
	public void esegui_testNoParametro() {
		prendi = fc.costruisciComando("prendi");
		prendi.esegui(partita);
		assertNull(((ComandoPrendi) prendi).getParametro());
	}

}
