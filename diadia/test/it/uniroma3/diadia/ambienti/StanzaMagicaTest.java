package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagica stanzaMagica;
	private Attrezzo attrezzo, attrezzo2;
	private StringBuilder expectedReverse;

	@Before
	public void setUp() {
		stanzaMagica = new StanzaMagica("stanza magica", 1);
		attrezzo = new Attrezzo("penna", 1);
		attrezzo2 = new Attrezzo("spada", 10);
		stanzaMagica.addAttrezzo(attrezzo);
		expectedReverse = new StringBuilder(attrezzo2.getNome()).reverse();
	}

	@Test
	public void addAttrezzo_testFunzionamentoNormale() {
		assertNotNull(stanzaMagica.getAttrezzo(attrezzo.getNome()));
	}

	@Test
	public void addAttrezzo_testSuperataSogliaMagica() {
		stanzaMagica.addAttrezzo(attrezzo2);

		assertEquals("Dovrebbe restituire il nome invertito", expectedReverse.toString(),
				stanzaMagica.getAttrezzo(expectedReverse.toString()).getNome());

		assertEquals("Dovrebbe raddoppiare il peso", attrezzo2.getPeso() * 2,
				stanzaMagica.getAttrezzo(expectedReverse.toString()).getPeso());
	}

}
