// 115211593 - Joao Mauricio Carvalho: LAB 06 - Turma 1
import java.util.HashMap;

import exceptions.EntradaInvalida;
import exceptions.ValorException;

/**
 * Classe responsavel pela loja.
 * @author Joao Mauricio Carvalho
 *
 */
public class Loja {
	private HashMap<String, Usuario> usuarios;
	private double totalArrecadado;
	
	/**
	 * Construtor da loja
	 */
	public Loja (){
		usuarios = new HashMap<String, Usuario>();
		totalArrecadado = 0.0;
	}
	
	/**
	 * Cria um usuario e adiciona na lista da loja.
	 * @param nome
	 * 			Nome do usuario.
	 * @param login
	 * 			Login do usuario.
	 * @param tipo
	 * 			Tipo do usuario.
	 */
	public void criaUsuario(String nome, String login, String tipo){
		try{
		if (tipo.equals("Veterano")){
			Usuario novoUsuario = new UsuarioVeterano(nome, login);
			this.usuarios.put(login, novoUsuario);
		} else {
			Usuario novoUsuario = new UsuarioNoob(nome, login);
			this.usuarios.put(login, novoUsuario);
		}
		} catch(EntradaInvalida e){
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Vende um determinado jogo para um usuario.
	 * @param loginUsuario
	 * 			Login do usuario.
	 * @param jogo
	 * 			Jogo a ser comprado
	 * @return retorna true caso venda seja finalizada com sucesso.
	 */
	public boolean vendeJogo(String loginUsuario, Jogo jogo){
		try {
				usuarios.get(loginUsuario).addJogo(jogo);
				if (usuarios.get(loginUsuario).getClass().getName().equals("UsuarioNoob")){
					totalArrecadado += jogo.getPreco() * 0.9;
				} else {
					totalArrecadado += jogo.getPreco() * 0.8;
				}
				return true;
			}
		catch (ValorException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Adiciona dinheiro na carteira de um usuario.
	 * @param loginUsuario
	 * 			Login do usuario.
	 * @param valor
	 * 			Valor a ser adicionado.
	 */
	public void addDinheiro (String loginUsuario, double valor){
		try {
			usuarios.get(loginUsuario).addDinheiro(valor);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Faz upgrade de um usuario que deixou de ser noob.
	 * @param loginUsuario
	 * 			Login do usuario.
	 * @throws EntradaInvalida 
	 */
	public void upgradeUsuario(String loginUsuario) throws EntradaInvalida {
		Usuario user = usuarios.get(loginUsuario);
		
		if (user.getClass().getName().equals("UsuarioNoob") && user.getX2p() >= 1000){
			Usuario novoUsuario = new UsuarioVeterano(user.getNome(), user.getLogin());
			novoUsuario.addX2p(user.getX2p());
			novoUsuario.addDinheiro(user.getCarteira());
			novoUsuario.addAllJogos(user.getTodosJogos());
		
			usuarios.remove(loginUsuario);
			usuarios.put(loginUsuario, novoUsuario);
		}
	}
	
	// GETTERS E SETTERS
	public int getTotalUsuarios(){
		return usuarios.size();
	}
	
	public Usuario getUsuario(String login){
		return usuarios.get(login);
	}
	
	public double getTotalArrecadado(){
		return totalArrecadado;
	}
	
	public String toString (){
		String msg = "=== Central P2-CG ===\n";
		
		for (Usuario usuarios : usuarios.values()){
			msg += usuarios.toString();
		}
		return msg;
	}
}
