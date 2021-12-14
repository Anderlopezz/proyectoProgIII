package clases;

import java.util.ArrayList;
import java.util.Collections;

import utils.I_Comparable;

/**
 * 
 * @author Alumno
 * @version 1.0
 */

public class Cliente implements I_Comparable<Cliente>
{
	/** El nombre del Usuario
	 */
	private String nombre;
	/**El apellido del usuario
	 */
	private String apellido;
	/**La edad del usuario
	 */
	private int edad;
	private int id;
	private int valorCompras;
	
	ArrayList<Cliente> clientes;
	
	/**
	 * Rellena todos los parametros de la clase Cliente
	 * @param nombre
	 * @param apellido
	 * @param edad
	 */
	
	public Cliente(){
		this.clientes= new ArrayList<>();
	}
	
	public Cliente(int id) {
		super();
		this.id=id;
	}
	
	public Cliente(int id, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.id=id;
	}
	public Cliente(int id, int edad, int valorCompras) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.id=id;
		this.valorCompras= valorCompras;
	}
	
	public Cliente(int id, String nombre, String apellido, int edad, int valorCompras ) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.valorCompras= valorCompras;
	}
	
	/**
	 * Devuelve el nombre del Cliente
	 * @return Un String con el nombre de Cliente
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve el apellido del Cliente
	 * @return Un String con el apellido de Cliente
	 */

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * Devuelve la edad del Cliente
	 * @return Un Integer con la edad del Cliente
	 */
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getValorCompras() {
		return valorCompras;
	}

	public void setValorCompras(int valorCompras) {
		this.valorCompras = valorCompras;
	}
	
	public ArrayList<Cliente> getClientes(){
		return clientes;
	}
	
	public void setClientes(ArrayList<Cliente> clientes){
		this.clientes=clientes;
	}
	
	
	
	@Override
	public String toString() {
		return id+ ".- " + nombre ;
	}

	/**
	 * 
	 * @param a
	 * @return Si el id es el mismo 
	 */
	
	public boolean compareTo(Object a){
		Cliente c = (Cliente) a;
		if(this.id == (c.id)){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * 
	 * @param c
	 * @return Si existe el cliente que se añada o no
	 */
	
	public boolean existeCliente(Cliente c){
		for (int i = 0; i < clientes.size(); i++) {
			if(c.compareTo(clientes.get(i))){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param c
	 * @return Añade un cliente a la db
	 */
	public void anyadirCliente(Cliente c){
		if(existeCliente(c)){
			System.out.println("Este cliente ya se encuentra en la DataBase");
		}
		else{
			// gestorBD.anyadirCliente(c)
			clientes.add(c);
		}
	}
	/**
	 * @return Me delvuelve la lista de clientes
	 */
	
	public void listarClientes(){
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
	/**
	 * @author Ander Lopez
	 * @param id
	 */
	
	public void buscarCliente(int id){
		boolean encontrado = false;
		for (int i = 0; i < clientes.size(); i++) {
			if(id == (clientes).get(i).getId()){
				System.out.println("Cliente encontrado: Id="+ id);
				encontrado = true;
			}
			else{
				System.out.println("No existes este cliente: Id="+ id);
			}
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return  elimina el cliente seleccionado.
	 */

	public void eliminarCliente(int id){
		boolean encontrado= false;
		for (int i = 0; i < clientes.size(); i++) {
			if(id == clientes.get(i).getId()){
				clientes.remove(i);
			}
			else{
				System.out.println("No encuentra el cliente");
			}
		}
	}
	
	public int mejorCliente(){
		int max = 0;
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getValorCompras() > max){
				max= clientes.get(i).getValorCompras();
			}
		}
		return max;
	}

	@Override
	public boolean compareNum(Cliente o) {
		// TODO Auto-generated method stub
		if(this.getId() <  o.getId()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean compareStr(Cliente o) {
		// TODO Auto-generated method stub
		if(this.getNombre().charAt(0) < o.getNombre().charAt(0)) {
			return true;
		}else {
			return false;
		}
	}


	
}
