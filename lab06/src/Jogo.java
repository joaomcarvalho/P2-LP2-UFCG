// 115211593 - Joao Mauricio Carvalho: LAB 06 - Turma 1
import java.util.HashSet;

import exceptions.EntradaInvalida;

/**
 * Classe responsavel pelos Jogos.
 * @author Joao Mauricio Carvalho
 */

public abstract class Jogo {	
	private String nome;
	private double preco;
	private HashSet<EstiloDeJogo> estiloDeJogo;
	private int maiorScore, vezesJogadas,vezesZerada;
	
	/**
	 * Construtor de Jogo
	 * @param nome
	 * 			O nome do jogo.
	 * @param preco
	 * 			O preco do jogo.
	 * @throws EntradaInvalida
	 * 			Caso nome esteja vazio ou preco negativo	 
	 */
	
	public Jogo (String nome, double preco)throws EntradaInvalida{
		if (nome.trim().isEmpty() || nome == null){
			throw new EntradaInvalida ("Nome não pode ser vazio.");
		}
		if (preco < 0){
			throw new EntradaInvalida ("Valor não pode ser negativo.");
		}
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.vezesJogadas = 0;
		this.vezesZerada = 0;
	}
	
	/**
	 * Construtor de Jogo caso tenha estilos definido.
	 * @param nome
	 * 			O nome do jogo.
	 * @param preco
	 * 			O preco do jogo.
	 * @throws EntradaInvalida
	 * 			Caso nome esteja vazio ou preco negativo	 
	 */
	
	public Jogo(String nome, double preco, HashSet<EstiloDeJogo> estiloDeJogo) throws Exception{
		this(nome,preco);
		this.estiloDeJogo = new HashSet<EstiloDeJogo>();
		this.estiloDeJogo = estiloDeJogo;
		
	}
	
	/**
	 * Metodo responsavel por registrar uma jogada, a classe que estender Jogo terá seu propio metódo jogo,
	 * pois possuem diferentes calculos de X2p.
	 * @param novoScore
	 * 			Score atingido pelo usuario nessa rodada.
	 * @param zerou
	 * 			Indica se o jogo foi ou nao zerado
	 * @return  X2p que o usuario ganhou ao jogar.
	 */
	public abstract int joga(int novoScore, boolean zerou);
	
	
	// GETTERS E SETTERS
	public String getNome(){
		return nome;
	}
	
	public double getPreco(){
		return preco;
	}

	public void setPreco(double novoPreco){
		this.preco = novoPreco;
	}
	
	public int getMaiorScore(){
		return maiorScore;
	}
	
	public void setMaiorScore(int novoScore){
		maiorScore = novoScore;
	}

	public int getVezesJogadas(){
		return vezesJogadas;
	}
	
	public void addVezJogada(){
		this.vezesJogadas += 1;
	}
	
	public int getVezesZeradas(){
		return vezesZerada;
	}
	
	public void addVezZerada(){
		vezesZerada++;
	}
	
	public HashSet<EstiloDeJogo> getEstiloDeJogo(){
		return estiloDeJogo;
	}
	
	public abstract String toString();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jogo){
			Jogo novoJogo = (Jogo) obj;
			if(novoJogo.getNome().equals(this.getNome()) && novoJogo.getPreco() == this.getPreco()){
				return true;
			}
		} return false;
	}
}
