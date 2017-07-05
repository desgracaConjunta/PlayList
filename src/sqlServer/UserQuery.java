package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.User;
import services.Logica;

public class UserQuery {
	
	public static void loadUser(){
		String user = "SELECT user_id, user_tipo, user_nome, user_nick, user_mail, user_password FROM Utilizador WHERE user_estado = 1";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
			ResultSet rs;

			rs = st.executeQuery(user);

			while (rs.next()) {
				Logica.arUSers.add(new User(rs.getInt("user_id"), rs.getString("user_nome"),
						rs.getString("user_nick"), rs.getString("user_mail"), rs.getString("user_password"), rs.getInt("user_tipo")));
			}
			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! TemaQuerys.load()");
			System.err.println(e.getMessage());
		}
	}
	
	public static int addUser(String user_nome, String user_nick, String user_mail, String user_password) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO Utilizador(pessoa_id, user_nome, user_nick, user_mail, user_password)"
						+ "'" + Coneccao.cleanQuery(user_nome) + "',"
						+ "'" + Coneccao.cleanQuery(user_nick) + "'"
						+ "'" + Coneccao.cleanQuery(user_mail) + "'"
						+ "'" + Coneccao.cleanQuery(user_password) + "')");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//
		
		String user = "SELECT MAX(user_id) AS max_id FROM Utilizador"; //Query para ir buscar o ID maximo da tabela Utilizador
		
		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
			ResultSet rs;

			rs = st.executeQuery(user);

			while(rs.next()) {
				if(rs.getInt("max_id") >= 1) { //Se o ID retornado pela query for maior ou igual a 1, este metodo ira retornar esse valor mais um
					return rs.getInt("max_id")+1;
				}else { //Caso contrario ira retornar 1
					return 1;
				}
			}
			
			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! TemaQuerys.load()");
			System.err.println(e.getMessage());
		}
		
		return 0;
	}
	
	public static void editUser(int user_id, String user_nome, String user_nick, String user_mail, String user_password){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Utilizador"
					+ " SET user_nome = '" + Coneccao.cleanQuery(user_nome) + "',"
					+ " user_nick = '" + Coneccao.cleanQuery(user_nick) + "',"
					+ " user_mail = '" + Coneccao.cleanQuery(user_mail) + "',"
					+ " user_password = '" + Coneccao.cleanQuery(user_password) + "',"
							+ " WHERE user_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(user_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	public static void delUser(int user_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Utilizador"
					+ " SET user_estado = 0"
							+ " WHERE user_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(user_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	// Devolve o ID do utilizador
	public static int login(String user_mail, String user_pass) {
		String login = "SELECT user_id, user_tipo FROM Utilizador WHERE user_mail = '" + Coneccao.cleanQuery(user_mail)
				+ "' AND user_password = '" + Coneccao.cleanQuery(user_pass) + "' AND user_estado = 1";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
			ResultSet rs;

			rs = st.executeQuery(login);

			if (rs.next()) {
				return rs.getInt("user_id");
			}

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! UserQuerys.login()");
			System.err.println(e.getMessage());
		}

		return 0;
	}
}
