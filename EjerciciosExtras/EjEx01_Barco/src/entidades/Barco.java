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

import java.util.Scanner;

/**
 *
 * @author FT
 */
class Barco {
    
    
    
///ATTR:
    public String matricula;
    public int eslora;
    private int anioFabricacion;
    private Alquiler alquiler;
    
    
///CONSTR:
    public Barco() {
    }
    public Barco(String matricula, int eslora, int anioFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
    }
    
///G & S:
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public double getEslora() {
        return eslora;
    }
    public void setEslora(int eslora) {
        this.eslora = eslora;
    }
    public int getAnioFabricacion() {
        return anioFabricacion;
    }
    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
    
///TO STRING:
    @Override
    public String toString() {
        //Llamo al método TO STRING mediante un SUPER, porque viene heredado de la clase PADRE.-
        return "Datos de embarcación // Matrícula: " + matricula + " / Eslora: " + eslora + " mts. / Año fabricación: " + anioFabricacion;
    }

//VALOR MÓDULO: valor módulo de cada barco, multiplicando por 10 los metros de eslora.-
    public double calcularModulo() {      
        return (this.eslora * 10);
    }    
    
///CREAR BARCO:
    public static Barco crearBarco() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("\nElija embarcación:");
        System.out.println("1. Velero");
        System.out.println("2. Barco a motor");
        System.out.println("3. Yate de lujo");

        int opcion = leer.nextInt();

        System.out.print("\nMatrícula: ");
        String matricula = leer.next();

        System.out.print("Mts de Eslora: ");
        int eslora = leer.nextInt();

        System.out.print("Año de fabricación: ");
        int anioFabr = leer.nextInt();

        Barco barco = new Barco();

        switch (opcion) {
            case 1:
                System.out.print("N° de mástiles: ");
                int mastiles = leer.nextInt();
                barco = new Velero(mastiles, matricula, eslora, anioFabr);
                break;
            case 2:
                System.out.print("Potencia en CV:");
                int cvBarcoMotor = leer.nextInt();

                barco = new BarcoMotor(opcion, matricula, eslora, anioFabr);
                break;
            case 3:
                System.out.print("Potencia en CV:");
                int cvYate = leer.nextInt();

                System.out.print("N° de camarotes:");
                int camarotes = leer.nextInt();

                barco = new Yate(camarotes, opcion, matricula, eslora, anioFabr);
                break;
        }
        return barco;
    }
}