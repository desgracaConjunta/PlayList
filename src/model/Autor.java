package model;

public class Autor{
	
	private int autor_id;
	private String autor_nome;
	private boolean autor_estado;
	
	public Autor(){
		
	}

	public Autor(int autor_id, String autor_nome, boolean autor_estado) {
		super();
		this.autor_id = autor_id;
		this.autor_nome = autor_nome;
		this.autor_estado = autor_estado;
	}

	public int getAutor_id() {
		return autor_id;
	}

	public void setAutor_id(int autor_id) {
		this.autor_id = autor_id;
	}

	public String getAutor_nome() {
		return autor_nome;
	}

	public void setAutor_nome(String autor_nome) {
		this.autor_nome = autor_nome;
	}

	public boolean isAutor_estado() {
		return autor_estado;
	}

	public void setAutor_estado(boolean autor_estado) {
		this.autor_estado = autor_estado;
	}

	
	
	
	

}
