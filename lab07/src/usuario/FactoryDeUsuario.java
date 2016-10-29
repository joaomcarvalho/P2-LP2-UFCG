package usuario;

import excecoes.StringInvalidaException;

public class FactoryDeUsuario {
	
	public Usuario criaUsuario(String nome, String login)throws StringInvalidaException{
		Usuario newUser = new Usuario(nome, login);
		return newUser;
	}
}
