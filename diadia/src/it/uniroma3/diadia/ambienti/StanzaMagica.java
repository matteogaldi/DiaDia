package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {

	final static private int SOGLIA_MAGICA_DEFAULT = 3;

	private int contatoreAttrezziPosati;
	private int sogliaMagica;

	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder attrezzoInvertito = new StringBuilder(attrezzo.getNome());
		int pesoModificato = attrezzo.getPeso() * 2;
		attrezzoInvertito = attrezzoInvertito.reverse();
		attrezzo = new Attrezzo(attrezzoInvertito.toString(), pesoModificato);
		return attrezzo;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati > sogliaMagica) {
			return super.addAttrezzo(this.modificaAttrezzo(attrezzo));
		} else {
			return super.addAttrezzo(attrezzo);
		}
	}

}
