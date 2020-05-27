package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

	public ComandoGuarda() {
		super("guarda");
	}

	@Override
	public void esegui(Partita partita) {
		super.getIO().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

}
