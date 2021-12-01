package clases;

import java.util.ArrayList;

public class Coche extends Vehiculo
{

	ArrayList<Coche> coches = new ArrayList<>();
	
	public Coche(int id, String marca, String modelo, String color, int precio, int kilometros) {
		super(id, marca, modelo, color, precio, kilometros);
		// TODO Auto-generated constructor stub
	}
	
	public void anyadirCoches(Coche c){
		coches.add(c);
	}
	
	public void buscarCoche(int id){
		boolean encontrado = false;
		for (int i = 0; i < coches.size(); i++) {
			if(id == coches.get(i).getId()){
				encontrado = true;
				System.out.println("Coche encontrado");
			}else{
				System.out.println("No se encuentra ningun coche con este ID");
			}
		}
	}
	
	public void eliminarCoche(int id){
		for (int i = 0; i < coches.size(); i++) {
			if(id == coches.get(i).getId()){
				coches.remove(i);
			}else{
				System.out.println("No existe este vehiculo con este ID");
			}
		}
	}
	
	public int cocheMasCaro(){
		int max = 0; 
		for (int i = 0; i < coches.size(); i++) {
			if(coches.get(i).getPrecio() > max){
				max = coches.get(i).getPrecio();
			}
		}
		return max;
	}
	/*
	public String buscarMarca(){
		String nombre = "";
		for (int i = 0; i < coches.size(); i++) {
			if()
		}
	}
	*/
	
}
