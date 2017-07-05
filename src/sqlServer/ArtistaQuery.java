package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Artista;
import services.Logica;

public class ArtistaQuery {
	
	public static void loadArtista(){
		String artista = "SELECT artista_id, artista_nome FROM Artista WHERE artista_estado = 1";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery(artista);
            
            while ( rs.next() ) {
                Logica.arArtitas.add(new Artista(rs.getInt("artista_id"), rs.getString("artista_nome")));
            }
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
	}
	
	public static int addArtista(String artista_nome) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO Artista(artista_nome)"
						+ " VALUES ('" + Coneccao.cleanQuery(artista_nome) + "')");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//
		
		String user = "SELECT MAX(artista_id) AS max_id FROM Artista"; //Query para ir buscar o ID maximo da tabela Artista
		
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
	
	public static void editArtista(int artista_id, String artista_nome){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Artista"
					+ " SET artista_nome = '" + Coneccao.cleanQuery(artista_nome) + "'"
							+ " WHERE artista_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(artista_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	public static void delArtista(int artista_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Artista"
					+ " SET artista_estado = 0"
							+ " WHERE artista_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(artista_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
}
