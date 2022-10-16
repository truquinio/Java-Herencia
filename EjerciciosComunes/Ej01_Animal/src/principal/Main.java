/*
Tenemos una clase padre Animal junto con sus 3 clases hijas Perro, Gato, Caballo. 
La clase Animal tendrá como atributos el nombre, alimento, edad y raza del Animal.
Crear un método en la clase Animal a través del cual cada clase hija deberá mostrar luego un 
mensaje por pantalla informando de que se alimenta.
 */
package principal;

import entidades.Animal;
import entidades.Caballo;
import entidades.Gato;
import entidades.Perro;

/**
 *
 * @author FT
 */
public class Main {

    public static void main(String[] args) {
        
        Animal caballo = new Caballo("Fernando", "Pasto", 5, "Pura Sangre");
        
        caballo.alimentarse();
        
        Animal perro1 = new Perro("Lalo", "Carne", 3, "Caniche");
        
        perro1.alimentarse();
                
        Animal gato = new Gato("Chiquito", "Balanceado", 2, "Persa");
        
        gato.alimentarse();

        System.out.println("");
    }
}