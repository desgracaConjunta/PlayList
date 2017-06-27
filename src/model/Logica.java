package model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {

	static ArrayList<Musica>   arMusicas   = new ArrayList<>();
	static ArrayList<User>     arUSers     = new ArrayList<>();
	static ArrayList<Artista>  arArtistas  = new ArrayList<>();
	static ArrayList<PlayList> arPlayLists = new ArrayList<>();
	static ArrayList<Genero>   arGeneros   = new ArrayList<>();
	static ArrayList<Musico>   arMusicos   = new ArrayList<>();
	
	String executa(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
