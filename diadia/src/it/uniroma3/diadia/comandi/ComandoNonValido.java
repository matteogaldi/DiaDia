package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	public ComandoNonValido() {
		super("comando non valido");
	}

	static final private String MSG = "Questo comando non è valido";

	@Override
	public void esegui(Partita partita) {
		super.getIO().mostraMessaggio(MSG);
	}

}
