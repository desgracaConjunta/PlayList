package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Logica;

/**
 * Servlet implementation class HandlerIndex
 */
@WebServlet("/HandlerIndex")
public class Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Handler() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaMusicas", Logica.arMusicas);
		request.setAttribute("listaUsers", Logica.arUSers);
		request.setAttribute("listaArtista", Logica.arArtistas);
		request.setAttribute("listaPlayList", Logica.arPlayLists);
		request.setAttribute("listaGeneros", Logica.arGeneros);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
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
