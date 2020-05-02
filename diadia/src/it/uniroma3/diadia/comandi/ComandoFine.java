package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{

	private IO iO;

	@Override
	public void esegui(Partita partita) {
		iO.mostraMessaggio("Grazie di aver giocato!");
		partita.setFinita();
		
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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getNome() {
		return "fine";
	}

}
