package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String attrezzo;
	private IO iO;

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = null;
		if (attrezzo == null) {
			if (iO != null)
				iO.mostraMessaggio("Cosa vuoi posare?");
		} else {
			if (partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
				a = partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
				if (partita.getStanzaCorrente().addAttrezzo(a)) {
					if (iO != null)
						iO.mostraMessaggio("Hai posato " + a.toString());
				}
			} else {
				if (iO != null)
					iO.mostraMessaggio("Non possiedi questo oggetto");
			}
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
		return "posa";
	}

}
