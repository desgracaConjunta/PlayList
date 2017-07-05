package sqlServer;

public class PageOnLoad {
	
	public static void carregarInformacao(){
		UserQuery.loadUser();
		PlayListQuery.loadPlayList();
		MusicaQuery.loadMusica();
		GeneroQuery.loadGenero();
		FuncaoQuery.loadFuncao();
		AutorQuery.loadAutor();
		ArtistaQuery.loadArtista();
		AlbumQuery.loadAlbum();
		UserPlaylistQuery.loadUserPlaylist();
		ArtistaFuncaoQuery.loadArtistaFuncao();
		ArtistaMusicaQuery.loadArtistaMusica();
		GeneroMusicaQuery.loadGeneroMusica();
		MusicaPlaylistQuery.loadMusicaPlaylist();
	}
}
