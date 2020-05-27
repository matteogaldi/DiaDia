package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {
	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?";
	private String messaggio;
	
	public ComandoInteragisci() {
		super("interagisci");
	}

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio != null) {
			this.messaggio = personaggio.agisci(partita);
			this.getIO().mostraMessaggio(this.messaggio);
		} else {
			this.getIO().mostraMessaggio(MESSAGGIO_CON_CHI);
		}

	}

}
