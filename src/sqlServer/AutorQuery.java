package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Autor;
import services.Logica;

public class AutorQuery {
	
	public static void loadAutor(){
		String autor = "SELECT autor_id, autor_nome FROM Autor WHERE autor_estado = 1";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery(autor);
            
            while ( rs.next() ) {
                Logica.arAutores.add(new Autor());
            }
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
	}
	
	public static int addAutor(String autor_nome) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO Autor(pessoa_id, autor_nome)"
						+ " VALUES ('" + Coneccao.cleanQuery(autor_nome) + "')");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//
		
		String user = "SELECT MAX(autor_id) AS max_id FROM Autor"; //Query para ir buscar o ID maximo da tabela Autor
		
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
	
	public static void editAutor(int autor_id, String autor_nome){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Autor"
					+ " SET autor_nome = '" + Coneccao.cleanQuery(autor_nome) + "'"
							+ " WHERE autor_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(autor_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	public static void delAutor(int autor_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Autor"
					+ " SET autor_estado = 0"
							+ " WHERE autor_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(autor_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
}
