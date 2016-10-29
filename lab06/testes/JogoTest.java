
// 115211593 - Joao Mauricio Carvalho: LAB 06 - Turma 1
import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class JogoTest {

	@Test
	public void testeConstrutor1() throws Exception {
		Jogo ragnarok = new JogoDeRPG("Ragnarok", 10.00);
		assertEquals("Ragnarok", ragnarok.getNome());
		assertEquals(10.00, ragnarok.getPreco(), 0.0001);
		assertEquals(0, ragnarok.getMaiorScore());
		assertEquals(0, ragnarok.getVezesJogadas());
		assertEquals(0, ragnarok.getVezesZeradas());
	}

	@Test
	public void testeConstrutor2() throws Exception {
		HashSet<EstiloDeJogo> estilos = new HashSet<EstiloDeJogo>();
		estilos.add(EstiloDeJogo.ONLINE);
		estilos.add(EstiloDeJogo.MULTIPLAYER);

		Jogo lolzinho = new JogoDeRPG("League of Legends", 2.00, estilos);
		assertEquals("League of Legends", lolzinho.getNome());
		assertEquals(2.00, lolzinho.getPreco(), 0.0001);
		assertEquals(0, lolzinho.getMaiorScore());
		assertEquals(0, lolzinho.getVezesJogadas());
		assertEquals(0, lolzinho.getVezesZeradas());
		assertEquals(estilos, lolzinho.getEstiloDeJogo());
	}

	@Test
	public void testeConstrutorComExceptio() {
		try {
			Jogo jogoBugado = new JogoDeLuta("     ", 2.00);
			fail("Deveria ter lançado exceção, nome vazio");
		} catch (Exception e) {
			assertEquals("Nome não pode ser vazio.", e.getMessage());
		}
	}

	@Test
	public void testeJogo() throws Exception {
		Jogo gta = new JogoDeLuta("Grand Theft Auto", 159.00);
		gta.joga(250, true);
		assertEquals(250, gta.getMaiorScore());
		assertEquals(1, gta.getVezesZeradas());

		gta.joga(200, false);
		assertEquals(250, gta.getMaiorScore());
		assertEquals(1, gta.getVezesZeradas());
		assertEquals(2, gta.getVezesJogadas());
	}

	@Test
	public void testeToString() throws Exception {
		Jogo gta = new JogoDeLuta("Grand Theft Auto", 159.00);
		String msg = "+ Grand Theft Auto - Luta:\n==> Jogou 0 vez(es)\n==> Zerou 0 vez(es)\n==> Maior score: 0";
		assertEquals(msg, gta.toString());
	}
}
