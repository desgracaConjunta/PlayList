package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.UserQuerys;


public class SLogin implements Logica{
	
	public int verifLog(String mail, String pass) {
		
		return UserQuerys.login(mail, pass);
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if (req.getParameter("acao").equals("login")) {
			int id = verifLog(req.getParameter("user"), req.getParameter("pass"));
			if(id != 0){
				req.getSession().setAttribute("log", id);
			}
		} else if (req.getParameter("acao").equals("logout")) {
			Logica.arAlbuns.clear();
			Logica.arArtitas.clear();
			Logica.arAutores.clear();
			Logica.arFuncoes.clear();
			Logica.arGeneros.clear();
			Logica.arMusicas.clear();
			Logica.arPlayLists.clear();
			Logica.arUSers.clear();
	
			
			req.getSession().invalidate();
		}
		
		req.setAttribute("listaUsers", Logica.arUSers );
		
		return "/index.jsp";
	}

	
}
