package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Cliente;
import clases.Coche;
import clases.Concesionario;
import clases.Moto;

/**
 * 
 * @author Ander Lopez
 * @version 1.2
 */

public class gestorDB1 
{
	private static Connection conn;
    private static String BDnombre;
    private final static String URL = "jdbc:sqlite:";
    
    /**
     * Is the constructor
     * @param BDnombre is the name of the database
     */
    
    public gestorDB1(String BDnombre)
    {
        gestorDB1.BDnombre = URL + BDnombre;

    }
    
    /**
     * Open database.db 
     *
     * @return the Connection object
     */
    public static Connection connect()
    {
        // SQLite connection string
        String name = "database.db";
        String url = "jdbc:sqlite:"+name;

        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    
    
    /**
   	 * It is used to create the connection with the database
   	 * @throws SQLException if it cannot be done, the exception sqlexception is thrown
   	 */
    public static void create() throws SQLException
    {
        try
        {
            conn = DriverManager.getConnection(BDnombre); 
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error creating connection. " + e.getMessage());
        }
    }
    
    /**
     * Used to close the connection
     * @throws SQLException if it cannot be done, the exception sqlexception is thrown
     */
    
    public static void close()throws SQLException{

        try{

            if(conn != null){

                conn.close();
            }
        }
        catch (SQLException ex){

            System.out.println("BadAss error closing connection" +ex.getMessage());

        }


    } 
    
    /**
     * Used to insert a car
     * @param id
     * @param marca
     * @param modelo
     * @param color
     * @param precio
     * @param kilometros
     * @throws SQLException
     */
    
    public static void insertCoche(int id, String marca, String modelo, String color, int precio, int kilometros) throws SQLException{
    	String sql = "INSERT INTO COCHE(id, marca, modelo, color, precio , kilometros) VALUES (?,?,?,?,?,?)";
    	
    	try {
    			
				Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, id);
				pstmt.setString(2, marca);
				pstmt.setString(3, modelo);
				pstmt.setString(4, color);
				pstmt.setInt(5, precio);
				pstmt.setInt(6, kilometros);
    	
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
		}
    }
    
