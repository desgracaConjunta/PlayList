package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;

public class SAlbum implements Logica{
	
	public void addAlbum(String nome) {
		Logica.arAlbuns.add(new Album(Logica.arAlbuns.size(),nome));
	}
	
	public void editAlbum(int id,String nome) {
		Logica.arAlbuns.get(id).setAlbum_nome(nome);
	}
	
	public void delAlbum(int id) {
		for(int i=0; i<Logica.arAlbuns.size();i++) {
			if(Logica.arAlbuns.get(i).getAlbum_id()==id) Logica.arAlbuns.remove(i);
		}
	}

	public Album procAlbum(int idAlb) {
		Album alb = new Album();
		for(Album a:Logica.arAlbuns) {
			if(idAlb == a.getAlbum_id()) {
				alb = a;
			}
		}
		
		return alb;
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if(req.getParameter("acao").equals("addAlbum")) {
			addAlbum(req.getParameter("add_nome_album"));
		}else if(req.getParameter("acao").equals("editT")) {
			editAlbum(Integer.parseInt(req.getParameter("listaAlbum")),
					  req.getParameter("editAlbum"));
		}else if(req.getParameter("acao").equals("delAlbum")) {

			delAlbum(Integer.parseInt(req.getParameter("listaAlb")));
		}
		
		req.setAttribute("listaAlbuns", Logica.arAlbuns);
		
		
		return "/index.jsp?pag=album";
	}

}
