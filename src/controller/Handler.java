package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.Logica;
import sqlServer.PageOnLoad;

/**
 * Servlet implementation class HandlerIndex
 */
@WebServlet("/Handler")
public class Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PageOnLoad pageOnLoad;

    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public Handler() {
        super();
        pageOnLoad = new PageOnLoad();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(true);
		
		if(sessao.getAttribute("user_id") == null){
			pageOnLoad.carregarInformacao();
		}

		request.setAttribute("listaMusicas",  Logica.arMusicas);
		request.setAttribute("listaUsers",    Logica.arUSers);
		request.setAttribute("listaArtistas", Logica.arArtitas);
		request.setAttribute("listaPlayLists",Logica.arPlayLists);
		request.setAttribute("listaGeneros",  Logica.arGeneros);
		request.setAttribute("listaFuncoes",  Logica.arFuncoes);
		request.setAttribute("listaAlbuns",	  Logica.arAlbuns);
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("logica"); //Recebe como parametro do jsp, qual a class do service que irá atuar
	    String nomeDaClasse = "services." + parametro; //Nome da Classe
	    
	    try {
	      Class<?> classe = Class.forName(nomeDaClasse);
	      Logica logica = (Logica) classe.newInstance();
	      
	      String pagina = logica.executa(request, response);
	      request.getRequestDispatcher(pagina).forward(request, response);

	    } catch (Exception e) {
	      throw new ServletException(
	          "A lógica causou uma exceção", e);
	    }
	}

}
