package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	private Borsa borsa;
	private Borsa borsaPiena;
	private Borsa borsaQuasiVuota;
	private Borsa borsaDaOrdinare;

	private Attrezzo attrezzoUno;
	private Attrezzo attrezzoDue;
	private Attrezzo attrezzoPesante;

	private List<Attrezzo> attrezziPerPeso = new ArrayList<Attrezzo>();
	private Map<Integer, Set<Attrezzo>> attrezziRaggruppati = new HashMap<Integer, Set<Attrezzo>>();
	private Set<Attrezzo> attrezziPerNome = new TreeSet<Attrezzo>();
	private Set<Attrezzo> group0, group1;

	@Before
	public void setUp() {

		this.borsa = new Borsa();
		this.borsaPiena = new Borsa();
		this.borsaQuasiVuota = new Borsa();
		this.borsaDaOrdinare = new Borsa();

		attrezzoUno = new Attrezzo("Cinque", 5);
		attrezzoDue = new Attrezzo("Uno", 1);
		attrezzoPesante = new Attrezzo("Undici", 11);

		for (int i = 0; i < 10; i++) {
			borsaPiena.addAttrezzo(attrezzoDue);
		}
		borsaQuasiVuota.addAttrezzo(attrezzoUno);

		this.group0 = new TreeSet<Attrezzo>();
		group0.add(attrezzoDue);
		
		this.group1 = new TreeSet<Attrezzo>();
		group1.add(attrezzoUno);
		
		borsaDaOrdinare.addAttrezzo(attrezzoDue);
		borsaDaOrdinare.addAttrezzo(attrezzoUno);

		attrezziPerPeso.add(attrezzoDue);
		attrezziPerPeso.add(attrezzoUno);

		attrezziPerNome.add(attrezzoUno);
		attrezziPerNome.add(attrezzoDue);
		
		
		attrezziRaggruppati.put(1, group0);
		attrezziRaggruppati.put(5, group1);
	}

	/*
	 * Tests addAttrezzo
	 */
	@Test
	public void testAddAttrezzo() {
		borsa.addAttrezzo(attrezzoUno);
		assertEquals("Dovrebbe aggiungere l'attrezzo", attrezzoUno, borsa.getAttrezzo(attrezzoUno.getNome()));
	}

	@Test
	public void testAddAttrezzoBorsaPiena() {
		assertFalse("Non dovrebbe essere possibile", borsaPiena.addAttrezzo(attrezzoDue));
	}

	@Test
	public void testAddAttrezzoTroppoPesante() {
		assertFalse("Attrezzo troppo pesante per la borsa", borsa.addAttrezzo(attrezzoPesante));
	}

	/*
	 * Tests removeAttrezzo
	 */
	@Test
	public void testRemoveAttrezzo() {
		borsaQuasiVuota.removeAttrezzo(attrezzoUno.getNome());
		assertTrue("Dovrebbe essere vuoto", borsaQuasiVuota.isEmpty());
	}

	@Test
	public void testRemoveAttrezzoBorsaVuota() {
		assertNull("Dovrebbe essere null", borsa.removeAttrezzo(attrezzoUno.getNome()));
	}

	@Test
	public void testRemoveAttrezzoBorsaVuotaToString() {
		borsaQuasiVuota.removeAttrezzo("Uno");
		assertEquals("Dovrebbe essere vuota", "Borsa vuota", borsaQuasiVuota.toString());
	}

	/*
	 * Test getAttrezzo
	 */
	@Test
	public void testGetAttrezzo() {
		assertEquals("Dovrebbero essere uguali", attrezzoUno, borsaQuasiVuota.getAttrezzo(attrezzoUno.getNome()));
	}

	@Test
	public void testGetAttrezzoInesistente() {
		assertNull("Dovrebbe essere null", borsaQuasiVuota.getAttrezzo(attrezzoDue.getNome()));
	}

	@Test
	public void testGetAttrezzoNull() {
		assertNull("Dovrebbe essere null", borsaQuasiVuota.getAttrezzo(""));
	}

	/*
	 * Test contenuto ordinato
	 */
	@Test
	public void test_getContenutoOrdinatoPerPeso() {
		assertEquals(attrezziPerPeso, borsaDaOrdinare.getContenutoOrdinatoPerPeso());
	}

	@Test
	public void test_getContenutoOrdinatoPerNome() {
		assertEquals(attrezziPerNome, borsaDaOrdinare.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void test_getContenutoRaggruppato() {
		assertEquals(attrezziRaggruppati, borsaDaOrdinare.getContenutoRaggruppatoPerPeso());
	}

}
