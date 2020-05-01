package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza {

	static final private String MESSAGGIO = "qui c'è buio pesto";
	private String attrezzoIlluminante; 

	public StanzaBuia(String nome, Attrezzo attrezzo) {
		super(nome);
		this.attrezzoIlluminante = attrezzo.getNome();
	}

	@Override
	public String getDescrizione() {
		if (this.hasAttrezzo(attrezzoIlluminante)) {
			return super.getDescrizione();
		} else {
			return MESSAGGIO;
		}
	}
}
