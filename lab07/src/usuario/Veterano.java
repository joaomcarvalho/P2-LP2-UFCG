package usuario;


import java.util.Iterator;
import java.util.Set;

import excecoes.StringInvalidaException;
import excecoes.ValorInvalidoException;
import jogo.Jogabilidade;
import jogo.Jogo;

public class Veterano implements TipoDeUsuarioIF {

	@Override
	public double calculaPreco(double preco) {
		return preco * 0.8;
	}

	@Override
	public int recompensar(Jogo jogo, int score, boolean zerou) {
		int pontos = jogo.registraJogada(score, zerou);
		 
		Set<Jogabilidade> jogabilidades = jogo.getJogabilidades();
 
		if (jogabilidades.contains(Jogabilidade.ONLINE)){
			pontos += 10;
		}
		if (jogabilidades.contains(Jogabilidade.COOPERATIVO)){
			pontos += 20;
		}
		return pontos;
	}

	@Override
	public int punir(Jogo jogo, int score, boolean zerou) {
		int pontos = jogo.registraJogada(score, zerou);
		
		Set<Jogabilidade> jogabilidades = jogo.getJogabilidades();
		
		if (jogabilidades.contains(Jogabilidade.COMPETITIVO)){
			pontos -= 20;
		}
		if (jogabilidades.contains(Jogabilidade.OFFLINE)){
			pontos -= 20;
		}
		return pontos;
	}

	@Override
	public int calculaX2p(double preco) {
		return (int) (preco * 15);
	}
	
	
}
