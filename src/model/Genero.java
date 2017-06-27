package model;

public class Genero {
	
	private int genero_id;
	private String genero_nome;

	public Genero(){
		
	}

	public Genero(int genero_id, String genero_nome) {
		super();
		this.genero_id = genero_id;
		this.genero_nome = genero_nome;
	}

	public int getGenero_id() {
		return genero_id;
	}

	public void setGenero_id(int genero_id) {
		this.genero_id = genero_id;
	}

	public String getGenero_nome() {
		return genero_nome;
	}

	public void setGenero_nome(String genero_nome) {
		this.genero_nome = genero_nome;
	}

	
	
}
