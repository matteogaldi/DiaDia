package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LabirintoBuilderTest {
	private LabirintoBuilder labirinto, monolocale, bilocale, trilocale;
	static final private String INIZIALE = "atrio";
	static final private String STANZA = "n11";
	static final private String STANZA_ADIACENTE = "n12";
	static final private String DIREZIONE = "nord";
	static final private String ATTREZZO = "chiave";

	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder();

		this.bilocale = new LabirintoBuilder().addStanzaIniziale(INIZIALE).addStanza(STANZA_ADIACENTE);

		this.trilocale = new LabirintoBuilder().addStanzaIniziale(INIZIALE).addStanza(STANZA)
				.addStanza(STANZA_ADIACENTE).addStanzaVincente(STANZA);
	}

	@Test
	public void addStanza_test() {
		labirinto.addStanza(STANZA);
		assertEquals(STANZA, this.labirinto.getStanza(STANZA).getNome());
	}

	@Test
	public void addStanzaIniziale_test() {
		labirinto.addStanzaIniziale(INIZIALE);
		assertEquals(INIZIALE, labirinto.getLabirinto().getStanzaIniziale().getNome());
	}

	@Test
	public void addStanzaVincente_test() {
		labirinto.addStanzaVincente(STANZA);
		assertEquals(STANZA, labirinto.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void addAttrezzo_test() {
		labirinto.addStanza(STANZA).addStanza(STANZA_ADIACENTE).addAttrezzo(ATTREZZO, 1);
		assertTrue(labirinto.getStanza(STANZA_ADIACENTE).hasAttrezzo(ATTREZZO));
		assertFalse(labirinto.getStanza(STANZA).hasAttrezzo(ATTREZZO));
	}

	@Test
	public void addAdiacenza_test() {
		this.bilocale.addAdiacenza(INIZIALE, STANZA_ADIACENTE, DIREZIONE);
		assertEquals(STANZA_ADIACENTE, this.bilocale.getStanza(INIZIALE).getStanzaAdiacente(DIREZIONE).getNome());
	}
	
	@Test
	public void addAttrezzo_trilocale_test() {
		trilocale.addAttrezzo(ATTREZZO, 1);
		assertFalse(trilocale.getStanza(STANZA_ADIACENTE).hasAttrezzo(ATTREZZO));
		assertTrue(trilocale.getStanza(STANZA).hasAttrezzo(ATTREZZO));
	}

}
