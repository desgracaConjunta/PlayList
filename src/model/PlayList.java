package model;

public class PlayList {

	private int playlist_id,playlist_qta_musica;
	private String playlist_nome,playlist_data;
	private boolean playlist_estado;
	
	public PlayList(){
		
	}

	public PlayList(int playlist_id, int playlist_qta_musica, String playlist_nome, String playlist_data,
			boolean playlist_estado) {
		super();
		this.playlist_id = playlist_id;
		this.playlist_qta_musica = playlist_qta_musica;
		this.playlist_nome = playlist_nome;
		this.playlist_data = playlist_data;
		this.playlist_estado = playlist_estado;
	}

	public int getPlaylist_id() {
		return playlist_id;
	}

	public void setPlaylist_id(int playlist_id) {
		this.playlist_id = playlist_id;
	}

	public int getPlaylist_qta_musica() {
		return playlist_qta_musica;
	}

	public void setPlaylist_qta_musica(int playlist_qta_musica) {
		this.playlist_qta_musica = playlist_qta_musica;
	}

	public String getPlaylist_nome() {
		return playlist_nome;
	}

	public void setPlaylist_nome(String playlist_nome) {
		this.playlist_nome = playlist_nome;
	}

	public String getPlaylist_data() {
		return playlist_data;
	}

	public void setPlaylist_data(String playlist_data) {
		this.playlist_data = playlist_data;
	}

	public boolean isPlaylist_estado() {
		return playlist_estado;
	}

	public void setPlaylist_estado(boolean playlist_estado) {
		this.playlist_estado = playlist_estado;
	}
	
	

}