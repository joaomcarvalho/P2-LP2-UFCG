package jogo;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;

public class FactoryDeJogo {
	
	public Jogo criaJogo(String nome, double preco, String tipo) throws StringInvalidaException, PrecoInvalidoException{
			if (tipo.equals("rpg")){
				return criaJogoRPG(nome,preco);
			}else if (tipo.equals("plataforma")){
				return criaJogoPlataforma(nome, preco);
			}else if(tipo.equals("luta")){
				return criaJogoLuta(nome, preco);
			}
			return null;
	}
	
	public Jogo criaJogo(String nome, double preco, Set<Jogabilidade> jogabilidades, String tipo) throws StringInvalidaException, PrecoInvalidoException{
		if (tipo.equals("rpg")){
			return criaJogoRPG(nome,preco,jogabilidades);
		}else if (tipo.equals("plataforma")){
			return criaJogoPlataforma(nome, preco,jogabilidades);
		}else if(tipo.equals("luta")){
			return criaJogoLuta(nome, preco,jogabilidades);
		}
		return null;
}

	private Jogo criaJogoRPG(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException{
		Jogo novoJogo = new Rpg (nome, preco);
		return novoJogo;
	}

	private Jogo criaJogoRPG(String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException{
		Jogo novoJogo = new Rpg (nome, preco, jogabilidades);
		return novoJogo;
	}
	
	private Jogo criaJogoLuta(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException{
		Jogo novoJogo = new Luta (nome, preco);
		return novoJogo;
	}
	
	private Jogo criaJogoLuta(String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException{
		Jogo novoJogo = new Luta (nome, preco, jogabilidades);
		return novoJogo;
	}
	
	private Jogo criaJogoPlataforma(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException{
		Jogo novoJogo = new Plataforma(nome, preco);
		return novoJogo;
	}
	
	private Jogo criaJogoPlataforma(String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException{
		Jogo novoJogo = new Plataforma (nome, preco, jogabilidades);
		return novoJogo;
	}
}
