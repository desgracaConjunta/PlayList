package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.PlayList;
import services.Logica;

public class PlayListQuery {

	public static void loadPlayList(){
		String playlist = "SELECT playlist_id, playlist_nome, playlist_limite, playlist_data FROM PlayList WHERE playlist_estado = 1";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery(playlist);
            
            while ( rs.next() ) {
                Logica.arPlayLists.add(new PlayList(rs.getInt("playlist_id"), rs.getInt("playlist_limite"), rs.getString("playlist_nome"), rs.getString("playlist_data")));
            }
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
	}
	
	public static int addPlayList(String playlist_nome, int playlist_limite, String playlist_data) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO PlayList(playlist_nome, playlist_limite, playlist_data)"
						+ " VALUES ('" + Coneccao.cleanQuery(playlist_nome) + "',"
						+ " '" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(playlist_limite))) + "',"
						+ " '" + playlist_data + "')");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//
		
		String user = "SELECT MAX(playlist_id) AS max_id FROM PlayList"; //Query para ir buscar o ID maximo da tabela PlayList
		
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
	
	public static void editPlayList(int playlist_id, String playlist_nome, int playlist_limite, String playlist_data){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE PlayList"
					+ " SET playlist_nome = '" + Coneccao.cleanQuery(playlist_nome) + "',"
					+ " playlist_limite = '" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(playlist_limite))) + "',"
					+ " playlist_data = '" + playlist_data + "'"
							+ " WHERE playlist_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(playlist_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	public static void delPlayList(int playlist_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE PlayList"
					+ " SET playlist_estado = 0"
							+ " WHERE playlist_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(playlist_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
}
