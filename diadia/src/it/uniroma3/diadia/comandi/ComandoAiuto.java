package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	private IO iO;
	@Override
	public void esegui(Partita partita) {
		for (int i = 0; i < elencoComandi.length; i++)
			iO.mostraMessaggio(elencoComandi[i] + " ");
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}

	@Override
	public IO getIO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIO(IO io) {
		this.iO = io;
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return "aiuto";
	}

}
