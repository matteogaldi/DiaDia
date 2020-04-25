package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String attrezzo;

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = null;
		if (attrezzo == null) {
			DiaDia.iO.mostraMessaggio("Cosa vuoi posare?");
		} else {
			if (partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
				a = partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
				if (partita.getStanzaCorrente().addAttrezzo(a)) {
					DiaDia.iO.mostraMessaggio("Hai posato " + a.toString());
				}
			} else {
				DiaDia.iO.mostraMessaggio("Non possiedi questo oggetto");
			}
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;		
	}

}
