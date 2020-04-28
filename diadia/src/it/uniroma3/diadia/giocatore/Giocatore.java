package it.uniroma3.diadia.giocatore;

public class Giocatore {

	static final private int CFU_INIZIALI = 20;
	private int cfu = CFU_INIZIALI;
	private Borsa borsa = new Borsa();

	public int getCfu() {
		return this.cfu;
	}

	public boolean setCfu(int cfu) {
		if (cfu >= 0) {
			this.cfu = cfu;
			return true;
		} else {
			return false;
		}

	}

	public Borsa getBorsa() {
		return borsa;
	}
}
