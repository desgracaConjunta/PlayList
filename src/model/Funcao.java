package model;

public class Funcao {
	private int funcao_id;
	private String funcao_descricao;
	public Funcao(int funcao_id, String funcao_descricao) {
		super();
		this.funcao_id = funcao_id;
		this.funcao_descricao = funcao_descricao;
	}
	public int getFuncao_id() {
		return funcao_id;
	}
	public void setFuncao_id(int funcao_id) {
		this.funcao_id = funcao_id;
	}
	public String getFuncao_descricao() {
		return funcao_descricao;
	}
	public void setFuncao_descricao(String funcao_descricao) {
		this.funcao_descricao = funcao_descricao;
	}
}
