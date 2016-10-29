package usuario;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import excecoes.StringInvalidaException;
import jogo.Jogo;

public class Usuario {

	public static final String FIM_DE_LINHA = System.lineSeparator();

	private String nome;
	private String login;
	private Set<Jogo> meusJogos;
	private double credito;
	private int xp2;
	private TipoDeUsuarioIF tipoUsuario;

	public Usuario(String nome, String login) throws StringInvalidaException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio.");
		}
		if (login == null || login.trim().isEmpty()) {
			throw new StringInvalidaException("Login nao pode ser nulo ou vazio.");
		}

		this.nome = nome;
		this.login = login;
		meusJogos = new HashSet<Jogo>();
		this.credito = 0;
		this.tipoUsuario = new Noob();
		this.xp2 = 0;
	}

	
	/**
	 * Metodo para registrar a compra de um jogo
	 * @param jogo
	 * 			Jogo comprado
	 * @throws Exception
	 * 			Caso o usuario nao tenha dinheiro suficiente
	 */
	public void compraJogo(Jogo jogo) throws Exception{
		double preco = tipoUsuario.calculaPreco(jogo.getPreco());
		if (preco <= credito){
			this.credito -= preco;
			this.meusJogos.add(jogo);
			this.xp2 += tipoUsuario.calculaX2p(jogo.getPreco());
		}
	}

	public void setXp2(int novoValor) {
		this.xp2 = novoValor;
	}

	public int getXp2() {
		return this.xp2;
	}

	/**
	 * Adiciona um jogo a lista de jogos do usario
	 * @param jogo
	 * 			Jogo a ser adicionado.
	 */
	public void cadastraJogo(Jogo jogo) {
		this.meusJogos.add(jogo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setCredito(double novoValor) {
		this.credito = novoValor;
	}

	public double getCredito() {
		return this.credito;
	}
	
	/**
	 * Faz upgrade de um usuario
	 */
	public void upgrade(){
		if (this.xp2 >= 1000){
			this.tipoUsuario = new Veterano();
		}
	}

	/**
	 * @ Recompensa um jogador com x2p
	 * @param nomeJogo
	 * 			Nome do jogo jogado
	 * @param score
	 * 			Score obtido
	 * @param zerou
	 * 			Indica se o usuario zerou
	 */
	public void recompensar(String nomeJogo, int score, boolean zerou){
		Jogo jogo = buscaJogo(nomeJogo);
		this.xp2 += tipoUsuario.recompensar(jogo, score, zerou);
	}
	
	/**
	 * Pune um jogador com x2p
	 * @param nomeJogo
	 * 			Nome do jogo jogado
	 * @param score
	 * 			Score obtido
	 * @param zerou
	 * 			Indica se o jogo foi zerado
	 */
	public void punir(String nomeJogo, int score, boolean zerou){
		Jogo jogo = buscaJogo(nomeJogo);
		this.xp2 += tipoUsuario.punir(jogo, score, zerou);
	}
	
	/**
	 * Busca um jogo na lista de jogos
	 * @param nomeJogo
	 * 			Nome do jogo a ser buscado
	 * @return
	 * 			Retorna jogo, caso encontrado.
	 */
	public Jogo buscaJogo(String nomeJogo) {
		Jogo buscado = null;
		Iterator itr = meusJogos.iterator();
		while (itr.hasNext()) {
			Jogo achado = (Jogo) itr.next();
			if (achado.getNome().equals(nomeJogo)) {
				buscado = achado;
			}
		}
		return buscado;
	}

	public Set<Jogo> getMeusJogos() {
		return meusJogos;
	}

	public void setMeusJogos(Set<Jogo> meusJogos) {
		this.meusJogos = meusJogos;
	}

	/**
	 * calcula o preco total de todos os jogos do usuario
	 * @return
	 * 		retorna o valor da soma de todos os precos
	 */
	public double calculaPrecoTotal() {
		double total = 0;
		Iterator itr = meusJogos.iterator();
		while (itr.hasNext()) {
			Jogo achado = (Jogo) itr.next();
			total += achado.getPreco();
		}
		return total;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario temp = (Usuario) obj;
			return this.getNome().equals(temp.getNome()) && this.getLogin().equals(temp.getLogin());
		} else {
			return false;
		}
	}
}
