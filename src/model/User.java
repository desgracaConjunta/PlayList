package model;

public class User extends Pessoa{

	private String user_nick;
	
	public User(){
		
	}

	public User(int pessoa_id, int pessoa_tipo, String pessoa_nome, String pessoa_email, String pessoa_pass, String user_nick) {
		super(pessoa_id, pessoa_tipo, pessoa_nome, pessoa_email, pessoa_pass);
		this.setUser_nick(user_nick);
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	
	
}
