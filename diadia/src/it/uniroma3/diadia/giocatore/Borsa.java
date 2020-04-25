package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
    public final static int DEFAULT_PESO_MAX_BORSA = 10;
    private Attrezzo[] attrezzi;
    private int numeroAttrezzi;
    private int pesoMax;

    public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA);
    }

    public Borsa(int pesoMax) {
        this.pesoMax = pesoMax;
        this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
        this.numeroAttrezzi = 0;
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
            return false;
        if (this.numeroAttrezzi == 10)
            return false;
        this.attrezzi[this.numeroAttrezzi] = attrezzo;
        this.numeroAttrezzi++;
        return true;
    }

    public int getPesoMax() {
        return pesoMax;
    }

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        Attrezzo a = null;
        for (int i = 0; i < this.numeroAttrezzi; i++) {
            if (this.attrezzi[i] == null) {
                i++;
            } else if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
                a = attrezzi[i];
        }
        return a;
    }

    public int getPeso() {
        int peso = 0;
        for (int i = 0; i < this.numeroAttrezzi; i++)
            peso += this.attrezzi[i].getPeso();
        return peso;
    }

    public boolean isEmpty() {
        return this.numeroAttrezzi == 0;
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.getAttrezzo(nomeAttrezzo) != null;
    }

    /**
     * Rimuove l'attrezzo dalla borsa e ritorna l'attrezzo che è
     * stato rimosso
     * 
     * @param nomeAttrezzo stringa che identifica il nome dell'attrezzo
     * @return a l'attrezzo che è stato rimosso
     */
    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
        Attrezzo a = this.getAttrezzo(nomeAttrezzo);
        for (int i = 0; i < this.attrezzi.length; i++) {
            if (this.attrezzi[i] == a) {
                attrezzi[i] = null;
                for (int j = i; j < numeroAttrezzi-1; j++) {
                    attrezzi[j] = attrezzi[j+1];
                }
                this.numeroAttrezzi--;
                return a;
            }
        }
        return a;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        if (!this.isEmpty()) {
            s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
            for (int i = 0; i < this.numeroAttrezzi; i++)
                s.append(attrezzi[i].toString() + " ");
        } else
            s.append("Borsa vuota");
        return s.toString();
    }
}


