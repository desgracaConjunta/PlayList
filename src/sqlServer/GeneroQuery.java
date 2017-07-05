package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Genero;
import services.Logica;

public class GeneroQuery {

	public static void loadGenero(){
		String genero = "SELECT genero_id, genero_nome FROM Genero WHERE genero_estado = 1";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery(genero);
            
            while ( rs.next() ) {
                Logica.arGeneros.add(new Genero(rs.getInt("genero_id"), rs.getString("genero_nome")));
            }
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
	}
	
	public static int addGenero(String genero_nome) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO Genero(genero_nome)"
						+ " VALUES ('" + Coneccao.cleanQuery(genero_nome) + "')");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//
		
		String user = "SELECT MAX(genero_id) AS max_id FROM Genero"; //Query para ir buscar o ID maximo da tabela Genero
		
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
	
	public static void editGenero(int genero_id, String genero_nome){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Genero"
					+ " SET genero_nome = '" + Coneccao.cleanQuery(genero_nome) + "'"
							+ " WHERE genero_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(genero_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	public static void delGenero(int genero_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Genero"
					+ " SET genero_estado = 0"
							+ " WHERE genero_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(genero_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
}
