package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public interface Comando {
	public void setParametro(String parametro);
	public String getParametro();
	public String getNome();
	public void esegui(Partita partita);
	public IO getIO();
	public void setIO(IO io);
}
