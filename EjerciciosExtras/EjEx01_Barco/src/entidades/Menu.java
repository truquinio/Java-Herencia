/*
En un puerto se alquilan arrayAmarres para barcos de distinto tipo. Para cada Alquiler se guarda: el 
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

import Enum.MenuPrincipal;
import entidades.Amarre;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import servicio.Utilidades;

/**
 *
 * @author FT
 */
public class Menu {

    private static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    //Creo el ARRAY de AMARRES.-
    private static ArrayList<Amarre> arrayAmarres = new ArrayList<Amarre>();

    public static void ejecutar(int n_arrayAmarres) {
        
        for (int i = 0; i < n_arrayAmarres; i++)
            
            arrayAmarres.add(new Amarre(i));

        int opcionMenu;
        
        //amarresDisponibles();
        
        do {
            opcionMenu = MenuPrincipal.elegirOpcion();
            switch (opcionMenu) {
                case 0:
                    return;
                    
                case 1:
                    agregarAlquiler();
                    break;
                    
                case 2:
                    eliminarAlquiler();
                    break;
                    
                case 3:
                    mostrarAlquileres();
                    break;
                    
                default:
                    Utilidades.validarOpcion();
                    break;
            }
        } while (opcionMenu != 0);
    }

    private static boolean verificarLleno() {
        for (Amarre amarre_aux : arrayAmarres) {
            
            if (Objects.isNull(amarre_aux.getAlquiler()))
                
                return false;
        }
        return true;
    }

    private static void amarresDisponibles(){
        
        System.out.println("\nAmarres disponibles:");
        arrayAmarres.stream()
                .filter(comparaAmarre -> Objects.isNull(comparaAmarre.getAlquiler()))
                .forEach(recorreUbicaciones -> System.out.print("[" + recorreUbicaciones.ubicacion + "]  "));
        System.out.println();
        
    }
    
///AGREGAR ALQUILER:
    private static void agregarAlquiler() {
        if (verificarLleno()) {
            System.out.println("\nPuerto lleno.\n");
            return;
        }

        System.out.println("\nAmarres disponibles:");
        arrayAmarres.stream()
        .filter(comparaAmarre -> Objects.isNull(comparaAmarre.getAlquiler()))
        .forEach(recorreUbicaciones -> System.out.print("[" + recorreUbicaciones.ubicacion + "]  "));
        System.out.println();

        System.out.print("\nElija un amarre: ");
        int posicionAmarre = leer.nextInt();

        arrayAmarres.get(posicionAmarre).setAlquiler(Alquiler.crearAlquiler(posicionAmarre));
    }

    private static void mostrarAlquileres() {
        arrayAmarres.stream().forEach(x -> System.out.println(x));
        //Utilidades.presionarEnter();
    }

    private static void eliminarAlquiler() {
        
        System.out.println("Amarres ocupados:");
        
        arrayAmarres.stream()
                .filter(comparaAmarre -> !Objects.isNull(comparaAmarre.getAlquiler()))
                .forEach(System.out::println);

        System.out.println("Amarre a eliminar: (-1 Cancela)");
        
        int posicion = leer.nextInt();
        
        if (posicion == -1)
            return;

        arrayAmarres.stream()
                .filter(comparaAmarre -> comparaAmarre.getUbicacion() == posicion)
                .forEach(recorreDesocupado -> recorreDesocupado.desalojarAmarre());
    }
}