// 115211593 - Joao Mauricio Carvalho: LAB 06 - Turma 1
import java.util.HashSet;

import exceptions.EntradaInvalida;

/**
 * @see Jogo
 */

public class JogoDeLuta extends Jogo {
	
	/**
	 * @see Jogo
	 */
	public JogoDeLuta(String nome, double preco) throws EntradaInvalida {
		super(nome, preco);
	}
	
	/**
	 * @see Jogo	
	 */
	public JogoDeLuta(String nome, double preco, HashSet<EstiloDeJogo> estiloDeJogo) throws Exception{
		super(nome,preco,estiloDeJogo);
	}

	/**
	 * Metodo que registra a jogada do Jogo de luta.
	 * @return retorna x2p extra conquistado pelo usuario sempre que ele 
	 * atinge um score maior que o seu recorde atual.
	 * @see Jogo#joga(int, boolean)
	 */
	@Override
	public int joga(int score, boolean zerou) {
		addVezJogada();
		if (zerou){
			addVezZerada();
		}if (score > getMaiorScore()){
			setMaiorScore(score);
			return (score / 1000);
		}
		return 0;
	}
	
	public String toString(){
		return "+ " + this.getNome() + " - Luta:\n" + "==> Jogou " + this.getVezesJogadas() + " vez(es)\n" + "==> Zerou " + this.getVezesZeradas() + " vez(es)\n" + "==> Maior score: " + this.getMaiorScore();
	}
}
