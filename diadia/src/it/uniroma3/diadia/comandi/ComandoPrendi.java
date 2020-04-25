package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String attrezzo;

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;

	}
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = null;
		if (attrezzo == null) {
			DiaDia.iO.mostraMessaggio("Che cosa vuoi prendere?");
		} else if (partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			a = partita.getStanzaCorrente().getAttrezzo(attrezzo);
			if (partita.getStanzaCorrente().removeAttrezzo(a)) {
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				DiaDia.iO.mostraMessaggio("Hai preso " + a.toString());
			}
		} else {
			DiaDia.iO.mostraMessaggio("La stanza non ha questo oggetto");
		}

	}

}
