package utils;

import java.util.ArrayList;

public class Recursividad 
{
	 public static ArrayList<Integer> BubbleSort(ArrayList<Integer> data) {

		    ArrayList<Integer> result = data; //Resultado

		    boolean swaped = true; //Variable en caso de que no haya intercambio 
		    int i = 0;
		    int j = 0;

		    while (swaped) {

		        swaped = false;
		        i++;

		        while (j < result.size() - i - 1) {

		            //obtenemos los valores
		            Integer pos = result.get(j);

		            Integer next = result.get(j + 1);

		            //si la pos es mayor que el siguiente intercambia
		            if (pos > next) {

		                result.set(j, next);

		                result.set(j + 1, pos);

		               // swaped = true;
		            }

		            System.out.println(result);
		            j++;

		        }

		    }
		    return result;

		}
}
