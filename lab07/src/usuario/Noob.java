// 115211593 - Joao Mauricio Alves Valverde Carvalho: LAB07 - Turma 01

package usuario;

import java.util.Iterator;
import java.util.Set;

import excecoes.StringInvalidaException;
import excecoes.ValorInvalidoException;
import jogo.Jogabilidade;
import jogo.Jogo;

public class Noob implements TipoDeUsuarioIF{

	@Override
	public double calculaPreco(double preco) {
		return preco * 0.9;
	}

	@Override
	public int recompensar(Jogo jogo, int score, boolean zerou) {
		int pontos = jogo.registraJogada(score, zerou);
		 
		Set<Jogabilidade> jogabilidades = jogo.getJogabilidades();
 
		if (jogabilidades.contains(Jogabilidade.OFFLINE)){
			pontos += 30;
		}
		if (jogabilidades.contains(Jogabilidade.MULTIPLAYER)){
			pontos += 10;
		}
		return pontos;
	}

	@Override
	public int punir(Jogo jogo, int score, boolean zerou) {
		int pontos = jogo.registraJogada(score, zerou);
		
		Set<Jogabilidade> jogabilidades = jogo.getJogabilidades();
		
		if (jogabilidades.contains(Jogabilidade.ONLINE)){
			pontos -= 10;
		}
		if (jogabilidades.contains(Jogabilidade.COMPETITIVO)){
			pontos -= 20;
		}
		if (jogabilidades.contains(Jogabilidade.COOPERATIVO)){
			pontos -= 50;
		}
		return pontos ;
	}

	@Override
	public int calculaX2p(double preco) {
		return (int) preco * 10;
	}
	
}