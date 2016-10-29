package loja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import easyaccept.EasyAccept;
import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.UpgradeInvalidoException;
import excecoes.ValorInvalidoException;
import jogo.FactoryDeJogo;
import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.Rpg;
import usuario.FactoryDeUsuario;
import usuario.Noob;
import usuario.TipoDeUsuarioIF;
import usuario.Usuario;
import usuario.Veterano;

public class LojaController {
	public static final String FIM_DE_LINHA = System.lineSeparator();
	private List<Usuario> meusUsuarios;
	private HashMap<String, Jogabilidade> mapJogabildades;
	private FactoryDeUsuario factoryUsuario;
	private FactoryDeJogo factoryJogo;

	public LojaController() {
		this.meusUsuarios = new ArrayList<Usuario>();
		this.initializeMap();
		this.factoryUsuario = new FactoryDeUsuario();
		this.factoryJogo = new FactoryDeJogo();
	}

	/**
	 * Cria um usuario
	 * @param nome
	 * 			Nome do usuario
	 * @param login
	 * 			Login do usuario
	 * @param tipo
	 * 			Tipo do usuario
	 * @throws StringInvalidaException
	 * 			Caso nome ou login estejam vazios
	 */
	public void criaUsuario(String nome, String login, String tipo) throws StringInvalidaException {
			this.meusUsuarios.add(factoryUsuario.criaUsuario(nome, login));
	}

	/**
	 * Cria um jogo 
	 * @param nome
	 * @param preco
	 * @param jogabilidades
	 * @param tipo
	 * @return
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Jogo criaJogo(String nome, double preco, String jogabilidades, String tipo) 
			throws StringInvalidaException, PrecoInvalidoException{
		Set<Jogabilidade> tiposJogabilidades = this.createJogabilidades(jogabilidades);
		return factoryJogo.criaJogo(nome, preco,tiposJogabilidades, tipo);
	}
	
	/**
	 * cria um jogo
	 * @param nome
	 * @param preco
	 * @param jogabilidades
	 * @param tipo
	 * @return
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Jogo criaJogo(String nome, double preco, Set<Jogabilidade> jogabilidades, String tipo) 
			throws StringInvalidaException, PrecoInvalidoException{
		return factoryJogo.criaJogo(nome, preco,jogabilidades, tipo);
	}
	
	/**
	 * cria um jogo
	 * @param nome
	 * @param preco
	 * @param tipo
	 * @return
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Jogo criaJogo (String nome, double preco, String tipo) 
			throws StringInvalidaException, PrecoInvalidoException{
		return factoryJogo.criaJogo(nome, preco, tipo);
	}
	
	/**
	 * Vende um jogo para um usuario
	 * @param jogoNome
	 * 			Nome do jogo vendido
	 * @param preco
	 * 			Preco do jogo
	 * @param jogabilidades
	 * 			Tipos de jogabilidades
	 * @param estiloJogo
	 * 			Tipo do jogo (rpg, luta, plataforma)
	 * @param loginUser
	 * 			Login do usuario
	 * @throws Exception
	 */
	public void vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser) throws Exception {
			Usuario buscado = this.buscaUsuario(loginUser);
			Set<Jogabilidade> tiposJogabilidades = this.createJogabilidades(jogabilidades);
			Jogo jogoVendido = this.criaJogo(jogoNome, preco, tiposJogabilidades, estiloJogo);
			buscado.compraJogo(jogoVendido);
	}

	/**
	 * recompensa um determinado usuario
	 * @see TipoDeUsuarioIF
	 */
	public void recompensar(String login, String nomeJogo, int score, boolean venceu) {
		try {
			Usuario usr = this.buscaUsuario(login);
			usr.recompensar(nomeJogo, score, venceu);
		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	/**
	 * pune um determinado usuario
	 * @see TipoDeUsuarioIF
	 */
	public void punir(String login, String nomeJogo, int score, boolean zerou) {
		try {
			buscaUsuario(login).punir(nomeJogo, score, zerou);
		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	/**
	 * Da uprgrade em um determinado usuario
	 * @param login
	 * 			Login do usuario
	 */
	public void upgrade(String login){
		Usuario usr = buscaUsuario(login);
		usr.upgrade();
	}

	/**
	 * adiciona credito a um determinado usuario
	 * @param login
	 * 			Login do usuario
	 * @param credito
	 * 			Quantidade de creditos
	 */
	public void adicionaCredito(String login, double credito) {
		try {
			if (credito < 0) {
				throw new ValorInvalidoException("Credito nao pode ser negativo");
			}
			Usuario user = this.buscaUsuario(login);
			user.setCredito(user.getCredito() + credito);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Busca um determinado usuario
	 * @param login
	 * 			Login do usuario
	 * @return
	 * 			retorna o objeto usuario, caso encontrado.
	 */
	public Usuario buscaUsuario(String login) {
		Usuario buscado = null;

		try {
			for (int i = 0; i < meusUsuarios.size(); i++) {
				if (meusUsuarios.get(i).getLogin().equals(login)) {
					buscado = meusUsuarios.get(i);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return buscado;
	}

	public double confereCredito(String login) {
		try {
			Usuario procurado = this.buscaUsuario(login);
			return procurado.getCredito();
		} catch (Exception e) {
			e.getMessage();
		}
		return 0;
	}

	public String toString () {
		String myString = "=== Central P2-CG ===" + FIM_DE_LINHA + FIM_DE_LINHA;
		for (int i = 0; i < meusUsuarios.size(); i++) {
			myString += meusUsuarios.get(i).toString() + FIM_DE_LINHA;
		}
		return myString;
	}

	public int getX2p(String login) {
		Usuario buscado = this.buscaUsuario(login);
		return buscado.getXp2();
	}

	public Set<Jogabilidade> createJogabilidades(String names1) {
		Set<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();

		String[] listofNames = names1.split(" ");
		
		
		for (int i = 0; i < listofNames.length; i++) {
			String element = listofNames[i].toUpperCase();
			if (element != null) {
				Jogabilidade tipojogabilidade = mapJogabildades.get(element);
				jogabilidades.add(tipojogabilidade);
			}
		}

		return jogabilidades;

	}

	private void initializeMap() {
		this.mapJogabildades = new HashMap<String, Jogabilidade>();
		mapJogabildades.put("ONLINE", Jogabilidade.ONLINE);
		mapJogabildades.put("OFFLINE", Jogabilidade.OFFLINE);
		mapJogabildades.put("COMPETITIVO", Jogabilidade.COMPETITIVO);
		mapJogabildades.put("COOPERATIVO", Jogabilidade.COOPERATIVO);
		mapJogabildades.put("MULTIPLAYER", Jogabilidade.MULTIPLAYER);

	}
}
