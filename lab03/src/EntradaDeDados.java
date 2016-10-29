/* 115211593 - Joao Maurício Alves Valverde Carvalho: LAB03 - Turma 01 */
package lab03;
import java.util.Scanner;

public class EntradaDeDados {
	private Scanner scanner = new Scanner (System.in);
	
	public int lerInteiro (String msg){
		System.out.print(msg);
		int inteiro = scanner.nextInt();
		scanner.nextLine();
		return inteiro;
	}
	
	public double lerDouble (String msg){
		System.out.print(msg);
		double num = scanner.nextDouble();
		scanner.nextLine();
		return num;
	}
	
	public String lerString (String msg){
		System.out.print(msg);
		String str = scanner.nextLine();
		return str;
	}
}
