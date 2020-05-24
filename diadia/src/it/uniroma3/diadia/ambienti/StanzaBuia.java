package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	static final private String MESSAGGIO = "qui c'è buio pesto";
	private String attrezzoIlluminante;

	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoIlluminante = attrezzo;
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
