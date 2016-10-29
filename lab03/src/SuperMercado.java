/* 115211593 - Joao Maurício Alves Valverde Carvalho: LAB03 - Turma 01 */
package lab03;

public class SuperMercado {
	private static final String MENU = "Digite a opção desejada:\n1 - Cadastrar um Produto\n2 - Vender um Produto\n3 - Imprimir Balanço\n4 - Sair\n";
	private static final int CADASTRAR = 1, VENDER = 2, BALANCO = 3, SAIR = 4;
	EntradaDeDados entrada = new EntradaDeDados();
	Estoque estoque = new Estoque();
	
	public void cadastroProduto() {
		System.out.println("==== Cadastro de Produtos ====");
		String continua = "sim";
		
		do { 
			String nomeProduto = entrada.lerString("Digite o nome do produto: ");
			int verifica = estoque.verificaProduto(nomeProduto);
			
			if (verifica == -1){
			double precoProduto = entrada.lerDouble("Digite o valor unitario do produto: ");
			String tipoProduto = entrada.lerString("Digite o tipo do produto: ");
			int qtdProduto = entrada.lerInteiro("Digite a quantidade do produto:  ");
				
			estoque.novoProduto(nomeProduto, tipoProduto, precoProduto, qtdProduto);
			}else {
				System.out.println(nomeProduto + " Já cadastrado.");
				int qtdProduto = entrada.lerInteiro ("Digite quanitade de " + nomeProduto + "que devem ser adicionadas ao estoque: ");
				if (qtdProduto > 0) estoque.addProduto(qtdProduto, verifica);
				else System.out.println("Quantidade inválida.");
			}
			continua = entrada.lerString("Deseja cadastrar um novo produto? ");
		}while (continua.equalsIgnoreCase("sim"));
	}
	
	public void vendaProduto(){
		System.out.println("==== Venda de Produtos ====");
		String continua = "sim";
		
		do {
			String nomeProduto = entrada.lerString("Digite o nome do prdouto: ");
			int encontrado = estoque.verificaProduto (nomeProduto);
			
			if (encontrado != -1){
				System.out.println(estoque.getProduto(encontrado));
				int quantidade = entrada.lerInteiro("\nDigite a quantidade que deseja vender: ");
				estoque.abateProduto(nomeProduto, quantidade, encontrado);
			} else
				System.out.println("==> " + nomeProduto + " Não encontrado no sistema.");
				
			continua = entrada.lerString("Deseja vender outro produto? ");
		}while (continua.equalsIgnoreCase("sim"));
	}
	
	public void imprimaBalanco (){
		System.out.println("=== Impressão de Balanço ===");
		System.out.println("Produtos Cadastrados:");
		System.out.println(estoque.imprimeBalanco());
		
		System.out.printf("Total arrecadado em vendas: R$ %.2f\n",estoque.getLucro());
		System.out.printf("Total que pode ser arrecadado: R$: %.2f\n",estoque.arrecadacaoPossivel());
		String continua = "nao";
		while (continua == "nao") continua = entrada.lerString("Deseja voltar ao menu incial? ");
	}
	
	public void menuOperacoes(){
		int opcao = 0;
		do{
			System.out.println("==== Bem-vindo(a) ao EconomizaP2 ====");
			System.out.println(MENU);
			
			opcao = entrada.lerInteiro("Opção: ");
			
			switch (opcao){
				case CADASTRAR:
					cadastroProduto();
					break;
				
				case VENDER:
					vendaProduto();
					break;
				
				case BALANCO:
					imprimaBalanco();
					break;
				
				case SAIR:
					System.out.println("----- Finalizando ------");
					break;
				
				default:
					System.out.println("Opcao Invalida");
			}
			}while(opcao != SAIR);
	}
}
