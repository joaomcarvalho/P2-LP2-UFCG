
// 115211593 - Joao Mauricio Carvalho: LAB 06 - Turma 1
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import exceptions.EntradaInvalida;
import exceptions.ValorException;

public class UsuarioTest {

	@Test
	public void testConstrutorVeterano() throws Exception {
		Usuario joao = new UsuarioVeterano("Joao Mauricio", "joao.carvalho");
		assertEquals("Joao Mauricio", joao.getNome());
		assertEquals("joao.carvalho", joao.getLogin());
		assertEquals(0.0, joao.getCarteira(), 0.0000001);
		assertEquals(1000, joao.getX2p());
	}

	@Test
	public void testConstrutorNoob() throws Exception {
		Usuario joao = new UsuarioNoob("Joao Mauricio", "joao.carvalho");
		assertEquals("Joao Mauricio", joao.getNome());
		assertEquals("joao.carvalho", joao.getLogin());
		assertEquals(0.0, joao.getCarteira(), 0.0000001);
		assertEquals(0, joao.getX2p());
	}

	@Test
	public void testConstrutorInvalido() {
		try {
			Usuario joao = new UsuarioNoob(" ", "joao.carvalho");
			fail();
		} catch (EntradaInvalida e) {
			assertEquals(e.getMessage(), "Nome não pode ser vazio.");
		}
		try {
			Usuario joao = new UsuarioVeterano("joao", "   ");
		} catch (EntradaInvalida e) {
			assertEquals(e.getMessage(), "Login não pode ser vazio.");
		}
	}

	@Test
	public void testCompraJogo() throws Exception {
		Usuario joao = new UsuarioNoob("Joao Mauricio", "joao.carvalho");
		Jogo ragnarok = new JogoDeRPG("Ragnarok", 10.00);
		joao.addDinheiro(9); // deveria ser possivel comprar devido o desconto
		joao.addJogo(ragnarok);
		assertEquals(ragnarok, joao.getJogo("Ragnarok"));

		Usuario gabi = new UsuarioVeterano("Gabriela Mota", "gabi.mota");
		gabi.addDinheiro(8);
		gabi.addJogo(ragnarok);
		assertEquals(ragnarok, gabi.getJogo("Ragnarok"));
		Jogo joguinho = new JogoDeRPG("Jogo", 10.00);
		try {
			gabi.addJogo(joguinho);
			fail();
		} catch (ValorException e) {
			assertEquals(e.getMessage(), "Fundos Insuficientes.");
		}
	}

	@Test
	public void testX2p() throws Exception {
		Usuario joao = new UsuarioNoob("Joao Mauricio", "joao.carvalho");
		Jogo ragnarok = new JogoDeRPG("Ragnarok", 10.00);
		joao.addDinheiro(9);
		joao.addJogo(ragnarok);
		joao.registraJogada("Ragnarok", 200, false);
		assertEquals(110, joao.getX2p());
		joao.registraJogada("Ragnarok", 400, true);
		assertEquals(120, joao.getX2p());
	}

	@Test
	public void testToString() throws Exception {
		Usuario joao = new UsuarioNoob("Joao Mauricio", "joao.carvalho");
		Jogo ragnarok = new JogoDeRPG("Ragnarok", 10.00);
		joao.addDinheiro(9);
		joao.addJogo(ragnarok);

		String msg = "joao.carvalho\nJoao Mauricio - Jogador Noob\nLista de Jogos:\n+ Ragnarok - RPG:\n==> Jogou 0 vez(es)\n==> Zerou 0 vez(es)\n==> Maior score: 0\n\nTotal de preço dos jogos: R$ 10.0";
		assertEquals(msg, joao.toString());

	}

}
