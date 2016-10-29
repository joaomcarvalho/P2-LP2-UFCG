/* 115211593 - Joao Maurício Alves Valverde Carvalho: LAB03 - Turma 01 */
package lab03;

public class Estoque {
	private Produto[] produto = new Produto[5];
	private int quantidadeTotal = 0;
	private double lucroTotal = 0; 
	
	public int verificaProduto (String Nome){
		int indice = -1;
		for (int i = 0; i < quantidadeTotal; i++){
			if (produto[i].getNome().equalsIgnoreCase(Nome)){
				indice = i;
			}
		}			
		return indice;
	}
	
	public void novoProduto (String nome, String tipo, double preco, int quantidade){
		if (quantidade < 0) System.out.println("Quantidade inválida, cadastro não efetuado.");
		else {
		produto[quantidadeTotal] = new Produto (nome, tipo, preco, quantidade);
		System.out.println(produto[quantidadeTotal].getQuantidade() + " \"" + produto[quantidadeTotal].getNome() + " (s)" + "\" " + " Cadastrado com sucesso.");
		quantidadeTotal++;
		}
		if (quantidadeTotal == produto.length)
			aumentaArray();
	}
	
	public void addProduto (int quantidade, int indice){
		produto[indice].addQuantidade(quantidade);
	}
	
	
	public void abateProduto (String nome, int quantidade, int indice){
		if (quantidade <= produto[indice].getQuantidade() && quantidade > 0){
			double total = quantidade * produto[indice].getPreco();
			lucroTotal += total;
			produto[indice].addQuantidade((quantidade * -1));
			System.out.printf("==> Total arrecadado: R$ %.2f\n",total);
		}else{
			System.out.println("Não é possivel vender pois não há " + produto[indice].getNome() + " suficiente.");
		}
	}
	
	public double getLucro(){
		return lucroTotal;
	}
	
	public Produto getProduto(int i){
		return produto[i];
	}
	
	public int getQuantidadeProdutos (){
		return quantidadeTotal;
	}
	
	public void aumentaArray(){
		 Produto[] novoArray = new Produto[quantidadeTotal * 2];
		 for (int i = 0; i < produto.length; i++)
			 novoArray[i] = produto[i];
		 produto = novoArray;
	}
	
	public String imprimeBalanco() {
		String saida = "";
		for (int i = 0; i < quantidadeTotal; i++) {
			saida += (i+1) + ")" +  produto[i] + " Restante: " + produto[i].getQuantidade() + "\n";
		}
		return saida;
	}
	
	public double arrecadacaoPossivel (){
		double possivel = 0;
		for (int i = 0; i < quantidadeTotal; i++){
			possivel += produto[i].getPreco() * produto[i].getQuantidade();
		}
		return possivel;
	}
}
