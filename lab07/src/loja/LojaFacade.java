package loja;

import java.util.Set;

import easyaccept.EasyAccept;
import jogo.Jogabilidade;
import jogo.Jogo;
import usuario.Usuario;

public class LojaFacade {
	
	private LojaController controller;
	
	public LojaFacade(){
		this.controller = new LojaController();
	}

	public boolean criaUsuario(String nome, String login){
		try{
			controller.criaUsuario(nome, login, "Noob");
			return true;
		} catch (Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Jogo criaJogo(String nome, double preco, Set<Jogabilidade> jogabilidades, String tipo){
		try{
			return controller.criaJogo(nome, preco, jogabilidades, tipo);
		} catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Jogo criaJogo(String nome, double preco, String tipo){
		try{
			return controller.criaJogo(nome, preco, tipo);
		} catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser){
		try{
			controller.vendeJogo(jogoNome, preco, jogabilidades, estiloJogo, loginUser);
			return true;
		} catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean recompensar(String login, String nomeJogo, int score, boolean venceu){
		try{
			controller.recompensar(login, nomeJogo, score, venceu);
			return true;
		} catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean punir(String login, String nomeJogo, int score, boolean zerou){
		try{
			controller.punir(login, nomeJogo, score, zerou);
			return true;
		} catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean upgrade(String login){
		try{
			controller.upgrade(login);
			return true;
		} catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean adicionaCredito(String login, double credito){
		try{
			controller.adicionaCredito(login, credito);
			return true;
		} catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Usuario buscaUsuario(String login){
		return controller.buscaUsuario(login);
	}

	public double confereCredito(String login){
		return controller.confereCredito(login);
	}
	
	public String toString (){
		return controller.toString();
	}
	
	public int getX2p(String login){
		return controller.getX2p(login);
	}

	private Set<Jogabilidade> createJogabilidades(String names1){
		return controller.createJogabilidades(names1);
	}

	public static void main(String[] args) {
		args = new String[] { "loja.LojaController", "acceptance_test/us1.txt", "acceptance_test/us2.txt",  "acceptance_test/us3.txt" };
		EasyAccept.main(args);
	}
}
