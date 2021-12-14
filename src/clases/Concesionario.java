package clases;

import java.util.ArrayList;

import utils.I_Comparable;

public class Concesionario implements I_Comparable<Concesionario>
{
	private int idConcesionario;
	private String nombre;
	private String ciudad;
	private String direccion;
	private int numeroTrabajadores;
	
	ArrayList<Concesionario> concesionarios = new ArrayList<>();
	
	public Concesionario(){
		
	}
	
	public Concesionario(int idConcesionario, String nombre, String ciudad, String direccion){
		this.idConcesionario= idConcesionario;
		this.nombre=nombre;
		this.ciudad=ciudad;
		this.direccion=direccion;
	}
	
	public Concesionario(int idConcesionario, String nombre, String ciudad,String direccion, int numeroTrabajadores){
		this.idConcesionario= idConcesionario;
		this.nombre=nombre;
		this.direccion=direccion;
		this.ciudad=ciudad;
		this.numeroTrabajadores=numeroTrabajadores;
	}
	
	public int getIdConcesionario() {
		return idConcesionario;
	}

	public void setIdConcesionario(int idConcesionario) {
		this.idConcesionario = idConcesionario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCiudad(){
		return ciudad;
	}
	
	public void setCiudad(String ciudad){
		this.ciudad=ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNumeroTrabajadores() {
		return numeroTrabajadores;
	}

	public void setNumeroTrabajadores(int numeroTrabajadores) {
		this.numeroTrabajadores = numeroTrabajadores;
	}
	
	public void anyadirConcesionario(Concesionario c){
		concesionarios.add(c);
	}
	
	@Override
	public String toString() {
		return idConcesionario+ ".- " + nombre ;
	}
	
	public void buscarConcesionario(int id){
		boolean encontrado = false;
		for (int i = 0; i < concesionarios.size(); i++) {
			if(id == (concesionarios).get(i).getIdConcesionario()){
				encontrado = true;
				System.out.println("Concesionario encontrado");
			}else{
				System.out.println("Alerta: No existe el concesionario" + id);
			}
				
		}
	}
	
	public void eliminarConcesionario(int id){
		//boolean encontrado = false;
		for (int i = 0; i < concesionarios.size(); i++) {
			if(id == concesionarios.get(i).getIdConcesionario()){
				concesionarios.remove(i);
			}else{
				System.out.println("No se encuentra el concesionario a eliminar");
			}
		}	
	}



	@Override
	public boolean compareNum(Concesionario o) {
		// TODO Auto-generated method stub
		if(this.getIdConcesionario() <  o.getIdConcesionario()) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean compareStr(Concesionario o) {
		// TODO Auto-generated method stub
		if(this.getNombre().charAt(0) < o.getNombre().charAt(0)) {
			return true;
		}
		return false;
	}
	
	
	
	
}
