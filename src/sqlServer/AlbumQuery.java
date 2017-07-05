package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Album;
import services.Logica;

public class AlbumQuery {
	
	public static void loadAlbum(){
		String album = "SELECT album_id, album_nome FROM Album WHERE album_estado = 1";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery(album);
            
            while ( rs.next() ) {
                Logica.arAlbuns.add(new Album(rs.getInt("album_id"), rs.getString("album_nome")));
            }
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
	}
	
	public static int addAlbum(String album_nome) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO Album(album_nome)"
						+ " VALUES ('" + Coneccao.cleanQuery(album_nome) + "')");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//

		String user = "SELECT MAX(album_id) AS max_id FROM Album"; //Query para ir buscar o ID maximo da tabela Album
		
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
	
	public static void editAlbum(int album_id, String album_nome){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Album"
					+ " SET album_nome = '" + Coneccao.cleanQuery(album_nome) + "'"
							+ " WHERE album_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(album_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	public static void delAlbum(int album_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Album"
					+ " SET enabled = 0"
							+ " WHERE album_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(album_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
}
