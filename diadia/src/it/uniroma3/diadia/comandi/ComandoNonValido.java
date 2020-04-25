package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	static final private String MSG = "Questo comando non è valido";

	@Override
	public void esegui(Partita partita) {
		DiaDia.iO.mostraMessaggio(MSG);

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
