package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Ander Lopez
 * @version 1.1
 */

public class gestorDB 
{
	private static String db= "database.db";
	private static String url= "jdbc:sqlite:" + db;
	private static Connection con;
	
	public static void Conectar(){
		try{
			con = DriverManager.getConnection(url);
			System.out.println("Conexion realizada con exito a : " + db);
			crearTablas();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	private static void crearTablas(){
		Conectar();
		try{
			Statement statement = con.createStatement();
			String tabla1= "";
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
}
