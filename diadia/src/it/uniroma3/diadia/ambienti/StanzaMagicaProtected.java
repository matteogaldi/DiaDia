package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {

	final static protected int SOGLIA_MAGICA_DEFAULT = 3;

	protected int contatoreAttrezziPosati;
	protected int sogliaMagica;

	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagicaProtected(String nome, int soglia) {
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
