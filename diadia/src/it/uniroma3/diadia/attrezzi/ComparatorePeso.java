package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatorePeso implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo a0, Attrezzo a1) {
		int res = a0.getPeso() - a1.getPeso();
		if (res != 0) {
			return res;
		}
		return a0.getNome().compareTo(a1.getNome());
	}

}
