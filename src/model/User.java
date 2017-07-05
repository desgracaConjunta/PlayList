package model;

import java.util.ArrayList;

public class User {
	
	private int user_id;
	private String user_nome;
	private String user_mick;
	private String user_password;
	private String user_email;
	private int user_tipo;
	ArrayList<UserPlayList> userPlaylist;
	
	public User(){
		
	}
	public User(int user_id, String user_nome, String user_mick, String user_password,
			String user_email, int user_tipo) {
		super();
		this.user_id = user_id;
		this.user_nome = user_nome;
		this.user_mick = user_mick;
		this.user_password = user_password;
		this.user_email = user_email;
		this.user_tipo = user_tipo;
		userPlaylist = new ArrayList<>();
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_nome() {
		return user_nome;
	}
	public void setUser_nome(String user_nome) {
		this.user_nome = user_nome;
	}
	public String getUser_mick() {
		return user_mick;
	}
	public void setUser_mick(String user_mick) {
		this.user_mick = user_mick;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getUser_tipo() {
		return user_tipo;
	}
	public void setUser_tipo(int user_tipo) {
		this.user_tipo = user_tipo;
	}

	public ArrayList<UserPlayList> getUserPlaylist() {
		return userPlaylist;
	}

	public void setUserPlaylist(ArrayList<UserPlayList> userPlaylist) {
		this.userPlaylist = userPlaylist;
	}

}