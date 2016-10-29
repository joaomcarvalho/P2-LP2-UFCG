
// 115211593 - Joao Mauricio Carvalho: LAB 06 - Turma 1
import static org.junit.Assert.*;

import org.junit.Test;

public class LojaTest {
	@Test
	public void testConstrutor() {
		Loja loja = new Loja();
		assertEquals(0, loja.getTotalUsuarios());
	}

	@Test
	public void testCriaUsuario() throws Exception {
		Loja loja = new Loja();
		loja.criaUsuario("Joao Mauricio", "joao.carvalho", "Noob");
		assertEquals(1, loja.getTotalUsuarios());
		loja.criaUsuario("Thomas H. Cormen", "thomas.cormen", "Noob");
		assertEquals(2, loja.getTotalUsuarios());
	}

	@Test
	public void testVenda() throws Exception {
		Loja loja = new Loja();
		loja.criaUsuario("Joao Mauricio", "joao.carvalho", "Noob");
		Jogo ragnarok = new JogoDeRPG("Ragnarok", 10.00);

		loja.addDinheiro("joao.carvalho", 100);
		assertEquals(loja.getUsuario("joao.carvalho").getCarteira(), 100, 0.00001);

		loja.vendeJogo("joao.carvalho", ragnarok);
		assertEquals(9, loja.getTotalArrecadado(), 0.0001);

		Jogo lol = new JogoDeRPG("League of Legends", 10.00);
		loja.vendeJogo("joao.carvalho", lol);
		assertEquals(18, loja.getTotalArrecadado(), 0.0001);

	}

	@Test
	public void testUpgrade() throws Exception {
		Loja loja = new Loja();
		loja.criaUsuario("Joao Mauricio", "joao.carvalho", "Noob");
		loja.getUsuario("joao.carvalho").addX2p(10000);
		loja.upgradeUsuario("joao.carvalho");
		assertEquals(loja.getUsuario("joao.carvalho").getClass().getName(), "UsuarioVeterano");
	}

	@Test
	public void testToString() throws Exception {
		Loja loja = new Loja();
		loja.criaUsuario("Joao Mauricio", "joao.carvalho", "Noob");
		Jogo ragnarok = new JogoDeRPG("Ragnarok", 10.00);
		loja.addDinheiro("joao.carvalho", 666);
		loja.vendeJogo("joao.carvalho", ragnarok);

		String msg = "=== Central P2-CG ===\njoao.carvalho\nJoao Mauricio - Jogador Noob\nLista de Jogos:\n+ Ragnarok - RPG:\n==> Jogou 0 vez(es)\n==> Zerou 0 vez(es)\n==> Maior score: 0\n\nTotal de preço dos jogos: R$ 10.0";
		assertEquals(msg, loja.toString());
	}
}
