/*
Crear una superclase llamada Edificio con los siguientes atributos: ancho, alto y largo. La clase 
edificio tendrá como métodos:

•  Método calcularSuperficie(): calcula la superficie del edificio.
•  Método calcularVolumen(): calcula el volumen del edifico. 

Estos métodos serán abstractos y los implementarán las siguientes clases: 

•  Clase Polideportivo con su nombre y tipo de instalación que puede ser Techado o 
Abierto, esta clase implementará los dos métodos abstractos y los atributos del padre.

• Clase EdificioDeOficinas con sus atributos número de oficinas, cantidad de personas 
por oficina y número de pisos. Esta clase implementará los dos métodos abstractos y 
los atributos del padre. 

De esta clase nos interesa saber cuántas personas pueden trabajar en todo el edificio, el 
usuario dirá cuántas personas entran en cada oficina, cuantas oficinas y el número de piso 
(suponiendo que en cada piso hay una oficina). Crear el método cantPersonas(), que muestre 
cuantas personas entrarían en un piso y cuantas en todo el edificio.

Por último, en el main vamos a crear un ArrayList de tipo Edificio. El ArrayList debe contener 
dos polideportivos y dos edificios de oficinas. Luego, recorrer este array y ejecutar los 
métodos calcularSuperficie y calcularVolumen en cada Edificio. Se deberá mostrar la 
superficie y el volumen de cada edificio.

Además de esto, para la clase Polideportivo nos interesa saber cuántos polideportivos son 
techados y cuantos abiertos. Y para la clase EdificioDeOficinas deberemos llamar al método 
cantPersonas() y mostrar los resultados de cada edificio de oficinas.
 */
package service;

import entidades.Edificio;
import entidades.EdificioDeOficinas;
import entidades.Polideportivo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FT
 */
public class Servicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    ArrayList<Edificio> arrayEdificio = new ArrayList<>();

    public void crearEdificios() {
        //FORMA 1: Recorro con FOREACH, AGREGO(add) al ARRAY un NUEVO OBJETO(new).-
        for (Edificio edificioForEach : arrayEdificio) {

            arrayEdificio.add(new Polideportivo("Poli1", true, 10, 20, 3));
            arrayEdificio.add(new Polideportivo("Poli2", false, 10, 20, 3));

            arrayEdificio.add(new EdificioDeOficinas(20, 5, 21, 10, 3, 15));
            arrayEdificio.add(new EdificioDeOficinas(10, 3, 11, 5, 2, 8));
        }

        //FORMA 2: Recorro con FOREACH, INSTANCIO el OBJETO(new) y AGREGO(add) al ARRAY.-
        for (Edificio edificioForEach : arrayEdificio) {

            Polideportivo poli1 = new Polideportivo();
            arrayEdificio.add(edificioForEach);

            Polideportivo poli2 = new Polideportivo();
            arrayEdificio.add(edificioForEach);

            EdificioDeOficinas building1 = new EdificioDeOficinas();
            arrayEdificio.add(edificioForEach);

            EdificioDeOficinas building2 = new EdificioDeOficinas();
            arrayEdificio.add(edificioForEach);

            System.out.println("POLI:");

            Polideportivo sportsCenter = new Polideportivo();

            System.out.print("Nombre: ");
            sportsCenter.setNombre(leer.next());

            System.out.println("Techado: ");
            sportsCenter.setTechado(Boolean.TRUE);

            System.out.print("Ancho: ");
            sportsCenter.setAncho(leer.nextInt());

            System.out.print("Largo: ");
            sportsCenter.setLargo(leer.nextInt());

            System.out.print("Alto: ");
            sportsCenter.setAlto(leer.nextInt());

            sportsCenter.calcularSuperficie();

            sportsCenter.calcularVolumen();

            System.out.println(sportsCenter.toString());

            ///////////////////////////////////////////////////////////////////////
            System.out.println("\nEDIFICIO OFICINAS:");

            EdificioDeOficinas building = new EdificioDeOficinas();

            System.out.print("Ancho: ");
            building.setAncho(leer.nextInt());

            System.out.print("Largo: ");
            building.setLargo(leer.nextInt());

            System.out.print("Alto: ");
            building.setAlto(leer.nextInt());

            System.out.println("\nCant. pisos:");
            building.setNumPisos(leer.nextInt());

            System.out.println("Oficinas x piso:");
            building.setNumOficinas(leer.nextInt());

            building.calcularSuperficie();

            building.calcularVolumen();

            building.cantPersonas();

            System.out.println(building.toString());

        }
    }
}
