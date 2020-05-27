package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import jdk.nashorn.internal.ir.annotations.Immutable;

public class ComandoAiuto extends AbstractComando {

	public ComandoAiuto() {
		super("aiuto");
	}

	static final private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa", "guarda" };

	@Override
	public void esegui(Partita partita) {
		for (int i = 0; i < elencoComandi.length; i++)
			super.getIO().mostraMessaggio(elencoComandi[i] + " ");

	}

}
