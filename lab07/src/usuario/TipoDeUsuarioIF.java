package usuario;

import jogo.Jogo;

public interface TipoDeUsuarioIF {
	/**
	 * Calculo de preco do jogo
	 * @param preco
	 * 			preco do jogo sem desconto
	 * @return
	 * 		Retorna o preco do jogo aplicado o desconto para o tipo de jogador
	 */
	public abstract double calculaPreco(double preco);
	
	/**
	 * Recompensa o usuario com x2p
	 * @param jogo
	 * 			Jogo que foi jogado
	 * @param score
	 * 			Score obtido
	 * @param zerou
	 * 			Indica se o jogo foi zerado
	 * @return
	 * 		Retorna x2p conquistada
	 */
	public abstract int recompensar (Jogo jogo, int score, boolean zerou);
	
	/**
	 * Pune o usuario retirando x2p
	 * @param jogo
	 * 			Jogo que foi jogado
	 * @param score
	 * 			Score obtido
	 * @param zerou
	 * 			Indica se foi zerado
	 * @return
	 * 		Retorna x2p conquista
	 */
	
	public abstract int punir (Jogo jogo, int score, boolean zerou);
	
	/**
	 * Calcula x2p ganho numa determinada compra
	 * @param preco
	 * 		preco do jogo
	 * @return
	 * 		retorna x2p ganho
	 */
	
	public abstract int calculaX2p(double preco);
}
