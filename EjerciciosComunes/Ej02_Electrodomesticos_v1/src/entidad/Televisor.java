/*
Se debe crear también una subclase llamada Televisor con los siguientes atributos:
resolución (en pulgadas) y sintonizador TDT (booleano), además de los atributos
heredados.
 */
package entidad;

/**
 *
 * @author FT
 */
public class Televisor extends Electrodomestico {

///ATTR:
    private Integer resolucion;
    private boolean TDT;

///CONSTR:
    public Televisor() {
    }
    /*
    Un constructor con la resolución, sintonizador TDT y el resto de los atributos
    heredados. Recuerda que debes llamar al constructor de la clase padre.
    */
    public Televisor(Integer resolucion, boolean TDT, Double precio, String color, String consumo, Double peso) {
        super(precio, color, consumo, peso);
        this.resolucion = resolucion;
        this.TDT = TDT;
    }
    
///G & S:
    public Integer getResolucion() {
        return resolucion;
    }
    public void setResolucion(Integer resolucion) {
        this.resolucion = resolucion;
    }
    public boolean isTDT() {
        return TDT;
    }
    public void setTDT(boolean TDT) {
        this.TDT = TDT;
    }

///TO STRING:
    @Override
    public String toString() {
        //Llamo al método TO STRING mediante un SUPER, porque viene heredado de la clase PADRE.-
        return super.toString() + " // TV / Resolución: " + resolucion + " / TDT: " + TDT;
    }

    /*
    Método crearTelevisor(): este método llama a crearElectrodomestico() de la clase
    padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
    los atributos del televisor.
    */
    
    public void crearTelevisor(){
        
        //Llamo al método CREAR ELECTRODOMÉSTICO mediante un SUPER, para marcar que es heredado de la clase PADRE.-
        super.crearElectrodomestico();
        
        System.out.println("Resolución del TV: (pulg)");
        setResolucion(leer.nextInt());
        
        System.out.println("¿Posee TDT? (S/N)");
        String opcionSiNo = leer.next();
        
        if(opcionSiNo.toLowerCase().equals("s")|| opcionSiNo.toLowerCase().equals("si"))
        {
            setTDT(true);
        }        
    }
    
    /*
    Método precioFinal(): este método será heredado y se le sumará la siguiente funcionalidad.
    Si el televisor tiene una resolución mayor de 40 pulgadas, se incrementará el precio un 30% 
    y si tiene un sintonizador TDT incorporado, aumentará $500.
    Recuerda que las condiciones que hemos visto en la clase Electrodomestico también deben afectar al precio.
    */
   
    //SOBREESCRIBO el método PRECIO FINAL de clase ELECTRODOMÉSTICO y al OPERADOR TERNARIO le agrego el PRECIO del TV.-
    @Override
    
    public void precioFinal(){
        
        //Llamo al método PRECIO FINAL mediante un SUPER, para marcar que es heredado de la clase PADRE.-
        super.precioFinal();
        /*
        OPERADOR TERNARIO:
        (condición ? IF (true) : ELSE (false))
        */
        precio = precio + (resolucion > 40 ? (precio * 0.3) : 0) +        //Si RESOLUCIÓN mayor a 40", al PRECIO le agrego un 30%, sino no agrego nada (0).-
                (TDT ? 500 : 0);                                          //Si posee TDT, al PRECIO le agrego $500, sino no agrego nada (0).-
        
        System.out.println("Precio Televisor: $" + precio + "\n");
    }
}