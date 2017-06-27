package model;

public class Pessoa {
	
	private int pessoa_id, pessoa_tipo;
	private String pessoa_nome, pessoa_email, pessoa_pass;
	
	public Pessoa(){
		
	}
	
	public Pessoa(int pessoa_id, int pessoa_tipo, String pessoa_nome, String pessoa_email, String pessoa_pass) {
		super();
		this.pessoa_id = pessoa_id;
		this.pessoa_tipo = pessoa_tipo;
		this.pessoa_nome = pessoa_nome;
		this.pessoa_email = pessoa_email;
		this.pessoa_pass = pessoa_pass;
	}
	public int getPessoa_id() {
		return pessoa_id;
	}

	public void setPessoa_id(int pessoa_id) {
		this.pessoa_id = pessoa_id;
	}
	
	public int getPessoa_tipo() {
		return pessoa_tipo;
	}

	public void setPessoa_tipo(int pessoa_tipo) {
		this.pessoa_tipo = pessoa_tipo;
	}

	public String getPessoa_nome() {
		return pessoa_nome;
	}

	public void setPessoa_nome(String pessoa_nome) {
		this.pessoa_nome = pessoa_nome;
	}

	public String getPessoa_email() {
		return pessoa_email;
	}

	public void setPessoa_email(String pessoa_email) {
		this.pessoa_email = pessoa_email;
	}

	public String getPessoa_pass() {
		return pessoa_pass;
	}

	public void setPessoa_pass(String pessoa_pass) {
		this.pessoa_pass = pessoa_pass;
	}

	
	
	
	
}
