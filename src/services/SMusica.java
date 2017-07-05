package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Musica;

public class SMusica implements Logica {

	public Musica procurarMusica(int musica_id){
		for(Musica m : Logica.arMusicas){
			if(m.getMusica_id() == musica_id) return m;
		}
		
		return null;
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		return "/index.jsp";
	}

}
