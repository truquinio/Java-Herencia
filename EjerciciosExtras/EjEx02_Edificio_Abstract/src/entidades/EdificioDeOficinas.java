/*
Clase EdificioDeOficinas con sus atributos número de oficinas, cantidad de personas 
por oficina y número de pisos. Esta clase implementará los dos métodos abstractos y 
los atributos del padre.
*/

package entidades;

import java.util.Scanner;

/**
 *
 * @author FT
 */
public class EdificioDeOficinas extends Edificio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

///ATTR:
    private int numOficinas;
    private int cantidadPersonas;
    private int numPisos;

///CONSTR:
    public EdificioDeOficinas() {
    }

    public EdificioDeOficinas(int numOficinas, int cantidadPersonas, int numPisos, int ancho, int alto, int largo) {
        super(ancho, alto, largo);
        this.numOficinas = numOficinas;
        this.cantidadPersonas = cantidadPersonas;
        this.numPisos = numPisos;
    }

///G & S:
    public int getNumOficinas() {
        return numOficinas;
    }

    public void setNumOficinas(int numOficinas) {
        this.numOficinas = numOficinas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

///TO STRING:
    @Override
    public String toString() {
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        return "Edificio Of // N° Oficinas: " + numOficinas + " / N° personas x of.: " + cantidadPersonas + " / N° pisos: " + numPisos + "\n";
    }

///MÉTODOS ABSTRACTOS:    
    @Override
    public float calcularSuperficie() {

        int superficie = ancho * largo;

        return superficie;
    }

    @Override
    public float calcularVolumen() {

        int volumen = ancho * largo * alto * numPisos;

        return volumen;
    }

    /*
    De esta clase nos interesa saber cuántas personas pueden trabajar en todo el edificio, el
    usuario dirá cuántas personas entran en cada oficina, cuantas oficinas y el número de piso
    (suponiendo que en cada piso hay una oficina). Crear el método cantPersonas(), que muestre
    cuantas personas entrarían en un piso y cuantas en todo el edificio.
     */
    public void cantPersonas() {

        System.out.print("\nN° personas x oficina: ");
        int personasOficina = leer.nextInt();

        System.out.print("N° oficinas x piso: ");
        int cantOficinas = leer.nextInt();

        int cantPersonasPiso = personasOficina * cantOficinas;

        System.out.println("\nPersonas por piso: " + cantPersonasPiso + " ☺");

        int totalPersonas = cantPersonasPiso * numPisos;

        System.out.println("Total personas edificio: " + totalPersonas + " ☺");
    }
}
