package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	public ComandoPosa() {
		super("posa");
	}

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = null;
		if (super.getParametro() == null) {
			if (super.getIO() != null)
				super.getIO().mostraMessaggio("Cosa vuoi posare?");
		} else {
			if (partita.getGiocatore().getBorsa().hasAttrezzo(super.getParametro())) {
				a = partita.getGiocatore().getBorsa().getAttrezzo(super.getParametro());
				partita.getGiocatore().getBorsa().removeAttrezzo(super.getParametro());
				if (partita.getStanzaCorrente().addAttrezzo(a)) {
					if (super.getIO() != null)
						super.getIO().mostraMessaggio("Hai posato " + a.toString());
				}
			} else {
				if (super.getIO() != null)
					super.getIO().mostraMessaggio("Non possiedi questo oggetto");
			}
		}

	}
}
