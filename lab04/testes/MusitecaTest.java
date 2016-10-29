package lab04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sp2fy.Album;
import sp2fy.Musica;
import sp2fy.Musiteca;

public class MusitecaTest {

	Musiteca musiteca;

	@Before
	public void setUp() throws Exception {
		musiteca = new Musiteca();
	}

	@Test
	public void testCriaAlbum() {
		try {
		Album lemonade = new Album("Beyounce", "Lemonade", 2015);
		Musica sorry = new Musica("Sorry", 5, "Pop");
		Musica formation = new Musica("Formation", 4, "Pop");
		lemonade.adicionaMusica(sorry);
		lemonade.adicionaMusica(formation);

		// nao pode adicionar albuns repetidos.
		assertTrue(musiteca.addAlbum(lemonade));
		assertFalse(musiteca.addAlbum(lemonade));
		} catch (Exception e){
			fail();
		}
	}

	@Test
	public void testFavoritaAlbum() {

		try{
		Album perfilMarilia = new Album("Marilia Mendonca", "Perfil", 2015);

		// adicionar na musiteca
		assertTrue(musiteca.addAlbum(perfilMarilia));
		assertTrue(musiteca.contemAlbum(perfilMarilia));

		// adicionar aos favoritos.
		assertTrue(musiteca.addAosFavoritos(perfilMarilia));
		assertFalse(musiteca.addAosFavoritos(perfilMarilia));

		assertEquals(1, musiteca.getQtdFavoritos());
		}catch (Exception e){
			fail();
		}
	}

	@Test
	public void testCriaEAddPlaylist() {
		// cria uma playlist vazia, mas nao pode
		// criar mais de uma playlist com
		// o mesmo titulo.
		try{
		assertTrue(musiteca.criaPlaylist("Pop"));
		assertFalse(musiteca.criaPlaylist("Pop"));
		assertTrue(musiteca.contemPlaylist("Pop"));
		} catch(Exception e){
			assertEquals("Playlist com nome invalido ou repetido", e.getMessage());
		}
	}

	@Test
	public void pesquisaMusica() {

		try{
		Musica sentimentoLouco = new Musica("Sentimento Louco", 3, "Sertanejo");
		Album mariliaLive = new Album("Marilia Mendonca", "DVD Ao Vivo", 2015);
		mariliaLive.adicionaMusica(sentimentoLouco);

		assertTrue(musiteca.addAlbum(mariliaLive));

		assertTrue(musiteca.criaPlaylist("Sertanejo"));
		// adiciona na playlist de nome sertanejo:
		// a faixa 1 do album 'DVD Ao Vivo';
		// se houver nomes de albuns iguais, utilize o primeiro q encontrar
		assertTrue(musiteca.addNaPlaylist("Sertanejo", "DVD Ao Vivo", 1));
		
		assertEquals(1, musiteca.getTamPlaylist("Sertanejo"));
		// verifica se a playlist Sertanejo tem uma musica com esse nome.
		assertTrue(musiteca.contemNaPaylist("Sertanejo", "Sentimento Louco"));
		}catch(Exception e){
			fail();
		}
	}

	@Test
	public void testExeptionCases() {
		//adicao e criacao com valores null
		// sao tratados com retorno de booleanos
		// como consta no enunciado do lab.
		try{
		assertFalse(musiteca.addAlbum(null));
		}catch(Exception e){
			assertEquals("Album nao pode ser vazio", e.getMessage());
		}
		try{
		assertFalse(musiteca.criaPlaylist(""));
		} catch (Exception e){
			 
			 assertEquals("Playlist com nome invalido ou repetido", e.getMessage());
		}
	}
}
