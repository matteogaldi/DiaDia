package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private Stanza ultimaStanza;
	private Map<String, Stanza> labirintoStanze;
	private Labirinto labirinto;
	private Map<String, String> direzioneOpposta;
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.labirintoStanze = new HashMap<String, Stanza>();
		this.direzioneOpposta = new HashMap<String, String>();
		direzioneOpposta.put("nord", "sud");
		direzioneOpposta.put("sud", "nord");
		direzioneOpposta.put("est", "ovest");
		direzioneOpposta.put("ovest", "est");
	}

	public LabirintoBuilder addStanzaIniziale(String stanza) {
		stanzaIniziale = new Stanza(stanza);
		labirinto.setStanzaIniziale(stanzaIniziale);
		this.labirintoStanze.put(stanza, stanzaIniziale);
		this.setUltimaStanza(stanzaIniziale);
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String stanza) {
		stanzaVincente = new Stanza(stanza);
		labirinto.setStanzaVincente(stanzaVincente);
		this.labirintoStanze.put(stanza, stanzaVincente);
		this.setUltimaStanza(stanzaVincente);
		return this;
	}

	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		labirintoStanze.put(stanza, s);
		this.setUltimaStanza(s);
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String nome) {
		Stanza s = new StanzaMagica(nome);
		this.labirintoStanze.put(nome, s);
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nome, String attrezzo) {
		Stanza s = new StanzaBuia(nome, attrezzo);
		this.labirintoStanze.put(nome, s);
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nome, String direzione, String attrezzo) {
		Stanza s = new StanzaBloccata(nome, direzione, attrezzo);
		this.labirintoStanze.put(nome, s);
		return this;
	}

	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		Attrezzo a = new Attrezzo(nome, peso);
		this.getUltimaStanza().addAttrezzo(a);
		return this;
	}

	public LabirintoBuilder addAdiacenza(String corrente, String adiacente, String direzione) {
		Stanza s0 = this.labirintoStanze.get(corrente);
		Stanza s1 = this.labirintoStanze.get(adiacente);
		s0.impostaStanzaAdiacente(direzione, s1);
		s1.impostaStanzaAdiacente(this.getDirezioneOpposta(direzione), s0);
		return this;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public Stanza getStanza(String s) {
		return this.labirintoStanze.get(s);
	}

	private void setUltimaStanza(Stanza s) {
		this.ultimaStanza = s;
	}

	private Stanza getUltimaStanza() {
		return this.ultimaStanza;
	}
	
	private String getDirezioneOpposta(String direzione) {
		return this.direzioneOpposta.get(direzione);
	}
	
}
