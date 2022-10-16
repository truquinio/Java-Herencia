/*
Tenemos una clase padre Animal junto con sus 3 clases hijas Perro, Gato, Caballo. 
La clase Animal tendrá como atributos el nombre, alimento, edad y raza del Animal.

Crear un método en la clase Animal a través del cual cada clase hija deberá mostrar luego un 
mensaje por pantalla informando de que se alimenta. 
 */
package entidades;

/**
 *
 * @author FT
 */
public class Animal {

///ATTR:
    protected String nombre;
    protected String alimento;
    protected int edad;
    protected String raza;
    
///CONSTR:
    public Animal() {
    }   
    public Animal(String nombre, String alimento, int edad, String raza) {
        this.nombre = nombre;
        this.alimento = alimento;
        this.edad = edad;
        this.raza = raza;
    }

///G & S:
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAlimento() {
        return alimento;
    }
    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    
///MÉTODO ALIMENTARSE:
public void alimentarse(){
    
    //GET CLASS: Trae la clase (Para no sobreescribir el método alimentarse en todas las clases).-
    //GET SIMPLE NAME: Convierte todo en String.-
    
    System.out.println("Soy un " + getClass().getSimpleName() + " y me alimento de " + getAlimento());
    }
}