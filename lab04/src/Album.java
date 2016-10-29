/* 115211593 - Joao Mauricio Alves Valverde Carvalho: LAB 4 - Turma 1 */

package sp2fy;

import java.util.ArrayList;

public class Album {
	
	private ArrayList< Musica > musicas = new ArrayList< Musica >();
	private String nomeAlbum, nomeArtista;
	private int ano;
	
	public Album (String nomeArtista, String nomeAlbum, int ano) throws Exception{
		if (nomeArtista == null || nomeArtista.trim().isEmpty()){
			throw new Exception ("Artista do album nao pode ser nulo ou vazio.");
		}
		if (ano <= 1900){
			throw new Exception ("Ano de lancamento do album nao pode ser inferior a 1900.");
		}
		if (nomeAlbum == null || nomeAlbum.trim().isEmpty()){
			throw new Exception ("Titulo do album nao pode ser nulo ou vazio.");
		}
		this.nomeArtista = nomeArtista;
		this.nomeAlbum = nomeAlbum;
		this.ano = ano;
	}
	
	public boolean adicionaMusica(Musica novaMusica)  {
		if (novaMusica == null){
			return false;
		}
		return musicas.add(novaMusica);
	}

	public boolean removeFaixa(String nomeDaMusica){
		for (Musica objeto : musicas){
			if (objeto.getTitulo().equals(nomeDaMusica)){
				return musicas.remove(objeto);
			}
		}
		return false;
	}
	
	public boolean removeMusica(int faixaDaMusica){
		return musicas.remove(musicas.get(faixaDaMusica - 1));
	}
	
	public int getDuracaoTotal() {
		int duracao = 0;
		for (Musica objeto : musicas ){
			duracao += objeto.getDuracao();
		}
		return duracao;
	}

	public String getArtista() {
		return nomeArtista;
	}

	public String getTitulo() {
		return nomeAlbum;
	}
	
	public int getAno(){
		return ano;
	}
	
	public Musica getMusica(int i){
		return musicas.get(i-1);
	}
	
	public Musica getMusica(String nomeDaMusica){
		for (Musica objeto: musicas){
			if (objeto.getTitulo().equals(nomeDaMusica)){
				return objeto;
			}
		}
		return null;
	}
	
	public boolean contemMusica (String nomeDaMusica){
		for (Musica objeto : musicas){
			if (objeto.getTitulo().equals(nomeDaMusica)){
				return true;
			}
		}
		return false;
	}		
	
	public int quantidadeFaixas(){
		return musicas.size();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((musicas == null) ? 0 : musicas.hashCode());
		result = prime * result + ((nomeAlbum == null) ? 0 : nomeAlbum.hashCode());
		result = prime * result + ((nomeArtista == null) ? 0 : nomeArtista.hashCode());
		return result;
	}

	public boolean equals(Object album){
		if (album instanceof Album){
			Album novoAlbum = (Album)album;
			return nomeAlbum.equals(novoAlbum.getTitulo()) && nomeArtista.equals(novoAlbum.getArtista());
		}
		return false;
	}
	
	public String toString(){
		String resultado = nomeAlbum + ", " + nomeArtista + " - Ano: " + ano + "\n\n";
		for (Musica msc: musicas){
			resultado += "   " + msc;
		}
		return resultado;
	}
}
