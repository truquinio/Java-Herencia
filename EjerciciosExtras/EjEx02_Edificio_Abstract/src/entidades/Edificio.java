/*
Crear una superclase llamada Edificio con los siguientes atributos: ancho, alto y largo. La clase 
edificio tendrá como métodos:

•  Método calcularSuperficie(): calcula la superficie del edificio.
•  Método calcularVolumen(): calcula el volumen del edifico. 

Estos métodos serán abstractos y los implementarán las siguientes clases: 
Clase Polideportivo y Clase EdificioDeOficinas.-
 */

package entidades;

/**
 *
 * @author FT
 */

//Si vamos a usar ATRIBUTOS, SI o SI debemos usar una CLASE ABSTRACTA.-
public abstract class Edificio {
    
//ATTR:
    protected int ancho;
    protected int alto;
    protected int largo;
    
//CONSTR:
    public Edificio() {
    }
    public Edificio(int ancho, int alto, int largo) {
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
    }

///G & S:
    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public int getAlto() {
        return alto;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }
    public int getLargo() {
        return largo;
    }
    public void setLargo(int largo) {
        this.largo = largo;
    }
    
///MÉTODOS ABSTRACTOS:
public abstract float calcularSuperficie();

public abstract float calcularVolumen();
}