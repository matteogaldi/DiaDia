package it.uniroma3.diadia.ambienti;


public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String attrezzoSbloccante;
	private Boolean sbloccata;
	private StringBuilder messaggio = new StringBuilder("La stanza è bloccata, ti serve ");

	public StanzaBloccata(String nome) {
		super(nome);
		this.sbloccata = false;
	}

	public StanzaBloccata(String nome, String direzione, String attrezzo) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoSbloccante = attrezzo;
		this.sbloccata = false;
	}

	public String getAttrezzoSbloccante() {
		return this.attrezzoSbloccante;
	}

	public String getDirezioneBloccata() {
		return this.direzioneBloccata;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {

		if (this.hasAttrezzo(this.attrezzoSbloccante)) {
			this.sbloccata = true;
		}

		if (this.sbloccata) {
			return super.getStanzaAdiacente(direzione);
		} else {
			return this;
		}
	}

	@Override
	public String getDescrizione() {
		if (sbloccata) {
			return super.getDescrizione();
		} else {
			messaggio.append(this.getAttrezzoSbloccante());
			return this.messaggio.toString();
		}
	}

}
