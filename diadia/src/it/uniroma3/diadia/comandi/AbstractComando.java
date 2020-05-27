package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando {
	private IO iO;
	private String parametro;
	private String nome;

	public AbstractComando(String nome) {
		this.nome = nome;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getParametro() {
		return this.parametro;
	}

	abstract public void esegui(Partita partita);

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public IO getIO() {
		return this.iO;
	}

	public void setIO(IO io) {
		this.iO = io;
	}

}
