/* 115211593 - Joao Mauricio Alves Valverde Carvalho: LAB 4 - Turma 1 */

package sp2fy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Musiteca {
	private ArrayList<Album> meusAlbuns;
	private HashSet<Album> albunsFavoritos;
	private HashMap<String, ArrayList<Musica>> playlist;
	
	public Musiteca(){
		meusAlbuns = new ArrayList<Album>();
		albunsFavoritos = new HashSet<Album>();
		playlist = new HashMap<String, ArrayList<Musica>>();
	}
	
	// Metodos da colecao de albuns
	
	public boolean addAlbum(Album album) throws Exception{
		if (album == null || album.getTitulo().trim().isEmpty()){
			throw new Exception("Album nao pode ser vazio");
		}
		if (! contemAlbum(album)){
			return meusAlbuns.add(album);
		}
		return false;
	}

	public boolean contemAlbum(Album album){
		return meusAlbuns.contains(album);
	}
	
	public ArrayList<Album> getAlbunsArtista(String nome){
		ArrayList<Album> albunsArtista = new ArrayList<Album>();
		for (Album album: meusAlbuns){
			if (album.getArtista().equals(nome)){
				albunsArtista.add(album);
			}
		}
		return albunsArtista;
	}
	
	public Album getAlbum(String nome){
		for (Album album : meusAlbuns){
			if (album.getTitulo().equals(nome)){
				return album;
			}
		}
		return null;
	}
	
	// Metodos da colecao de favortios
	
	public boolean addAosFavoritos(Album album){
		if (meusAlbuns.contains(album) && !albunsFavoritos.contains(album)){
			return albunsFavoritos.add(album);
		}
		return false;
	}
	
	public boolean removeDosFavoritos(Album album){
		if (albunsFavoritos.contains(album)){
			return albunsFavoritos.remove(album);
		}
		return false;
	}
	
	public int getQtdFavoritos(){
		return albunsFavoritos.size();
	}
	
	// Metodos da colecao de playlist
	
	public boolean criaPlaylist(String nome)throws Exception{
		if (nome == null || nome.trim().isEmpty() || playlist.containsKey(nome) ){
			throw new Exception ("Playlist com nome invalido ou repetido");
		}else{
			ArrayList<Musica> novoArray = new ArrayList<Musica>();
			playlist.put(nome, novoArray);
			return true;
		}
	}
	
	public boolean addNaPlaylist(String playlist, String nomeAlbum, int faixa) throws Exception{
		if (! this.playlist.containsKey(playlist) ){
			criaPlaylist(playlist);
		}
		
		Album album = getAlbum(nomeAlbum);
		if (album == null){
			throw new Exception ("Album não pertecene a musiteca");
		}
		
		Musica novaMusica = album.getMusica(faixa);
		ArrayList<Musica> novoArray = new ArrayList<Musica>();
		novoArray = this.playlist.get(playlist);
		novoArray.add(novaMusica);
		this.playlist.put(playlist, novoArray);
		return true;
	}

	public int getTamPlaylist(String playlist) {
		return this.playlist.get(playlist).size();
	}

	public boolean contemNaPaylist(String playlist, String nomeMusica) {
		ArrayList<Musica> novoArray = new ArrayList<Musica>();
		novoArray = this.playlist.get(playlist);
		for (Musica musica : novoArray){
			if (musica.getTitulo().equals(nomeMusica)){
				return true;
			}
		}
		return false;
	}

	public boolean contemPlaylist(String nome) {
		return playlist.containsKey(nome);
	}
}
