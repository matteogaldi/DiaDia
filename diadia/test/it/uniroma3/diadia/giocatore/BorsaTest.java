package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Attr;

public class BorsaTest {
    private Borsa borsa;
    private Borsa borsaPiena;
    private Borsa borsaQuasiVuota;

    private Attrezzo attrezzoUno;
    private Attrezzo attrezzoDue;
    private Attrezzo attrezzoPesante;

    @Before
    public void setUp() {

        this.borsa = new Borsa();
        this.borsaPiena = new Borsa();
        this.borsaQuasiVuota = new Borsa();

        attrezzoUno = new Attrezzo("Cinque", 5);
        attrezzoDue = new Attrezzo("Uno", 1);
        attrezzoPesante = new Attrezzo("Undici", 11);

        for (int i = 0; i < 10; i++) {
            borsaPiena.addAttrezzo(attrezzoDue);
        }
        borsaQuasiVuota.addAttrezzo(attrezzoUno);
    }


    /*
     * Tests addAttrezzo
     * */
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
     * */
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
    	assertEquals("Dovrebbe essere vuota","Borsa vuota", borsaQuasiVuota.toString());
	}


}
