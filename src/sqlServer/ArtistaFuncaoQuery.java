package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ArtistaFuncaoQuery {

	public static void loadArtistaFuncao(){
		/*String tema = "SELECT  FROM WHERE";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery(tema);
            
            while ( rs.next() ) {
            	Tema t;
            	if(rs.getInt("tema_id_precedencia") == 0){
            		t = null;
            	}else{
            		t = Logica.temas.get(rs.getInt("tema_id_precedencia"));
            	}
                Logica.temas.add(new Tema(rs.getInt("tema_id"), rs.getString("tema_nome"), rs.getString("tema_intro"), rs.getString("tema_conteudo"), t, rs.getInt("tema_restricao") ));
            }
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }*/
	}
	
	public static int addArtistaFuncao(int artista_id, int funcao_id) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO Artista_Funcao(af_artista_id, af_funcao_id)"
						+ " VALUES ('" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(artista_id))) + "',"
						+ " '" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(funcao_id))) + "')");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//
		
		String user = "SELECT MAX(af_id) AS max_id FROM Artista_Funcao"; //Query para ir buscar o ID maximo da tabela Artista_Funcao
		
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
	
	public static void delArtistaFuncao(int artista_funcao_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"DELETE FROM Artista_Funcao"
						+ " WHERE af_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(artista_funcao_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
}
