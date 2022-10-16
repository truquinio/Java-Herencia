/*
Crear una superclase llamada Electrodoméstico con los siguientes atributos: precio, color, 
consumo energético (letras entre A y F) y peso.
Los constructores que se deben implementar son los siguientes:

•  Un constructor vacío.
•  Un constructor con todos los atributos pasados por parámetro.

Los métodos a implementar son:
•  Métodos getters y setters de todos los atributos.
 */
package entidad;

import java.util.Scanner;

/**
 *
 * @author FT
 */
public class Electrodomestico {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

///ATTR: Protected, solo pueden heredarlos las clases HIJOS, usando el SUPER.-
    protected Double precio;
    protected String color;
    protected String consumo;
    protected Double peso;

///CONSTR:
    public Electrodomestico() {
    }
    public Electrodomestico(Double precio, String color, String consumo, Double peso) {
        this.precio = precio;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

///G & S:
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getConsumo() {
        return consumo;
    }
    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }

///TO STRING:
    @Override
    public String toString() {
        return "Electrodoméstico //" + " Precio: " + precio + " / Color: " + color + " / Consumo: " + consumo + " / Peso: " + peso;
    }

    /*
    Método comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta,
sino es correcta usara la letra F por defecto. Este método se debe invocar al crear el objeto y no será visible.
     */
    //Private porque no será visible.-
    private void comprobarConsumo(String letra) {

        if (letra.toUpperCase().equals("A") || letra.toUpperCase().equals("B") || letra.toUpperCase().equals("C") || letra.toUpperCase().equals("D") || letra.toUpperCase().equals("E") || letra.toUpperCase().equals("F")) {

        } else {
            //Seteo consumo "F" por defecto.-
            setConsumo("F");
        }
    }

    /*
    Método comprobarColor(String color): comprueba que el color es correcto, y si no lo es, usa el color blanco por defecto.
Los colores disponibles para los electrodomésticos son blanco, negro, rojo, azul y gris.
No importa si el nombre está en mayúsculas o en minúsculas. Este método se invocará al crear el objeto y no será visible.
     */
    //Private porque no será visible.-
    private void comprobarColor(String color) {

        if (color.toLowerCase().equals("blanco") || color.toLowerCase().equals("negro") || color.toLowerCase().equals("rojo") || color.toLowerCase().equals("azul") || color.toLowerCase().equals("gris")) {

        } else {
            //Seteo "BLANCO" por defecto.-
            setColor("blanco");
        }
    }

    /*
    Metodo crearElectrodomestico(): le pide la información al usuario y llena el electrodoméstico, 
también llama los métodos para comprobar el color y el consumo. Al precio se le da un valor base de $1000.
     */
    public void crearElectrodomestico() {

        //GET CLASS: Trae la clase (Para no sobreescribir el método en todas las clases).-
        //GET SIMPLE NAME: Convierte el nombre de la clase en String y lo muestra con el SOUT.-
        System.out.println("Nuevo electrodoméstico: " + getClass().getSimpleName());

        //Seteo el precio como DOUBLE (d).-
        setPrecio(1000d);

        System.out.println("Color del electrodoméstico:");
        setColor(leer.next().toLowerCase());

        //Llamo al método COMPROBAR COLOR para ver si coincide con lo ingresado o seteo BLANCO por defecto (Método no será visible al usuario).-
        comprobarColor(getColor());

        System.out.println("Consumo del electrodoméstico: (A/F)");
        setConsumo(leer.next().toUpperCase());

        //Llamo al método COMPROBAR CONSUMO para ver si coincide con lo ingresado o seteo "F" por defecto (Método no será visible al usuario).-
        comprobarConsumo(getConsumo());

        System.out.println("Peso del electrodoméstico:");
        setPeso(leer.nextDouble());
    }

    /*
    Método precioFinal(): según el consumo energético y su tamaño, aumentará el valor del 
precio. Esta es la lista de precios:

LETRA / PRECIO          PESO / PRECIO
A $1000                 Entre 1 y 19 kg $100
B $800                  Entre 20 y 49 kg $500
C $600                  Entre 50 y 79 kg $800
D $500                  Mayor que 80 kg14 $1000
E $300
F $100

     */
    public void precioFinal() {
        /*
        OPERADOR TERNARIO:
        (condición ? IF (true) : ELSE (false))
        */
        precio = precio + (consumo.equals("A") ? 1000 : 0) +    //Si CONSUMO = A, al PRECIO le agrego $1000, sino no agrego nada (0).-
                (consumo.equals("B") ? 800 : 0) +               //Si CONSUMO = B, al PRECIO le agrego $800, sino no agrego nada (0).-
                (consumo.equals("C") ? 600 : 0) +               //Si CONSUMO = C, al PRECIO le agrego $600, sino no agrego nada (0).-
                (consumo.equals("D") ? 500 : 0) +               //Si CONSUMO = D, al PRECIO le agrego $500, sino no agrego nada (0).-
                (consumo.equals("E") ? 300 : 0) +               //Si CONSUMO = E, al PRECIO le agrego $300, sino no agrego nada (0).-
                (consumo.equals("F") ? 100 : 0) +               //Si CONSUMO = F, al PRECIO le agrego $100, sino no agrego nada (0).-
                //ADEMÁS:
                (peso >= 1 && peso <= 19 ? 100 : 0)  +          //Si PESO entre 1 y 19 kg, al PRECIO le agrego $100, sino no agrego nada (0).-
                (peso >= 20 && peso <= 49 ? 500 : 0) +          //Si PESO entre 20 y 49 kg, al PRECIO le agrego $500, sino no agrego nada (0).-
                (peso >= 50 && peso <= 79 ? 800 : 0) +          //Si PESO entre 50 y 79 kg, al PRECIO le agrego $800, sino no agrego nada (0).-
                (peso >= 80 ? 1000 : 0);                        //Si PESO mayor 80 kg, al PRECIO le agrego $1000, sino no agrego nada (0).-
        
        System.out.println("\nPrecio lista: $" + precio);

    }
}
        /*
        OTRA FORMA: Sería haciendo un SWITCH y luego una serie de IF:

        public void precioFinal() {

        switch(consumo){
        
            case "A":
                precio = precio + 1000;
                break;
        
            case "B":
                precio = precio + 800;
                break;
        
            case "C":
                precio = precio + 600;
                break;
        
            case "D":
                precio = precio + 500;
                break;
        
            case "E":
                precio = precio + 300;
                break;
        
            case "F":
                precio = precio + 100;
                break;
        }
        
        if (peso >= 1 && peso <= 19){
            precio = precio + 100;
        }
        if (peso >= 20 && peso <= 49){
            precio = precio + 500;
        }
        if (peso >= 50 && peso <= 79){
            precio = precio + 800;
        }
        if (peso>80){
            precio = precio + 1000;
        }
        
        System.out.println("\nPrecio base: $" + precio);
    }
}
        */