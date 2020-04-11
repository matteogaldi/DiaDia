package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

    private Stanza stanzaNord;
    private Stanza stanzaEst;
    private Stanza stanzaOvest;
    private Stanza stanzaSud;
    private Stanza stanzaAdiacenteVuota;
    private Stanza stanzaPiena;
    private Stanza stanzaNulla;
    private Attrezzo cacciavite;
    private Attrezzo accetta;
    private Attrezzo coltello;
    private Attrezzo incudine;
    private Attrezzo libro;

    @Before
    public void setUp() {
        this.stanzaNord = new Stanza("Nord");
        this.stanzaEst = new Stanza("Est");
        this.stanzaOvest = new Stanza("Ovest");
        this.stanzaSud = new Stanza("Sud");
        this.stanzaAdiacenteVuota = new Stanza("stanza adiacente ma vuota");
        this.stanzaPiena = new Stanza("stanza piena");
        this.stanzaNulla = new Stanza("stanza vuota");
        this.stanzaAdiacenteVuota.impostaStanzaAdiacente("nord", stanzaNord);
        this.stanzaAdiacenteVuota.impostaStanzaAdiacente("est", stanzaEst);
        this.stanzaAdiacenteVuota.impostaStanzaAdiacente("ovest", stanzaOvest);
        this.stanzaAdiacenteVuota.impostaStanzaAdiacente("sud", stanzaSud);
        this.incudine = new Attrezzo("incudine", 40);
        this.libro = new Attrezzo("libro", 3);
        this.accetta = new Attrezzo("accetta", 8);
        this.cacciavite = new Attrezzo("cacciavite", 1);
        this.coltello = new Attrezzo("coltello", 2);
        this.stanzaPiena.addAttrezzo(accetta);
        this.stanzaPiena.addAttrezzo(cacciavite);
        this.stanzaPiena.addAttrezzo(coltello);


    }

    /**
     * Test metodo getStanzaAdiacente
     */

    @Test
    public void testAdiacenteNord() {
        assertEquals("Non adiacente Nord", stanzaNord, this.stanzaAdiacenteVuota.getStanzaAdiacente("nord"));
    }

    @Test
    public void testAdiacenteEst() {
        assertEquals("Non adiacente Est", stanzaEst, this.stanzaAdiacenteVuota.getStanzaAdiacente("est"));
    }

    @Test
    public void testAdiacenteOvest() {
        assertEquals("Non adiacente Ovest", stanzaOvest, this.stanzaAdiacenteVuota.getStanzaAdiacente("ovest"));
    }

    @Test
    public void testAdiacenteSud() {
        assertEquals("Non adiacente Sud", stanzaSud, this.stanzaAdiacenteVuota.getStanzaAdiacente("sud"));
    }

    /**
     * Test metodo addStanzaAdiacente
     */

    @Test
    public void testAddStanzaAdiacenteNord() {
        this.stanzaPiena.impostaStanzaAdiacente("nord", stanzaNord);
        assertEquals("Errore impostazione stanza nord", stanzaNord, this.stanzaPiena.getStanzaAdiacente("nord"));
    }

    @Test
    public void testAddStanzaAdiacenteEst() {
        this.stanzaPiena.impostaStanzaAdiacente("est", stanzaEst);
        assertEquals("Errore impostazione stanza est", stanzaEst, this.stanzaPiena.getStanzaAdiacente("est"));
    }

    @Test
    public void testAddStanzaAdiacenteOvest() {
        this.stanzaPiena.impostaStanzaAdiacente("ovest", stanzaOvest);
        assertEquals("Errore impostazione stanza ovest", stanzaOvest, this.stanzaPiena.getStanzaAdiacente("ovest"));
    }

    @Test
    public void testAddStanzaAdiacenteSud() {
        this.stanzaPiena.impostaStanzaAdiacente("sud", stanzaSud);
        assertEquals("Errore impostazione stanza sud", stanzaSud, this.stanzaPiena.getStanzaAdiacente("sud"));
    }

    /**
     * Test metodo getDescrizione
     */

    @Test
    public void testGetStanzaAdiacenteVuota() {
        assertEquals("Errore descrizione stanza adiacente vuota ", "stanza adiacente ma vuota\nUscite:  nord est ovest sud\nAttrezzi nella stanza: ", this.stanzaAdiacenteVuota.getDescrizione());
    }

    @Test
    public void testGetStanzaPiena() {
        assertEquals("Errore descrizione stanza piena ", "stanza piena\nUscite: \nAttrezzi nella stanza: accetta (8kg) cacciavite (1kg) coltello (2kg) ", this.stanzaPiena.getDescrizione());
    }

    @Test
    public void testStanzaVuota() {
        assertEquals("Errore descrizione stanza vuota ", "stanza vuota\nUscite: \nAttrezzi nella stanza: ", this.stanzaNulla.getDescrizione());
    }

    /**
     * Test metodo addAttrezzo
     */

    @Test
    public void testAddAttrezzoStanzaPiena() {
        assertFalse("Non avrebbe dovuto aggiungerlo", this.stanzaPiena.addAttrezzo(incudine));
    }

    @Test
    public void testAddAttrezzoStanzaVuota() {
        assertTrue("Avrebbe dovuto aggiungerlo", this.stanzaAdiacenteVuota.addAttrezzo(libro));
    }

    @Test
    public void testAddAttrezzoSenzaAttrezzo() {
        assertEquals("Non ho aggiunto nessun attrezzo", false, this.stanzaAdiacenteVuota.addAttrezzo(null));
    }

    /**
     * Test metodo hasAttrezzo
     */

    @Test
    public void testHasAttrezzoPresente() {
        assertTrue("Errore ,dovrebbe esserci l'attrezzo", this.stanzaPiena.hasAttrezzo("cacciavite"));
    }

    @Test
    public void testHasAttrezzoAssente() {
        assertFalse("Errore, non dovrebbe esserci l'attrezzo", this.stanzaPiena.hasAttrezzo("osso"));
    }

    @Test
    public void testHasAttrezzoStanzaVuota() {
        assertEquals("Errore, non dovrebbe esserci nulla", false, this.stanzaAdiacenteVuota.hasAttrezzo("coltello"));
    }

    /**
     * Test metodo getAttrezzo
     */

    @Test
    public void testGetAttrezzoPresente() {
        assertEquals("Errore, l'attrezzo è presente", "cacciavite (1kg)", this.stanzaPiena.getAttrezzo("cacciavite").toString());
    }

    @Test
    public void testGetAttrezzoAssente() {
        assertEquals("Errore, l'attrezzo non è presente", null, this.stanzaPiena.getAttrezzo("osso"));
    }

    @Test
    public void testGetAttrezzoStanzaAdiacenteVuota() {
        assertEquals("Errore, la stanza dovrebbe essere vuota", null, this.stanzaAdiacenteVuota.getAttrezzo("coltello"));
    }

    /**
     * Test metodo removeAttrezzo
     */

   /*@Test
   public void testRemoveAttrezzoPresente()
   {
	   assertEquals("Errore, l'attrezzo era presente", true, this.stanzaPiena.removeAttrezzo(cacciavite));
   }*/
    @Test
    public void testRemoveAttrezzoAssente() {
        assertFalse("Errore, l'attrezzo non era presente", this.stanzaPiena.removeAttrezzo(incudine));
    }

    @Test
    public void testRemoveNiente() {
        Attrezzo a = null;
        assertFalse("Errore, non gli avevi dato nulla da rimuovere", this.stanzaAdiacenteVuota.removeAttrezzo(a));
    }
}
