package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Musica;
import services.Logica;

public class MusicaQuery {

	public static void loadMusica(){
		String musica = "SELECT musica_id, musica_nome, musica_genero_id, musica_duracao, musica_album_id, musica_caminho, musica_visualizacao, musica_ano, musica_autor_id FROM Musica WHERE musica_estado = 1";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery(musica);
            
            while ( rs.next() ) {
                Logica.arMusicas.add(new Musica(rs.getInt("musica_id"), rs.getInt("musica_duracao"), rs.getInt("musica_album_id"),
                		rs.getInt("musica_visualizacao"), rs.getString("musica_ano"), rs.getInt("musica_autor_id"),
                		rs.getString("musica_nome"), rs.getString("musica_caminho")));
            }
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
	}
	
	public static int addMusica(String musica_nome, int genero_id, int musica_duracao,
			int album_id, String caminho, String musica_ano, int autor_id) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO Musica(musica_nome, musica_genero_id, musica_duracao,"
						+ " musica_album_id, musica_caminho, musica_visualizacao, musica_ano,"
							+ " musica_autor_id)"
								+ " VALUES ('" + Coneccao.cleanQuery(musica_nome) + "',"
									+ " " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(genero_id))) + ","
										+ " " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(musica_duracao))) + ","
											+ " " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(album_id))) + ","
												+ "'" + Coneccao.cleanQuery(caminho) + "',"
													+ "0,"
														+ "'" + Coneccao.cleanQuery(musica_ano) + "',"
															+ "" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(autor_id))) + ")");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//
		
		String user = "SELECT MAX(musica_id) AS max_id FROM Musica"; //Query para ir buscar o ID maximo da tabela Musica
		
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
	
	public static void editMusica(int musica_id, String musica_nome, int genero_id, int musica_duracao,
			int album_id, String caminho, String musica_ano, int autor_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Musica"
						+ " SET musica_nome = '" + Coneccao.cleanQuery(musica_nome) + "',"
							+ " musica_genero_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(genero_id))) + ","
								+ "musica_duracao = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(musica_duracao))) + ","
									+ " musica_album_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(album_id))) + ","
										+ " musica_caminho = '" + Coneccao.cleanQuery(caminho) + "',"
											+ "musica_ano = '" + Coneccao.cleanQuery(musica_ano) + "',"
												+ " autor_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(autor_id))) + ""
													+ " WHERE musica_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(musica_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	public static void delMusica(int musica_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Musica"
						+ " SET musica_estado = 0"
							+ " WHERE musica_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(musica_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
}
