/*
En un puerto se alquilan amarres para barcos de distinto tipo. Para cada Alquiler se guarda: el 
nombre, documento del cliente, la fecha de alquiler, fecha de devolución, la posición del 
amarre y el barco que lo ocupará.

Un Barco se caracteriza por: su matrícula, su eslora en metros y año de fabricación.
Sin embargo, se pretende diferenciar la información de algunos tipos de barcos especiales:

•  Número de mástiles para veleros.
•  Potencia en CV para barcos a motor.
•  Potencia en CV y número de camarotes para yates de lujo.

Un alquiler se calcula multiplicando el número de días de ocupación (calculado con la fecha de 
alquiler y devolución), por un valor módulo de cada barco (obtenido simplemente 
multiplicando por 10 los metros de eslora).

En los barcos de tipo especial el módulo de cada barco se calcula sacando el módulo normal y 
sumándole el atributo particular de cada barco. En los veleros se suma el número de mástiles, 
en los barcos a motor se le suma la potencia en CV y en los yates se suma la potencia en CV y 
el número de camarotes.

Utilizando la herencia de forma apropiada, deberemos programar en Java, las clases y los 
métodos necesarios que permitan al usuario elegir el barco que quiera alquilar y mostrarle el 
precio final de su alquiler.
 */
package entidades;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author FT
 */
public class Amarre {

///ATTR:    
    public int ubicacion;
    private Integer precio;
    private Alquiler alquiler;

//CONSTR:
    public Amarre() {
    }
    public Amarre(int ubicacion) {
        this.ubicacion = ubicacion;
    }
    public Amarre(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

///G & S:
    public int getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public Alquiler getAlquiler() {
        return alquiler;
    }
    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
        
        int modulo = (int) this.alquiler.getBarco().calcularModulo();
        
        //Traigo las FECHAS INICIO y FIN en MILISEGUNDOS (getTimeInMillis) y las resto para obtener la DIFERENCIA.-
        long milisegundos = this.alquiler.getFecha_fin().getTimeInMillis() - this.alquiler.getFecha_inicio().getTimeInMillis();
        
        //Paso MILISEGUNDOS(TimeUnit.MILLISECONDS) a DÍAS(toDays) y los guardo en variable DIAS.-
        int dias = (int) TimeUnit.MILLISECONDS.toDays(milisegundos);
        
        this.precio = modulo * dias;
    }

///TO STRING:
    @Override
    public String toString() {
        return "Ubicación: " + ubicacion + " / Precio: $" + precio + " / Alquiler: " + alquiler;
    }
    
///DESALOJAR AMARRE:
    public void desalojarAmarre() {
        this.precio = null;
        this.alquiler = null;
    }
}