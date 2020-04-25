package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 * <p>
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO
 * (da un'idea di Michael Kolling and David J. Barnes)
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = "" +
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n" +
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n" +
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n" +
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n" +
			"Per conoscere le istruzioni usa il comando 'aiuto'.";


	private Partita partita;
	public static IOConsole iO;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione;

		iO.mostraMessaggio(MESSAGGIO_BENVENUTO);
		//scannerDiLinee = new Scanner(System.in);
		do
			istruzione = iO.leggiRiga();
		while (!processaIstruzione(istruzione));
	}


	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();

		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);

		if (this.partita.getGiocatore().getCfu() == 0) {
			iO.mostraMessaggio("Game Over! Hai terminato i cfu");
		}
		
		if (this.partita.vinta()) {
			iO.mostraMessaggio("Hai vinto!");
		}
		
		return this.partita.isFinita();
	}


	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		iO = new IOConsole();
		gioco.gioca();
	}
}