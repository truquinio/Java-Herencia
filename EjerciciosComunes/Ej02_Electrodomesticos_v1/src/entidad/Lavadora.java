/*
A continuación, se debe crear una subclase llamada Lavadora, con el atributo carga,
además de los atributos heredados.
 */
package entidad;

/**
 *
 * @author FT
 */
public class Lavadora extends Electrodomestico {

///ATTR:
    private Integer carga;

///CONSTR:
    public Lavadora() {
    }
    /*
    Un constructor con la carga y el resto de los atributos heredados. Recuerda que debes
    llamar al constructor de la clase padre.
     */
    public Lavadora(Integer carga, Double precio, String color, String consumo, Double peso) {
        super(precio, color, consumo, peso);
        this.carga = carga;
    }
    
///G & S:
    public Integer getCarga() {
        return carga;
    }
    public void setCarga(Integer carga) {
        this.carga = carga;
    }
    
///TO STRING:   
    @Override
    public String toString() {
        //Llamo al método TO STRING mediante un SUPER, porque viene heredado de la clase PADRE.-
        return super.toString() + " // Lavadora / " + "Carga: " + carga;
}

    /*
    Método crearLavadora (): este método llama a crearElectrodomestico() de la clase
padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
el atributo propio de la lavadora.
     */
    
    public void crearLavadora() {

        //Llamo al método CREAR ELECTRODOMÉSTICO mediante un SUPER, porque es heredado de la clase PADRE.-
        super.crearElectrodomestico();

        //SETEO la CARGA de la lavadora a todo lo demás que ya viene del electrodoméstico.-
        System.out.println("Carga de la lavadora:");
        setCarga(leer.nextInt());
    }
    
    /*
    Método precioFinal(): este método será heredado y se le sumará la siguiente funcionalidad.
    Si el televisor tiene una resolución mayor de 40 pulgadas, se incrementará el precio un 30% 
    y si tiene un sintonizador TDT incorporado, aumentará $500.
    Recuerda que las condiciones que hemos visto en la clase Electrodomestico también deben afectar al precio.
    */
    
    //SOBREESCRIBO el método PRECIO FINAL de clase ELECTRODOMÉSTICO y al OPERADOR TERNARIO le agrego la CARGA de la LAVADORA.-
    @Override
    public void precioFinal() {
        
        //Llamo al método PRECIO FINAL mediante un SUPER, porque es heredado de la clase PADRE.-
        super.precioFinal();
        /*
        OPERADOR TERNARIO:
        (condición ? IF (true) : ELSE (false))
        */
        precio = precio + (carga > 30 ? 500 : 0);          //Si CARGA mayor a 30 kg, al PRECIO le agrego $500, sino no agrego nada (0).-
        
        System.out.println("Precio lavadora: $" + precio);
    }
}