package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PlayList;

public class SPlayList implements Logica{

	public PlayList procurarPlaylist(int playlist_id){
		for(PlayList pl : Logica.arPlayLists){
			if(pl.getPlaylist_id() == playlist_id) return pl;
		}
		
		return null;
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		return "/index.jsp";
	}

}
