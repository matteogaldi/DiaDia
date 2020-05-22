package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePeso;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Set<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashSet<Attrezzo>();
		this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi == 10)
			return false;
		this.attrezzi.add(attrezzo);
		this.numeroAttrezzi++;
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> i = this.attrezzi.iterator();
		while (i.hasNext()) {
			Attrezzo attrezzo = i.next();
			if (attrezzo.getNome().equals(nomeAttrezzo)) {
				return attrezzo;
			}
		}
		return null;
	}

	public int getPeso() {
		Iterator<Attrezzo> i = this.attrezzi.iterator();
		int peso = 0;
		while (i.hasNext()) {
			Attrezzo a = i.next();
			peso += a.getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	/**
	 * Rimuove l'attrezzo dalla borsa e ritorna l'attrezzo che è stato rimosso
	 * 
	 * @param nomeAttrezzo stringa che identifica il nome dell'attrezzo
	 * @return a l'attrezzo che è stato rimosso
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = this.getAttrezzo(nomeAttrezzo);
		this.attrezzi.remove(a);
		this.numeroAttrezzi--;
		return a;
	}

	public String toString() {
		Iterator<Attrezzo> i = this.attrezzi.iterator();
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			while (i.hasNext()) {
				Attrezzo a = i.next();
				s.append(a.toString() + " ");
			}

		} else
			s.append("Borsa vuota");
		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> result = new ArrayList<Attrezzo>(this.attrezzi);
		Collections.sort(result, new ComparatorePeso());
		return result;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		return new TreeSet<Attrezzo>(this.attrezzi);
	}

	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> result = new HashMap<Integer, Set<Attrezzo>>();
		Set<Attrezzo> temp;
		for (Attrezzo a : this.attrezzi) {
			if (result.containsKey(a.getPeso())) {
				temp = result.get(a.getPeso());
				temp.add(a);
			} else {
				temp = new TreeSet<Attrezzo>();
				temp.add(a);
				result.put(a.getPeso(), temp);
			}
		}
		return result;

	}
}
