package model;

public class Artista extends Pessoa{
	
	private String artista_nome_banda;
	
	public Artista(){
		
	}
	
	public Artista(int pessoa_id, int pessoa_tipo,String pessoa_nome, String pessoa_email, String pessoa_pass,String artista_nome_banda) {
		super(pessoa_id,pessoa_tipo,pessoa_nome,pessoa_email,pessoa_pass);
		this.artista_nome_banda = artista_nome_banda;
	}
	
	public String getArtista_nome_banda() {
		return artista_nome_banda;
	}

	public void setArtista_nome_banda(String artista_nome_banda) {
		this.artista_nome_banda = artista_nome_banda;
	}

	
	
	

}
