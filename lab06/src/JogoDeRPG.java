// 115211593 - Joao Mauricio Carvalho: LAB 06 - Turma 1
import java.util.HashSet;

import exceptions.EntradaInvalida;

/**
 * @see Jogo
 */
public class JogoDeRPG extends Jogo{

	/**
	 * @see Jogo
	 */
	public JogoDeRPG(String nome, double preco) throws EntradaInvalida {
		super(nome, preco);
	}
	
	/**
	 * @see Jogo
	 */
	public JogoDeRPG(String nome, double preco, HashSet<EstiloDeJogo> estiloDeJogo) throws Exception{
		super(nome,preco,estiloDeJogo);
	}

	/**
	 * Metodo que registra a jogada do Jogo de RPG.
	 * @return retorna x2p extra conquistado pelo usuario sempre que ele 
	 * joga.
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
		}
		return 10;
	}
	
	public String toString(){
		return "+ " + this.getNome() + " - RPG:\n" + "==> Jogou " + this.getVezesJogadas() + " vez(es)\n" + "==> Zerou " + this.getVezesZeradas() + " vez(es)\n" + "==> Maior score: " + this.getMaiorScore() + "\n";
	}

}
