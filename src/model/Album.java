package model;

public class Album {
	private int album_id;
	private String album_nome;
	public Album () {
		
	}
	public Album(int album_id, String album_nome) {
		super();
		this.album_id = album_id;
		this.album_nome = album_nome;
	}
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public String getAlbum_nome() {
		return album_nome;
	}
	public void setAlbum_nome(String album_nome) {
		this.album_nome = album_nome;
	}
}
