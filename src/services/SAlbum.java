package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;

public class SAlbum implements Logica{
	
	public void addAlbum(String nome) {
		Logica.arAlbuns.add(new Album(Logica.arAlbuns.size(),nome,1));
	}
	
	public void editAlbum(int id,String nome,int enabled) {
		Logica.arAlbuns.get(id).setAlbum_nome(nome);
		Logica.arAlbuns.get(id).setAlbum_enabled(id);
	}
	
	public void delAlbum(int id) {
		if(Logica.arAlbuns.get(id).getAlbum_id()==id) Logica.arAlbuns.remove(id);
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
		}else if(req.getAttribute("acao").equals("editAlbum")) {
			editAlbum(Integer.parseInt(req.getParameter("id_Album")),
					  req.getParameter("edit_nome_Album"),
					  Integer.parseInt(req.getParameter("edit_estado_Album")));
		}else if(req.getParameter("acao").equals("delAbum")) {
			
		}
		
		req.setAttribute("listaAlbuns", Logica.arAlbuns);
		
		
		return "/index.jsp?pag=album";
	}

}
