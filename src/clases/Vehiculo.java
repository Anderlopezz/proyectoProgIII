package clases;

import java.util.ArrayList;

import utils.I_Comparable;

/**
 * @author Ander Lopez
 * @version 1.0
 */

public class Vehiculo implements I_Comparable<Vehiculo>
{
	
	private int id;	
	/**
	 * Marca de vehiculo
	 */
	private String marca;
	/**
	 * Modelo del vehiculo
	 */
	private String modelo;
	/**
	 * El color del vehiculo
	 */
	private String color;
	private int precio;
	private int kilometros;
	
	ArrayList<Vehiculo> vehiculos;
	
	public Vehiculo(int id, String marca, String modelo, String color, int precio,
			int kilometros) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
		this.kilometros = kilometros;
		this.vehiculos= new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}
	
	public ArrayList<Vehiculo> getVehiculo() {
		return vehiculos;
	}

	public void setContactos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public boolean compareNum(Vehiculo o) {
		// TODO Auto-generated method stub
		if(this.getPrecio() >  o.getPrecio()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	@Override
	public boolean compareKm(Vehiculo o) {
		// TODO Auto-generated method stub
		if(this.getKilometros() >  o.getKilometros()) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean compareStr(Vehiculo o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	//METODO COMPARE TO

}
