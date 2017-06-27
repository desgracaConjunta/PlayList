package model;

public class Musico extends Pessoa{
	
	private String funcao_nome; 

	public Musico(){
		
	}

	public Musico(int pessoa_id, int pessoa_tipo, String pessoa_nome, String pessoa_email, String pessoa_pass, String funcao_nome) {
		super(pessoa_id, pessoa_tipo, pessoa_nome, pessoa_email, pessoa_pass);
		this.setFuncao_nome(funcao_nome);
	}

	public String getFuncao_nome() {
		return funcao_nome;
	}

	public void setFuncao_nome(String funcao_nome) {
		this.funcao_nome = funcao_nome;
	}
	
	
	
}
