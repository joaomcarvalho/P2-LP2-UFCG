/* 115211593 - Joao Mauricio Alves Valverde Carvalho: LAB 4 - Turma 1 */

package sp2fy;

import java.util.ArrayList;

public class Perfil {
	private String nome;
	private Musiteca musiteca;
	
	public Perfil(String nome){
		this.nome = nome;
		musiteca = new Musiteca();
	}
	
	public String getNome(){
		return nome;
	}
	
	// Album
	
	public boolean adicionaAlbum(Album album){
		try {
			return musiteca.addAlbum(album);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			return false;
		}
	}
	
	public boolean adicionaAlbum(String titulo, String artista, int ano){
		try {
			Album album = new Album(titulo, artista, ano);
			return musiteca.addAlbum(album);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			return false;
		}
	}
	
	public boolean contemAlbum(Album album){
		return musiteca.contemAlbum(album);
	}
	
	public ArrayList<Album> getAlbunsArtista(String nome){
		return musiteca.getAlbunsArtista(nome);
	}
	
	public Album pesquisaAlbum(String nome) {
		return musiteca.getAlbum(nome);
	}
	
	// Playlist
	
	public boolean criaPlaylist(String nome){
		try {
			return musiteca.criaPlaylist(nome);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			return false;
		}
	}
	
	public boolean addNaPlaylist(String playlist, String nomeAlbum, int faixa){
		try {
			return musiteca.addNaPlaylist(playlist, nomeAlbum, faixa);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			return false;
		}
	}
	
	public boolean adicionaPlaylist(String playlist, String nomeAlbum, int faixa) {
		try {
			return musiteca.addNaPlaylist(playlist, nomeAlbum, faixa);
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
}

	public int getTamPlaylist(String playlist) {
		return musiteca.getTamPlaylist(playlist);
	}

	public boolean contemNaPlaylist(String playlist, String nomeMusica) {
		return musiteca.contemNaPaylist(playlist, nomeMusica);
	}
	
	// Favoritos
	
	public boolean addAosFavoritos(Album album){
		return musiteca.addAosFavoritos(album);
	}
	
	public int getQtdFavoritos() {
		return musiteca.getQtdFavoritos();
	}

	public boolean removeDosFavoritos(Album album) {
		return musiteca.removeDosFavoritos(album);
	}	
}

