package clases;

import java.util.ArrayList;

public class Moto extends Vehiculo
{

	public Moto(int id, String marca, String modelo, String color, int precio, int kilometros) {
		super(id, marca, modelo, color, precio, kilometros);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return this.getMarca()+" "+ this.getModelo()+ " " + this.getPrecio();
	}
	
	ArrayList<Moto> motos;
	
	

}
