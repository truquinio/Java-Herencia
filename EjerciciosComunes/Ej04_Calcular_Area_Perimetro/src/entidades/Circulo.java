/*
Se plantea desarrollar un programa que nos permita calcular el área y el perímetro de formas 
geométricas, en este caso un círculo y un rectángulo. 

Ya que este cálculo se va a repetir en las dos formas geométricas, vamos a crear una Interfaz, llamada calculosFormas que tendrá, los 
dos métodos para calcular el área, el perímetro y el valor de PI como constante. 

Desarrollar el ejercicio para que las formas implementen los métodos de la interfaz y se 
calcule el área y el perímetro de los dos. En el main se crearán las formas y se mostrará el 
resultado final.

Área circulo: PI * radio ^ 2 / Perímetro circulo: PI * diámetro.
Área rectángulo: base * altura / Perímetro rectángulo: (base + altura) * 2.
 */
package entidades;

import calculos.calculosFormas;
import java.util.Scanner;

/**
 *
 * @author FT
 */

//Uso la palabra reservada IMPLEMENTS para relacionar las INTERFACES e IMPORTO los MÉTODOS ABSTRACTOS.-
public class Circulo implements calculosFormas{
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

///ATTR:    
    private double radio;
    private final double PI = 3.141592;
    
///CONSTR:
    public Circulo() {
    }
    public Circulo(double radio) {
        this.radio = radio;
    }

///SOBREESCRIBO los MÉTODOS ABSTRACTOS.-
    @Override
    public void calcularArea() {
        
        System.out.println("Ingrese el radio del ○:");
        radio = leer.nextDouble();
        
        System.out.println("\nÁrea del ○: " + (PI * radio * radio));
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perímetro del ○: " + (PI * radio * 2) + "\n");
    }
    
    
}
