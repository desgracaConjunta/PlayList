package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.UserPlayList;
import services.SPlayList;
import services.SUser;

public class UserPlaylistQuery {

	public static void loadUserPlaylist(){
		SUser sUser = new SUser(); //Instância de SUser
		SPlayList sPlayList = new SPlayList(); //Instância de SPlaylist
		
		String user_playlist = "SELECT up_id, up_user_id, up_playlist_id FROM User_PlayList";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery(user_playlist);
            
            while(rs.next()){
            	sUser.procurarUser(rs.getInt("up_user_id")).getUserPlaylist().add(new UserPlayList(rs.getInt("up_id"), sPlayList.procurarPlaylist(rs.getInt("up_playlist_id"))));
            }
            
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
		
	}
	
	public static int addUserPlaylist(int user_id, int playlist_id) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO User_PlayList(up_user_id, up_playlist_id)"
						+ " VALUES ('" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(user_id))) + "',"
							+ " '" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(playlist_id))) + "')");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//
		
		String user = "SELECT MAX(up_id) AS max_id FROM User_PlayList"; //Query para ir buscar o ID maximo da tabela Utilizador_PlayList
		
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
	
	public static void delUserPlaylist(int user_playlist_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"DELETE FROM User_PlayList"
						+ " WHERE up_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(user_playlist_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
}
