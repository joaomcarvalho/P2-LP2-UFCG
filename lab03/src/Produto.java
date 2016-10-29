/* 115211593 - Joao Maurício Alves Valverde Carvalho: LAB03 - Turma 01 */
package lab03;

public class Produto {
	private String nome, tipo;
	private double preco;
	private int quantidade;
	
	public Produto(String nome, String tipo, double preco, int quantidade){
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public double getPreco(){
		return preco;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public void addQuantidade(int quantidade){
		this.quantidade += quantidade;
	}
	
	public String toString(){
		return nome + "(" + tipo + "). R$" + preco;
	}
}
