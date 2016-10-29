import exceptions.EntradaInvalida;
import exceptions.ValorException;

// 115211593 - Joao Mauricio Carvalho: LAB 06 - Turma 1
/**
 * Classe representativa de um Usuario noob.
 * @see Usuario
 * @author Joao Mauricio Carvalho
 *
 */
public class UsuarioNoob extends Usuario{
	
	/**
	 * @see Usuario
	 */
	public UsuarioNoob(String nome, String login) throws EntradaInvalida {
		super(nome, login);
		
	}

	/**
	 * Adiciona um jogo com 10% de desconto
	 * @see Usuario#addJogo(Jogo)
	 */
	@Override
	public boolean addJogo(Jogo jogo) throws ValorException{
		if (jogo.getPreco() * 0.9 <= this.getCarteira()){
			removerDinheiro(jogo.getPreco() * 0.9);
			jogosComprados.put(jogo.getNome(), jogo);
			addX2p((int)jogo.getPreco() * 10);
			return true;
		}
		throw new ValorException ("Fundos Insuficientes.");
	}

	public String toString(){
		String msg = this.getLogin() + "\n" + this.getNome() + " - Jogador Noob" + "\n" + "Lista de Jogos:\n";
		
		for (Jogo jogo : jogosComprados.values()){
			msg += jogo.toString();
		}
		msg += "\nTotal de preço dos jogos: R$ " + this.getValorTotalJogos(); 
		return msg;
	}
}
