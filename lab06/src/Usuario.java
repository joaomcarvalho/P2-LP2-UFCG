// 115211593 - Joao Mauricio Carvalho: LAB 06 - Turma 1
import java.util.HashMap;

import exceptions.EntradaInvalida;
import exceptions.ValorException;

/**
 * Classe representativa de um usuario.
 * @author Joao Mauricio Carvalho
 */
public abstract class Usuario {
	private String nome, login;
	protected HashMap<String, Jogo> jogosComprados;
	private double carteira;
	protected int x2p;
	
	/**
	 * Constroi um Usuario
	 * @param nome
	 * 			O nome do usuario.
	 * @param login
	 * 			O login do usuario.
	 * @throws EntradaInvalida
	 * 			Caso nome ou login forem vazio.
	 */
	public Usuario(String nome, String login) throws EntradaInvalida{
		if (nome.trim().isEmpty() || nome == null){
			throw new EntradaInvalida("Nome não pode ser vazio.");
		}
		if (login.trim().isEmpty() || login == null){
			throw new EntradaInvalida("Login não pode ser vazio.");
		}
		
		this.nome = nome;
		this.login = login;
		this.carteira = 0.0;
		this.jogosComprados = new HashMap<String, Jogo>();
		this.x2p = 0;
	}
	
	/**
	 * Adiciona um jogo para o usuario, diminui a quantidade de dinheiro e adicionado x2P ao usuario
	 * as classes que herdam Usuario devem fazer o seu propio calculo de preco.
	 * @param jogo
	 * 			Jogo a ser adicionado ao usuario.
	 * @return retorna true se o jogo foi adicionado com sucesso.
	 * 
	 * @throws ValorException
	 * 			Caso o usuario nao tenha dinheiro suficiente.
	 */
	public abstract boolean addJogo(Jogo jogo) throws ValorException;
	
	/**
	 * Registra jogada em um determinado jogo do usuario e caso a jogada entre nos
	 * criterios de recompensa em x2p, recompensa o usuario.
	 * @param nome
	 * 			Nome do jogo.
	 * @param score
	 * 			Score atingido na jogada.
	 * @param zerou
	 * 			Indica se o jogo foi zerado na rodada.
	 */
	public void registraJogada(String nome, int score, boolean zerou){
		addX2p(jogosComprados.get(nome).joga(score, zerou));
	}
	
	/**
	 * Recupera valor total dos jogos do usuario sem os descontos.
	 * @return Valor total dos jogos do usuario.
	 */
	public double getValorTotalJogos(){
		double total = 0.0;
		
		for (Jogo jogo : jogosComprados.values()){
			total += jogo.getPreco();
		}
		return total;
	}
	
	/**
	 * Recupera o conjuto com todos os jogos do usuario.
	 * @return Todos os jogos do usuario.
	 */
	public HashMap<String, Jogo> getTodosJogos(){
		return jogosComprados;
	}
	
	/**
	 * Adiciona todo um conjunto de jogos ao usuario, metodo usado durante o upgrade.
	 * @param jogos
	 */
	public void addAllJogos(HashMap<String, Jogo> jogos){
		jogosComprados = jogos;
	}
	
	// GETTERS E SETTERS
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome)throws EntradaInvalida{
		if (nome.trim().isEmpty() || nome == null){
			throw new EntradaInvalida ("Nome não pode ser vazio");
		}
		this.nome = nome;
	}
	
	public String getLogin(){
		return login;
	}
	
	public double getCarteira(){
		return carteira;
	}
	
	public Jogo getJogo(String nome){
		return jogosComprados.get(nome);
	}
	
	public void addDinheiro(double quantidade)throws EntradaInvalida{
		if (quantidade < 0.0){
			throw new EntradaInvalida ("Quatidade inválida.");
		}
		this.carteira += quantidade;
	}
	
	public void removerDinheiro(double quantidade){
		this.carteira -= quantidade;
	}
	
	public int getX2p(){
		return x2p;
	}
	
	public void addX2p(int x2p){
		this.x2p += x2p;
	}
	
	public abstract String toString();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario){
			Usuario novoUser = (Usuario)obj;
			if (novoUser.getLogin().equals(this.getLogin()) && novoUser.getNome().equals(this.getNome())){
				return true;
			}
		} return false;
	}
	
}
