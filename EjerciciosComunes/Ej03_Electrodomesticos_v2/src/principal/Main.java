/*
    Siguiendo el ejercicio anterior, en el main vamos a crear un ArrayList de Electrodomésticos 
para guardar 4 electrodomésticos, ya sean lavadoras o televisores, con valores ya asignados.
Luego, recorrer este array y ejecutar el método precioFinal() en cada electrodoméstico. Se 
deberá también mostrar el precio de cada tipo de objeto, es decir, el precio de todos los 
televisores y el de las lavadoras. Una vez hecho eso, también deberemos mostrar, la suma del 
precio de todos los Electrodomésticos. Por ejemplo, si tenemos una lavadora con un precio de 
2000 y un televisor de 5000, el resultado final será de 7000 (2000+5000) para 
electrodomésticos, 2000 para lavadora y 5000 para televisor.
 
*/
package principal;

import entidades.Electrodomestico;
import entidades.Lavadora;
import entidades.Televisor;
import java.util.ArrayList;

/**
 *
 * @author FT
 */
public class Main {

    public static void main(String[] args) {
        
      ArrayList<Electrodomestico> listaAparatos = new ArrayList<>();
        
        listaAparatos.add(new Lavadora(15, 1000d, "rojo", "B", 85d));
        
        listaAparatos.add(new Lavadora(45, 2000d, "negro", "A", 105d));
        
        listaAparatos.add(new Televisor(32, false, 5000d, "negro", "D", 8d)); 
        
        listaAparatos.add(new Televisor(55, true, 8000d, "blanco", "A", 10d));
        
        
        for (Electrodomestico mostrarAparatos : listaAparatos) {
            
            System.out.println(mostrarAparatos);
        }
        
        //Creo una VARIABLE AUXILIAR para realizar la suma.-
        double sumaPrecios = 0;
        
        for (Electrodomestico mostrarPrecios : listaAparatos) {
                      
            sumaPrecios = sumaPrecios + mostrarPrecios.precioFinal();
        }
        System.out.println("La suma de to2 los precios es: $" + sumaPrecios + "\n");
    }
}