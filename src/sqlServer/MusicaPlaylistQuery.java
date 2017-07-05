package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.MusicaPlayList;
import services.SMusica;
import services.SPlayList;

public class MusicaPlaylistQuery {

	public static void loadMusicaPlaylist(){
		SPlayList sPlayList = new SPlayList(); //Instância de SPlaylist
		SMusica sMusica = new SMusica(); //Instância de SPlaylist
		
		String musica_playlist = "SELECT mp_id, mp_musica_id, mp_playlist_id FROM Musica_PlayList";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery(musica_playlist);
            
            while ( rs.next() ) {
                sPlayList.procurarPlaylist(rs.getInt("mp_playlist_id")).getMusicaPlaylist().add(new MusicaPlayList(rs.getInt("mp_id"), sMusica.procurarMusica(rs.getInt("mp_musica_id"))));
            }
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
	}
	
	public static int addMusicaPlaylist(int playlist_id, int musica_id) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO Musica_PlayList(mp_playlist_id, mp_musica_id)"
						+ " VALUES ('" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(playlist_id))) + "',"
						+ " '" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(musica_id))) + "')");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//
		
		String user = "SELECT MAX(mp_id) AS max_id FROM Musica_PlayList"; //Query para ir buscar o ID maximo da tabela Musica_PlayList
		
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
	
	public static void delMusicaPlaylist(int musica_playlist_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"DELETE FROM Musica_PlayList"
						+ " WHERE af_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(musica_playlist_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
}
