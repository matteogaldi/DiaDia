package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {
	public ComandoVai() {
		super("vai");
	}

	public void esegui(Partita partita) {
		if (super.getParametro() == null)
			if (super.getIO() != null) {
				super.getIO().mostraMessaggio("Dove vuoi andare ?");
			}
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(super.getParametro());

		if (prossimaStanza == null)
			super.getIO().mostraMessaggio("super.getParametro() inesistente");
		else {
			partita.setStanzaCorrente(prossimaStanza);
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(--cfu);
		}

		super.getIO().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
}
