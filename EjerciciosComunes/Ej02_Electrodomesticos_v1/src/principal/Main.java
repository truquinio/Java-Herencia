/*
Finalmente, en el main debemos realizar lo siguiente:
Vamos a crear una Lavadora y un Televisor y llamar a los métodos necesarios para mostrar 
el precio final de los dos electrodomésticos. 
 */
package principal;

import entidad.Electrodomestico;
import entidad.Lavadora;
import entidad.Televisor;

/**
 *
 * @author FT
 */
public class Main {

    public static void main(String[] args) {

        Electrodomestico aparato = new Electrodomestico();

        //Electrodomestico lavarropa = new Lavadora();
        Lavadora lavarropa = new Lavadora();

        //Llamo el método de la Lavadora porque instancio el objeto Lavadora.-
        lavarropa.crearLavadora();

        //GET CLASS: Trae la clase (Para no sobreescribir el método en todas las clases).-
        //GET SIMPLE NAME: Convierte el nombre de la clase en String y lo muestra con el SOUT.-
        System.out.println(lavarropa.getClass().getSimpleName());

        lavarropa.precioFinal();

        System.out.println(lavarropa);

        System.out.println("\n- - - - - - - - - - - - - - - - - - -\n");

        Televisor TV = new Televisor();

        TV.crearTelevisor();

        TV.precioFinal();

        System.out.println(TV);
    }
}