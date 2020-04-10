package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

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

    static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

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
        Comando comandoDaEseguire = new Comando(istruzione);

        if (comandoDaEseguire.getNome() == null) {
            return false;
        }

        if (this.partita.getGiocatore().getCfu() == 0) {
            iO.mostraMessaggio("Game Over! Hai terminato i cfu");
            return true;
        }

        if (comandoDaEseguire.getNome().equals("fine")) {
            this.fine();
            return true;
        } else if (comandoDaEseguire.getNome().equals("vai"))
            this.vai(comandoDaEseguire.getParametro());
        else if (comandoDaEseguire.getNome().equals("aiuto"))
            this.aiuto();

        else if (comandoDaEseguire.getNome().equals("prendi")) {
            this.prendi(comandoDaEseguire.getParametro());
        } else if (comandoDaEseguire.getNome().equals("posa")) {
            this.posa(comandoDaEseguire.getParametro());
        } else
            iO.mostraMessaggio("Comando sconosciuto");
        if (this.partita.vinta()) {
            iO.mostraMessaggio("Hai vinto!");
            return true;
        } else
            return false;
    }

    // implementazioni dei comandi dell'utente:

    /**
     * Stampa informazioni di aiuto.
     */
    private void aiuto() {
        for (int i = 0; i < elencoComandi.length; i++)
            iO.mostraMessaggio(elencoComandi[i] + " ");
    }

    /**
     * Cerca di andare in una direzione. Se c'e' una stanza ci entra
     * e ne stampa il nome, altrimenti stampa un messaggio di errore
     */
    private void vai(String direzione) {
        if (direzione == null)
            iO.mostraMessaggio("Dove vuoi andare ?");
        Stanza prossimaStanza = null;
        prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
        if (prossimaStanza == null)
            iO.mostraMessaggio("Direzione inesistente");
        else {
            this.partita.setStanzaCorrente(prossimaStanza);
            int cfu = this.partita.getGiocatore().getCfu();
            this.partita.getGiocatore().setCfu(--cfu);
        }
        iO.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
    }

    /**
     * Comando "Fine".
     */
    private void fine() {
        iO.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
    }

    /**
     * Comando "Prendi".
     *
     * @param attrezzo nome attrezzo
     */
    private void prendi(String attrezzo) {
        Attrezzo a = null;
        if (attrezzo == null) {
            iO.mostraMessaggio("Che cosa vuoi prendere?");
        } else if (partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
            a = partita.getStanzaCorrente().getAttrezzo(attrezzo);
            if (partita.getStanzaCorrente().removeAttrezzo(a)) {
                partita.getGiocatore().getBorsa().addAttrezzo(a);
                iO.mostraMessaggio("Hai preso " + a.toString());
            }
        } else {
        	iO.mostraMessaggio("La stanza non ha questo oggetto");
		}
    }

    /**
     * Comando "Posa"
     *
     * @param attrezzo nome attrezzo
     */
    private void posa(String attrezzo) {
        Attrezzo a = null;
        if (attrezzo == null) {
            iO.mostraMessaggio("Cosa vuoi posare?");
        } else {
            if (partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
                a = partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
                this.partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
                if (this.partita.getStanzaCorrente().addAttrezzo(a)) {
                    iO.mostraMessaggio("Hai posato " + a.toString());
                }
            } else {
                iO.mostraMessaggio("Non possiedi questo oggetto");
            }
        }
    }

    public static void main(String[] argc) {
        DiaDia gioco = new DiaDia();
        iO = new IOConsole();
        gioco.gioca();
    }
}