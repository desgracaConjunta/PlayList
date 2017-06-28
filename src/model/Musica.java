package model;

public class Musica {

	private int musica_id, musica_duracao, musica_album_id, musica_visualizacao, musica_ano, musica_autor_id;
	private String musica_nome, musica_path;
	private boolean musica_estado;
	
	public Musica(){
		
	}

	public Musica(int musica_id, int musica_duracao, int musica_album_id, int musica_visualizacao, int musica_ano,
			int musica_autor_id, String musica_nome, String musica_path, boolean musica_estado) {
		super();
		this.musica_id = musica_id;
		this.musica_duracao = musica_duracao;
		this.musica_album_id = musica_album_id;
		this.musica_visualizacao = musica_visualizacao;
		this.musica_ano = musica_ano;
		this.musica_autor_id = musica_autor_id;
		this.musica_nome = musica_nome;
		this.musica_path = musica_path;
		this.musica_estado = musica_estado;
	}

	public int getMusica_id() {
		return musica_id;
	}

	public void setMusica_id(int musica_id) {
		this.musica_id = musica_id;
	}

	public int getMusica_duracao() {
		return musica_duracao;
	}

	public void setMusica_duracao(int musica_duracao) {
		this.musica_duracao = musica_duracao;
	}

	public int getMusica_album_id() {
		return musica_album_id;
	}

	public void setMusica_album_id(int musica_album_id) {
		this.musica_album_id = musica_album_id;
	}

	public int getMusica_visualizacao() {
		return musica_visualizacao;
	}

	public void setMusica_visualizacao(int musica_visualizacao) {
		this.musica_visualizacao = musica_visualizacao;
	}

	public int getMusica_ano() {
		return musica_ano;
	}

	public void setMusica_ano(int musica_ano) {
		this.musica_ano = musica_ano;
	}

	public int getMusica_autor_id() {
		return musica_autor_id;
	}

	public void setMusica_autor_id(int musica_autor_id) {
		this.musica_autor_id = musica_autor_id;
	}

	public String getMusica_nome() {
		return musica_nome;
	}

	public void setMusica_nome(String musica_nome) {
		this.musica_nome = musica_nome;
	}

	public String getMusica_path() {
		return musica_path;
	}

	public void setMusica_path(String musica_path) {
		this.musica_path = musica_path;
	}

	public boolean isMusica_estado() {
		return musica_estado;
	}

	public void setMusica_estado(boolean musica_estado) {
		this.musica_estado = musica_estado;
	}
	
	

}