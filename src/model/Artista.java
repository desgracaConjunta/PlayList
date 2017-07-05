package model;

public class Artista{
	private int artista_id;
	private String artista_nome;
	public Artista(){
		
	}
	public Artista(int artista_id, String artista_nome) {
		super();
		this.artista_id = artista_id;
		this.artista_nome = artista_nome;
	}
	public int getArtista_id() {
		return artista_id;
	}
	public void setArtista_id(int artista_id) {
		this.artista_id = artista_id;
	}
	public String getArtista_nome() {
		return artista_nome;
	}
	public void setArtista_nome(String artista_nome) {
		this.artista_nome = artista_nome;
	}
}