    /**
     * Used to insert a motorbike
     * @param id
     * @param marca
     * @param modelo
     * @param color
     * @param precio
     * @param kilometros
     * @throws SQLException
     */
    public static void insertMoto(int id, String marca, String modelo, String color, int precio, int kilometros) throws SQLException{
    	String sql = "INSERT INTO MOTO(id, marca, modelo, color, precio , kilometros) VALUES (?,?,?,?,?,?)";
    	
    	try {
    		Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, marca);
			pstmt.setString(3, modelo);
			pstmt.setString(4, color);
			pstmt.setInt(5, precio);
			pstmt.setInt(6, kilometros);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
    
    /**
     * Used to insert a Client
     * @param id
     * @param nombre
     * @param apellido
     * @param edad
     * @param valorCompras
     * @throws SQLException
     */
    
    public static void insertCliente(int id, String nombre, String apellido, int edad, int valorCompras) throws SQLException{
    	String sql = "INSERT INTO CLIENTE(id, nombre, apellido, edad, valorCompras) VALUES (?,?,?,?,?)";
    	try{
    		Connection conn = connect();
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		
    		pstmt.setInt(1, id);
    		pstmt.setString(2, nombre);
    		pstmt.setString(3, nombre);
    		pstmt.setInt(4, edad);
    		pstmt.setInt(5, valorCompras);
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    }
    
/**
 * Used to insert a CarDealer
 * @param idConcesionario
 * @param nombre
 * @param ciudad
 * @param direccion
 * @param numeroTrabajadores
 */
    
    public static void insertConcesionario(int idConcesionario, String nombre, String ciudad,String direccion, int numeroTrabajadores){
    	String sql = "INSERT INTO CONCESIONARIO(idConcerionario, nombre, ciudad, direccion, numeroTrabajadores) VALUES (?,?,?,?,?)";
    	try {
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, idConcesionario);
			pstmt.setString(2, nombre);
			pstmt.setString(3, ciudad);
			pstmt.setString(4, direccion);
			pstmt.setInt(5, numeroTrabajadores);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
    /**
     * Is the class that returns the ArrayList with all the cars of the database.
     * @return all the cars of the database
     */
    
    public static ArrayList<Coche> selectAllCoches(){
    	ArrayList<Coche> listaCoches = new ArrayList<>();
    	String sql = "SELECT id, marca, modelo, color, precio , kilometros FROM COCHE";
    	try {
			Connection conn = connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Integer id = rs.getInt("id");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				String color = rs.getString("color");
				Integer precio = rs.getInt("precio");
				Integer kilometros = rs.getInt("kilometros");
				
				listaCoches.add(new Coche(id, marca, modelo, color, precio, kilometros));
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return listaCoches;
    }
    
    
    public static ArrayList<Coche> selectMasCaroCoches(){
    	ArrayList<Coche> listaCoches = new ArrayList<>();
    	String sql = "SELECT MAX(precio) FROM precio.COCHE";
    	try {
			Connection conn = connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Integer id = rs.getInt("id");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				String color = rs.getString("color");
				Integer precio = rs.getInt("precio");
				Integer kilometros = rs.getInt("kilometros");
				
				listaCoches.add(new Coche(id, marca, modelo, color, precio, kilometros));
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return listaCoches;
    }
    
    /**
     * Is the class that returns the ArrayList with all the motorbikes of the database.
     * @return all the motorbikes of the database
     */
    
    public static ArrayList<Moto> selectAllMotos(){
    	ArrayList<Moto> listaMotos = new ArrayList<>();
    	String sql = "SELECT id, marca, modelo, color, precio , kilometros FROM MOTO";
    	try {
			Connection conn = connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Integer id = rs.getInt("id");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				String color = rs.getString("color");
				Integer precio = rs.getInt("precio");
				Integer kilometros = rs.getInt("kilometros");

				listaMotos.add(new Moto(id, marca, modelo, color, precio, kilometros));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return listaMotos;
    }
    
    /**
     * Is the class that returns the ArrayList with all the clients of the database.
     * @return all the clients of the database
     */
    
    public static ArrayList<Cliente> selectAllCientes(){
    	ArrayList<Cliente> listaClientes = new ArrayList<>();
    	String sql = "SELECT id, nombre, apellido, edad, valorCompras FROM CLIENTE";
    	try {
			Connection conn = connect();
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Integer id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("nombre");
				Integer edad = rs.getInt("edad");
				Integer valorCompras = rs.getInt("valorCompras");
				
				listaClientes.add(new Cliente(id, nombre, apellido, edad, valorCompras));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return listaClientes;
    }
    /**
     * Is the class that returns the ArrayList with all the carDealers of the database.
     * @return all the carDealers of the database
     */
    
    public ArrayList<Concesionario> selectAllConcesionarios(){
    	ArrayList<Concesionario> listaConcesionarios = new ArrayList<>();
    	String sql = "SELECT idConcerionario, nombre, ciudad, direccion, numeroTrabajadores FROM CONCESIONARIO";
    	try {
			Connection conn = connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Integer idConcesionario = rs.getInt("idConcesionario");
				String nombre = rs.getString("nombre");
				String cuidad = rs.getString("cuidad");
				String direccion = rs.getString("direccion");
				Integer numeroTrabajadores = rs.getInt("numeroTrabajadores");
				
				listaConcesionarios.add(new Concesionario(idConcesionario, nombre, cuidad, direccion, numeroTrabajadores));
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return listaConcesionarios;
    }
    
    /**
     * Delete a Coche specified by the id
     *
     * @param id
     */
    public void deleteCoche(int id)
    {
        String sql = "DELETE FROM COCHE WHERE id = ?";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {

            // set the corresponding param
            pstmt.setInt(1, id);

            // execute the delete statement
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Delete a Moto specified by the id
     *
     * @param id
     */
    
    public void deleteMoto(int id)
    {
        String sql = "DELETE FROM MOTO WHERE id = ?";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {

            // set the corresponding param
            pstmt.setInt(1, id);

            // execute the delete statement
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    
    /**
     * Delete a Concesionario specified by the id
     *
     * @param id
     */
    
    public void deleteConcesionario(int id)
    {
        String sql = "DELETE FROM CONCESIONARIO WHERE id = ?";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {

            // set the corresponding param
            pstmt.setInt(1, id);

            // execute the delete statement
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
  
    }
    
    /**
     * Update data of a Coche specified by the id
     * @param id
     * @param marca
     * @param modelo
     * @param color
     * @param precio
     * @param kilometros
     */
    public void updateCoche(int id,String marca,String modelo,String color,int precio,int kilometros)
    {
        String sql = "UPDATE COCHE SET id = ? , marca = ? , modelo = ?,  color = ? , precio = ?, kilometros = ? WHERE id = ?";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            // set the corresponding param
            pstmt.setInt(1, id);
            pstmt.setString(2, marca);
            pstmt.setString(3, modelo);
            pstmt.setString(4, color);
            pstmt.setInt(5, precio);
            pstmt.setInt(6, kilometros);

            // update
            pstmt.executeUpdate();
            }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
	
    /**
     * Update data of a Moto specified by the id
     * @param id
     * @param marca
     * @param modelo
     * @param color
     * @param precio
     * @param kilometros
     */
    public void updateMoto(int id,String marca,String modelo,String color,int precio,int kilometros)
    {
        String sql = "UPDATE MOTO SET id = ? , marca = ? , modelo = ?, color = ? , precio = ?, kilometros = ? WHERE id = ?";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            // set the corresponding param
            pstmt.setInt(1, id);
            pstmt.setString(2, marca);
            pstmt.setString(3, modelo);
            pstmt.setString(4, color);
            pstmt.setInt(5, precio);
            pstmt.setInt(6, kilometros);

            // update
            pstmt.executeUpdate();
            }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Update data of a Coche specified by the id
     * @param id
     * @param marca
     * @param modelo
     * @param color
     * @param precio
     * @param kilometros
     */
    public void updateCliente(int id, String nombre, String apellido, int edad, int valorCompras)
    {
        String sql = "UPDATE COCHE SET id = ? , nombre = ? , apellido = ?,  edad = ? , valorCompras = ? WHERE id = ?";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            // set the corresponding param
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            pstmt.setInt(4, edad);
            pstmt.setInt(5, valorCompras);

            // update
            pstmt.executeUpdate();
            }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
	    
}
