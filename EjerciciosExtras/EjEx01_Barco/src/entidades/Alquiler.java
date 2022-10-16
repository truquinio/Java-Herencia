/*
Para cada Alquiler se guarda: el nombre, documento del cliente, la fecha de alquiler, fecha de devolución, la posición del 
amarre y el barco que lo ocupará.

Un alquiler se calcula multiplicando el número de días de ocupación (calculado con la fecha de 
alquiler y devolución), por un valor módulo de cada barco (obtenido simplemente 
multiplicando por 10 los metros de eslora).

Utilizando la herencia de forma apropiada, deberemos programar en Java, las clases y los 
métodos necesarios que permitan al usuario elegir el barco que quiera alquilar y mostrarle el 
precio final de su alquiler.
 */
package entidades;

import static entidades.Barco.crearBarco;
import java.util.Calendar;
import java.util.Scanner;
import servicio.Utilidades;

/**
 *
 * @author FT
 */
public class Alquiler {

    private static final Scanner leer = new Scanner(System.in).useDelimiter("\n");

///ATTR:    
    private String nombre;
    private int documento;
    private Calendar fechaAlquiler;
    private Calendar fechaDevolucion;
    private int posicionAmarre;
    private Barco barco;

///CONSTR:
    public Alquiler() {
    }

    public Alquiler(String nombre, int documento, Calendar fechaAlquiler, Calendar fechaDevolucion, int posicionAmarre, Barco barco) {
        this.nombre = nombre;
        this.documento = documento;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
    }

///G & S:
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDocumento() {
        return this.documento;
    }
    public void setDocumento(int documento) {
        this.documento = documento;
    }
    public Calendar getFecha_inicio() {
        return this.fechaAlquiler;
    }
    public void setFecha_inicio(Calendar fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }
    public Calendar getFecha_fin() {
        return this.fechaDevolucion;
    }
    public void setFecha_fin(Calendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public int getPosición_amarre() {
        return this.posicionAmarre;
    }
    public void setPosición_amarre(int posicionAmarre) {
        this.posicionAmarre = posicionAmarre;
    }
    public Barco getBarco() {
        return this.barco;
    }
    public void setBarco(Barco barco) {
        this.barco = barco;
    }

///TO STRING:
    @Override
    public String toString() {
        return "// Nombre cliente: " + nombre + " / DNI: " + documento + " / Fecha Alquiler: " + fechaAlquiler.getTime() + " / Fecha devolución: " + fechaDevolucion.getTime() + " / Amarre n°: " + posicionAmarre + " // Tipo de barco: " + barco;
    }

///CREAR ALQUILER:
    public static Alquiler crearAlquiler(int posicion) {

        System.out.print("\nNombre cliente: ");
        String nombre = leer.nextLine();

        System.out.print(("DNI cliente: "));
        int dni = leer.nextInt();

        System.out.print("\nFecha de alquiler (dd-mm-yy): ");
        Calendar fechaAlquiler = Utilidades.StringToCalendar(leer.next(), "dd-MM-yy");
        

        System.out.print("Fecha de devolución (dd-MM-yy): ");
        Calendar fechaDevolucion = Utilidades.StringToCalendar(leer.next(), "dd-mm-yy");
        
        Barco ship = crearBarco();

        return new Alquiler(nombre, dni, fechaAlquiler, fechaDevolucion, posicion, ship);
    }
}