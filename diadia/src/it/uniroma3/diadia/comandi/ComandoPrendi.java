package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String attrezzo;
	private IO iO;

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = null;
		if (attrezzo == null) {
			if (iO != null)
				iO.mostraMessaggio("Che cosa vuoi prendere?");
		} else if (partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			a = partita.getStanzaCorrente().getAttrezzo(attrezzo);
			if (partita.getStanzaCorrente().removeAttrezzo(a)) {
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				if (iO != null)
					iO.mostraMessaggio("Hai preso " + a.toString());
			}
		} else {
			if (iO != null)
				iO.mostraMessaggio("La stanza non ha questo oggetto");
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;

	}

	public String getParametro() {
		return this.attrezzo;
	}

	@Override
	public IO getIO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIO(IO io) {
		this.iO = io;

	}
	
	@Override
	public String getNome() {
		return "prendi";
	}

}
