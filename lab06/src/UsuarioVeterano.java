import exceptions.EntradaInvalida;
import exceptions.ValorException;

// 115211593 - Joao Mauricio Carvalho: LAB 06 - Turma 1

/**
 * Classe representativa de um Usuario veterano.
 * @see Usuario
 * @author Joao Mauricio Carvalho
 *
 */
public class UsuarioVeterano extends Usuario {

	/**
	 * @see Usuario
	 */
	public UsuarioVeterano(String nome, String login) throws EntradaInvalida {
		super(nome, login);
		addX2p(1000);
	}

	/**
	 * Adiciona um jogo com 20% de desconto.
	 * @see Usuario#addJogo(Jogo)
	 */
	@Override
	public boolean addJogo(Jogo jogo) throws ValorException {
		if (jogo.getPreco() * 0.8  <= getCarteira()){
			removerDinheiro(jogo.getPreco() * 0.8);
			jogosComprados.put(jogo.getNome(), jogo);
			addX2p((int)jogo.getPreco() * 15);
			return true;
		}
		throw new ValorException ("Fundos Insuficientes.");
	}
	
	public String toString(){
		String msg = this.getLogin() + "\n" + this.getNome() + " - Jogador Veterano" + "\n" + "Lista de Jogos:\n";
		
		for (Jogo jogo : jogosComprados.values()){
			msg += jogo.toString();
		}
		return msg;
	}

}
