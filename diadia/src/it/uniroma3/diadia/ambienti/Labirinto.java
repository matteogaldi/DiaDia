package it.uniroma3.diadia.ambienti;

public class Labirinto {
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public void setStanzaIniziale(Stanza s) {
		this.stanzaIniziale = s;
	}

	public void setStanzaVincente(Stanza s) {
		this.stanzaVincente = s;
	}

}
