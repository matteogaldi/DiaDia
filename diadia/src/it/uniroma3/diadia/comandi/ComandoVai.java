package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.DiaDia;

public class ComandoVai implements Comando {
    private String direzione;

    @Override
    public void esegui(Partita partita) {
        if (direzione == null)
            DiaDia.iO.mostraMessaggio("Dove vuoi andare ?");
        Stanza prossimaStanza = null;
        prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
        if (prossimaStanza == null)
            DiaDia.iO.mostraMessaggio("Direzione inesistente");
        else {
            partita.setStanzaCorrente(prossimaStanza);
            int cfu = partita.getGiocatore().getCfu();
            partita.getGiocatore().setCfu(--cfu);
        }
        DiaDia.iO.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }
}
