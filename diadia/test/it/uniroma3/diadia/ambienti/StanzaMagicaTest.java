package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;



public class StanzaMagicaTest {

    private StanzaMagica stanzaIniziale;
	private Attrezzo attrezzo1;
    private Attrezzo attrezzo2;
    private Attrezzo attrezzo3;
    private Attrezzo attrezzo4;

    @Before
    public void setUp() {
        stanzaIniziale=new StanzaMagica("stanza iniziale");
        attrezzo1=new Attrezzo("penna",1);
        attrezzo2=new Attrezzo("scudo",5);
        attrezzo3=new Attrezzo("spada",3);
        attrezzo4=new Attrezzo("martello",10);
    }

    @Test
    public void addAttrezzo1xTest() {
        stanzaIniziale.addAttrezzo(attrezzo1);
        assertEquals("l'attrezzo dovrebbe esser stato inserito",true,stanzaIniziale.hasAttrezzo("penna"));
    }

    @Test
    public void modificaAttrezzoNomeTest() {
        stanzaIniziale.addAttrezzo(attrezzo1);
        stanzaIniziale.addAttrezzo(attrezzo2);
        stanzaIniziale.addAttrezzo(attrezzo3);
        stanzaIniziale.addAttrezzo(attrezzo4);
        assertEquals("Dovrebbe modificare la stringa","",stanzaIniziale.getDescrizione());
    }
    
    @Test
    public void modificaAttrezzoPesoTest() {
        stanzaIniziale.addAttrezzo(attrezzo1);
        stanzaIniziale.addAttrezzo(attrezzo2);
        stanzaIniziale.addAttrezzo(attrezzo3);
        stanzaIniziale.addAttrezzo(attrezzo4);
        assertEquals("Dovrebbe modificare la stringa",20,stanzaIniziale.getAttrezzo("olletram").getPeso());
    }
}
