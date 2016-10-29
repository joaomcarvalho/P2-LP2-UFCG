// 115211593 - Joao Mauricio Carvalho: LAB 06 - Turma 1
import java.util.HashSet;

import exceptions.EntradaInvalida;

/**
 * @see Jogo
 */
public class JogoDePlataforma extends Jogo{
	
	/**
	 * @see Jogo
	 */
	public JogoDePlataforma(String nome, double preco) throws EntradaInvalida {
		super(nome, preco);
	}
	
	/**
	 * @see Jogo
	 */
	public JogoDePlataforma(String nome, double preco, HashSet<EstiloDeJogo> estiloDeJogo) throws Exception{
		super(nome,preco,estiloDeJogo);
	}
	
	/**
	 * Metodo que registra a jogada do Jogo de plataforma.
	 * @return retorna x2p extra conquistado pelo usuario sempre que ele 
	 * zera o jogo.
	 * @see Jogo#joga(int, boolean)
	 */
	@Override
	public int joga(int score, boolean zerou) {
		addVezJogada();
		if (score > getMaiorScore()){
			setMaiorScore(score);
		}
		if (zerou){
			addVezZerada();
			return 20;
		}
		return 0;
	}
	
	public String toString(){
		return "+ " + this.getNome() + " - Plataforma:\n" + "==> Jogou " + this.getVezesJogadas() + " vez(es)\n" + "==> Zerou " + this.getVezesZeradas() + " vez(es)\n" + "==> Maior score: " + this.getMaiorScore() + "\n";
	}
}
