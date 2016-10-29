package lab04;

import org.junit.Assert;
import org.junit.Test;

import sp2fy.Album;
import sp2fy.Musica;
import sp2fy.Perfil;

public class PerfilTeste {

	@Test
	public void testPerfilPlayList() throws Exception {

		Musica musica1 = new Musica("Insight", 3, "Pos-punk");
		Musica musica2 = new Musica("Shadowplay", 3, "Pos-punk");
		Musica musica3 = new Musica("Disorder", 4, "Pos-punk");

		Album album1 = new Album("Joy Division", "Unknown Pleasures", 1979);
		album1.adicionaMusica(musica1);
		album1.adicionaMusica(musica2);
		album1.adicionaMusica(musica3);

		Musica musica4 = new Musica("Smells Like Teen Spirit", 3, "Grunge");
		Musica musica5 = new Musica("Come As You Are", 3, "Grunge");
		Musica musica6 = new Musica("Stay Away", 4, "Grunge");

		Album album2 = new Album("Nirvana", "Nevermind", 1991);
		album2.adicionaMusica(musica4);
		album2.adicionaMusica(musica5);
		album2.adicionaMusica(musica6);

		Musica musica7 = new Musica("Right Next Door to Hell", 3, "Hard Rock");
		Musica musica8 = new Musica("Perfect Crime", 2, "Hard Rock");
		Musica musica9 = new Musica("Don't Cry", 4, "Hard Rock");

		Album album3 = new Album("Guns N'Roses", "Use Your Illusion I", 1991);
		album3.adicionaMusica(musica7);
		album3.adicionaMusica(musica8);
		album3.adicionaMusica(musica9);

		Perfil perfil1 = new Perfil("Raquel");

		perfil1.adicionaAlbum(album1);
		perfil1.adicionaAlbum(album2);
		perfil1.adicionaAlbum(album3);

		Assert.assertTrue(perfil1.contemAlbum(album1));
		Assert.assertTrue(perfil1.contemAlbum(album2));
		Assert.assertTrue(perfil1.contemAlbum(album3));

		perfil1.addAosFavoritos(album3);
		Assert.assertEquals(perfil1.getQtdFavoritos(), 1);

		perfil1.removeDosFavoritos(album3);
		Assert.assertEquals(perfil1.getQtdFavoritos(), 0);

		perfil1.adicionaPlaylist("Para fazer Laboratorios", "Nevermind", 2);
		perfil1.adicionaPlaylist("Para fazer Laboratorios", "Use Your Illusion I", 1);
		Assert.assertEquals(perfil1.getTamPlaylist("Para fazer Laboratorios"), 2);
		Assert.assertTrue(perfil1.contemNaPlaylist("Para fazer Laboratorios", "Come As You Are"));

		Assert.assertEquals(album2, perfil1.pesquisaAlbum("Nevermind"));

	}

	public void testPerfilPlaylistInvalido() {

		Perfil perfilInvalido = new Perfil("Raquel");
		perfilInvalido.adicionaPlaylist("Para fazer Laboratorios", "Closer", 1);
		Assert.fail();

	}
}