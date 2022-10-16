/*
En el main vamos a crear un ArrayList de tipo Edificio. El ArrayList debe contener 
dos polideportivos y dos edificios de oficinas. Luego, recorrer este array y ejecutar los 
métodos calcularSuperficie y calcularVolumen en cada Edificio. Se deberá mostrar la 
superficie y el volumen de cada edificio.

Además de esto, para la clase Polideportivo nos interesa saber cuántos polideportivos son 
techadohados y cuantos abiertoertos. Y para la clase EdificioDeOficinas deberemos llamar al método 
cantPersonas() y mostrar los resultados de cada edificio de oficinas.
 */
package principal;

import entidades.Edificio;
import entidades.EdificioDeOficinas;
import entidades.Polideportivo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FT
 */
public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        ArrayList<Edificio> arrayEdificio = new ArrayList<>();

///FORMA 1: AGREGO(add) al ARRAY un NUEVO OBJETO(new).-
        arrayEdificio.add(new Polideportivo("Poli A", true, 10, 20, 3));
        arrayEdificio.add(new Polideportivo("Poli B", false, 15, 30, 2));
        arrayEdificio.add(new Polideportivo("Poli C", true, 20, 50, 3));

        //EdificioDeOficinas(N° ofic., N° ☺ x ofic., N° pisos, ancho, alto, largo).-
        arrayEdificio.add(new EdificioDeOficinas(40, 7, 10, 10, 30, 20));
        arrayEdificio.add(new EdificioDeOficinas(30, 5, 9, 8, 18, 10));

///MOSTRAR ARRAYS:

        int techado = 0;
        int abierto = 0;

        //Recorro con FOREACH el ARRAY de EDIFICIOS.-
        for (Edificio edificioForEach : arrayEdificio) {

            System.out.println(edificioForEach);

            System.out.println("Superficie: " + edificioForEach.calcularSuperficie() + " mts²");

            System.out.println("Volumen: " + edificioForEach.calcularVolumen() + " mts³\n");

    ///CALCULAR polideportivos TECHADOS:  
            //Al AUXILIAR del FOREACH lo INSTANCIO DE(instanceof) la clase POLIDEPORTIVO.-
            if (edificioForEach instanceof Polideportivo) {

                //Creo el OBJETO POLI que es = a POLIDEPORTIVO.-
                Polideportivo objetoPoli = (Polideportivo) edificioForEach;

                //Al OBJETO POLI, le traigo el attr TECHADO.-
                if (objetoPoli.getTechado()) {
                    
                    //Si TECHADO es TRUE, INCREMENTRO +1 la var TECHADO.-
                    techado++;

                } else {
                    
                    //Si no, INCREMENTO +1 la var ABIERTO.-
                    abierto++;
                }
            }
        }
        
        System.out.println("\nPoli techados: " + techado);
        System.out.println("Poli descubiertos: " + abierto + "\n");

        //Recorro con FOREACH el ARRAY de EDIFICIOS.-
        for (Edificio edificioForEach2 : arrayEdificio) {

            //Al AUXILIAR del FOREACH lo INSTANCIO DE(instanceof) la clase EDIFICIO de OFICINAS.-
            if (edificioForEach2 instanceof EdificioDeOficinas) {

                //Declaro el OBJETO EDIFICIO y lo igualo al listado EDIFICIO FOREACH.-
                EdificioDeOficinas objetoEdificio = (EdificioDeOficinas) edificioForEach2;

                objetoEdificio.cantPersonas();
            }
        }
    }
}

/*
FORMA 2: INSTANCIO el OBJETO(new) y lo AGREGO(add) al ARRAY.-
        Polideportivo poli1 = new Polideportivo();
        arrayEdificio.add(poli1);

        Polideportivo poli2 = new Polideportivo();
        arrayEdificio.add(poli2);

        EdificioDeOficinas building1 = new EdificioDeOficinas();
        arrayEdificio.add(building1);

        EdificioDeOficinas building2 = new EdificioDeOficinas();
        arrayEdificio.add(building2);
         */
