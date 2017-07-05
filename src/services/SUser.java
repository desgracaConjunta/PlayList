package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import sqlServer.UserQuery;

public class SUser implements Logica{
	
	UserQuery userQuery = new UserQuery();
	
	public boolean login(HttpServletRequest req) {
		
		int user_id = userQuery.login(req.getParameter("user_mail"), req.getParameter("user_pass"));
		
		if(user_id != 0) {
			HttpSession sessao = req.getSession(true);
			
			sessao.setAttribute("user_id", user_id); //Guarda o ID do utilizador numa varavel de sessao
			//System.out.println("tipo: " + procurarUser(user_id).getUser_tipo());
			//sessao.setAttribute("user_tipo", procurarUser(user_id).getUser_tipo()); //Guarda o ID do tipo de utilizador numa varavel de sessao
			
			return true; //Se o login for efetuado com sucesso retorna true
		}
		
		return false; //Se o login nao for efetuado com sucesso retorna false
	}
	
 	public String addUser(HttpServletRequest req, String user_name, String user_nick, String user_email, String user_pass){
	
		if(verificarNick(user_nick) == true){
			
			req.setAttribute("NickExistente", user_nick);
			
			return "Paginas/User.jsp";
		}else{
			
			Logica.arUSers.add(new User(Logica.arUSers.size()+1, user_name, user_nick, user_pass, user_email, 1));
			System.out.print("Tamanho: " + Logica.arUSers.size());
		}
		return "Paginas/User.jsp";	
	}
	
	public Boolean verificarNick(String user_nick){
		
		System.out.println("Entrou na verificacao");
		for(int i = 0; i< Logica.arUSers.size(); i++){
			if(Logica.arUSers.get(i).getUser_mick().equals(user_nick)){
				return true;//SIGNIFICA QUE EXISTE
			}
		}
		
		return false;
	}
	
	public User procurarUser(int user_id){
		
		for(int i = 0; i < Logica.arUSers.size(); i++){
			if(Logica.arUSers.get(i).getUser_id() == user_id){
				return Logica.arUSers.get(i);
			}
		}
		
		return null;
	}
	
	public void elimUser(int user_id) {
	
	for(int i = 0; i < Logica.arUSers.size(); i++) {
		if(Logica.arUSers.get(i).getUser_id() == user_id) {
			Logica.arUSers.remove(i);
		}
	}
}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

			if(req.getParameter("acao").equals("confirmNick")){ //Ação Adicionar Funcionario
					
				if(verificarNick(req.getParameter("user_nick"))){ //SIGNIFICA QUE DE FATO O NICK NAO ESTA REPETIDO
				
					addUser(req, req.getParameter("user_name"), req.getParameter("user_nick"),
							req.getParameter("nick_email"),
							req.getParameter("user_pass"));
					
				}

			}else if(req.getParameter("acao").equals("elimUser")) {
				elimUser(Integer.parseInt(req.getParameter("user_id")));
			}else if(req.getParameter("acao").equals("login")) {
				System.out.println(login(req));
			}
				return "/login.jsp";
				//req.setAttribute("listasUsers", Logica.arUSers);
				//return "Paginas/User.jsp";
	}
}