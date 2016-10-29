/* 115211593 - Joao Mauricio Alves Valverde Carvalho: LAB 4 - Turma 1 */

package sp2fy;

public class Musica {
	String titulo, genero;
	int duracao;

	public Musica (String titulo, int duracao, String genero) throws Exception{
		if (titulo == null || titulo.trim().isEmpty()){
			throw new Exception ("Titulo da musica nao pode ser nulo ou vazio.");
		}
		if (duracao <= 0){
			throw new Exception ("Duracao da musica nao pode ser negativa.");
		}
		if (genero == null || genero.trim().isEmpty() ){
			throw new Exception ("Genero da musica nao pode ser nulo ou vazio.");
		}
		
		this.titulo = titulo;
		this.genero = genero;
		this.duracao = duracao;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public String getGenero(){
		return genero;
	}
	
	public int getDuracao(){
		return duracao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	public boolean equals(Object musica){
		if (musica instanceof Musica){
			Musica novaMusica = (Musica)musica;
			return titulo.equals(novaMusica.getTitulo()) && duracao == novaMusica.getDuracao();
			}
		return false;
	}
	
	public String toString(){
		return titulo + "( " + genero + " - " + duracao + " minutos";
	}
}
