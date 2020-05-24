package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 * <p>
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IO iO;

	public DiaDia(Labirinto labirinto, IO io) {
		this.partita = new Partita(labirinto);
		this.iO = io;
	}

	public void gioca() {
		String istruzione;

		iO.mostraMessaggio(MESSAGGIO_BENVENUTO);
		// scannerDiLinee = new Scanner(System.in);
		do
			istruzione = iO.leggiRiga();
		while (!processaIstruzione(istruzione));
	}

	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();

		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.setIO(iO);
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
		IO iO = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanza("N10")
				.addAttrezzo("lanterna", 3)
				.addStanzaBuia("N11", "lanterna")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne", "N10", "est")
				.addAdiacenza("N10", "N11", "est")
				.addAdiacenza("N11", "Biblioteca", "nord")
				.getLabirinto();
		
		DiaDia gioco = new DiaDia(labirinto, iO);

		gioco.gioca();
	}
}