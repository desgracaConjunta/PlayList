package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Funcao;
import services.Logica;

public class FuncaoQuery {
	
	public static void loadFuncao(){
		String funcao = "SELECT funcao_id, funcao_descricao FROM Funcao WHERE funcao_estado = 1";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery(funcao);
            
            while ( rs.next() ) {
                Logica.arFuncoes.add(new Funcao(rs.getInt("funcao_id"), rs.getString("funcao_descricao")));
            }
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
	}
	
	public static int addFuncao(String funcao_descricao) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO Funcao(funcao_descricao)"
						+ " VALUES ('" + Coneccao.cleanQuery(funcao_descricao) + "')");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//
		
		String user = "SELECT MAX(funcao_id) AS max_id FROM Funcao"; //Query para ir buscar o ID maximo da tabela Funcao
		
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
	
	public static void editFuncao(int funcao_id, String funcao_descricao){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Funcao"
					+ " SET funcao_descricao = '" + Coneccao.cleanQuery(funcao_descricao) + "'"
							+ " WHERE funcao_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(funcao_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	public static void delFuncao(int funcao_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"UPDATE Funcao"
					+ " SET funcao_estado = 0"
							+ " WHERE funcao_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(funcao_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
}
