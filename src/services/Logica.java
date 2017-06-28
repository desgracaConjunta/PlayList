package services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Autor;
import model.Funcao;
import model.Genero;
import model.Musica;
import model.Album;
import model.Artista;
import model.PlayList;
import model.User;

public interface Logica {

	static ArrayList<Musica>   arMusicas   = new ArrayList<>();
	static ArrayList<User>     arUSers     = new ArrayList<>();
	static ArrayList<Autor>    arAutores   = new ArrayList<>();
	static ArrayList<PlayList> arPlayLists = new ArrayList<>();
	static ArrayList<Genero>   arGeneros   = new ArrayList<>();
	static ArrayList<Artista>  arArtitas   = new ArrayList<>();
	static ArrayList<Album>    arAlbuns    = new ArrayList<>();
	static ArrayList<Funcao>   arFuncoes   = new ArrayList<>();
	
	String executa(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
