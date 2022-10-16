/*
Clase Polideportivo con su nombre y tipo de instalación que puede ser Techado o 
Abierto, esta clase implementará los dos métodos abstractos y los atributos del padre.

Además de esto, para la clase Polideportivo nos interesa saber cuántos polideportivos son 
techados y cuantos abiertos. Y para la clase EdificioDeOficinas deberemos llamar al método 
cantPersonas() y mostrar los resultados de cada edificio de oficinas.
 */
package entidades;

/**
 *
 * @author FT
 */
public class Polideportivo extends Edificio {

///ATTR:
    private String nombre;
    private Boolean techado;

///CONSTR:
    public Polideportivo() {
    }

    public Polideportivo(String nombre, Boolean techado, int ancho, int alto, int largo) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.techado = techado;
    }
    

///G & S:
    public String getNombre() {    
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Boolean getTechado() {
        return techado;
    }
    public void setTechado(Boolean techado) {    
        this.techado = techado;
    }

///TO STRING:
    @Override
    public String toString() {
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

        System.out.println("Ancho: " + ancho + "mts.");
        System.out.println("Alto: " + alto + "mts.");
        System.out.println("Largo: " + largo + "mts.\n");

        return "Polideportivo // Nombre: " + nombre + " / Techado: " + techado + "\n";
    }

///MÉTODOS ABSTRACTOS:
    @Override
    public float calcularSuperficie() {

        float superficie = ancho * largo;

        //System.out.println("\nSuperficie Poli: " + superficie + " mts²");
        return superficie;
    }

    @Override
    public float calcularVolumen() {

        float volumen = ancho * largo * alto;

        //System.out.println("Volumen Poli: " + volumen + " mts³");
        return volumen;
    }

///CALCULAR TECHADO:
   //public boolean poliTechado() {
    //    return techado;
    //}
}