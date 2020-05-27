package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {

	public ComandoFine() {
		super("fine");
	}

	@Override
	public void esegui(Partita partita) {
		super.getIO().mostraMessaggio("Grazie di aver giocato!");
		partita.setFinita();
	}
}
