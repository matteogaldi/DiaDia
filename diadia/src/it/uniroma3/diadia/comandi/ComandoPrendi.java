package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {

	public ComandoPrendi() {
		super("prendi");
	}

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = null;
		if (super.getParametro() == null) {
			if (super.getIO() != null)
				super.getIO().mostraMessaggio("Che cosa vuoi prendere?");
		} else if (partita.getStanzaCorrente().hasAttrezzo(super.getParametro())) {
			a = partita.getStanzaCorrente().getAttrezzo(super.getParametro());
			if (partita.getStanzaCorrente().removeAttrezzo(a)) {
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				if (super.getIO() != null)
					super.getIO().mostraMessaggio("Hai preso " + a.toString());
			}
		} else {
			if (super.getIO() != null)
				super.getIO().mostraMessaggio("La stanza non ha questo oggetto");
		}

	}

}
