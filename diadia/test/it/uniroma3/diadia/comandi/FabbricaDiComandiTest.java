package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiTest {
	private FabbricaDiComandi fc;
	private Comando comando;

	@Before
	public void setUp() {
		fc = new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void costruisciComando_testAiuto() {
		comando = fc.costruisciComando("aiuto");
		assertEquals("Non ha costruito il comando giusto", "aiuto", comando.getNome());
	}

	@Test
	public void costruisciComando_testFine() {
		comando = fc.costruisciComando("fine");
		assertEquals("Non ha costruito il comando giusto", "fine", comando.getNome());
	}

	@Test
	public void costruisciComando_testGuarda() {
		comando = fc.costruisciComando("guarda");
		assertEquals("Non ha costruito il comando giusto", "guarda", comando.getNome());
	}

	@Test
	public void costruisciComando_testPosa() {
		comando = fc.costruisciComando("posa");
		assertEquals("Non ha costruito il comando giusto", "posa", comando.getNome());
	}

	@Test
	public void costruisciComando_testPosaParametro() {
		comando = fc.costruisciComando("posa x");
		assertEquals("Non ha costruito il comando giusto", "x", comando.getParametro());
	}

	@Test
	public void costruisciComando_testPrendi() {
		comando = fc.costruisciComando("prendi");
		assertEquals("Non ha costruito il comando giusto", "prendi", comando.getNome());
	}

	@Test
	public void costruisciComando_testPrendiParametro() {
		comando = fc.costruisciComando("prendi x");
		assertEquals("Non ha costruito il comando giusto", "x", comando.getParametro());
	}

	@Test
	public void costruisciComando_testVai() {
		comando = fc.costruisciComando("vai");
		assertEquals("Non ha costruito il comando giusto", "vai", comando.getNome());
	}

	@Test
	public void costruisciComando_testVaiDirezione() {
		comando = fc.costruisciComando("vai direzione");
		assertEquals("Non ha costruito il comando giusto", "direzione", comando.getParametro());
	}

	@Test
	public void costruisciComando_testComandoNonValido() {
		comando = fc.costruisciComando("non valido");
		assertEquals("Non ha costruito il comando giusto", "comando non valido", comando.getNome());
	}

}
