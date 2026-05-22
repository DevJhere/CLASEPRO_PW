package model;
//Toda clase JAVA que procede de la clase Padre/Madre Object
public class Coche {

    //Definimos los atributos - Los que vayamos a necesitar
    private String marca, modelo, color;
    private int numeroPuertas, CV, precio;



    //Metodos. Tipo_acceso tipo_retorno  nombre_metodo (argumentos){}

    //Metodo. Constructor. Hay un mínimo por defecto vacio, es implicito.
    //El constructor debe inicializar los parámetros para poder utilizar sus propiedades.

    //Forma basica de constructor por defecto

    //Esto se denomina Sobrecarga de Constructores
    public Coche() {}

    public Coche(String marca, String modelo, String color, int numeroPuertas, int cV, int precio) {
        //Empleamos la palabra reservada para poder seleccionar los atributos definidos previamente y emplearlos en el constructor.
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.numeroPuertas = numeroPuertas;
        this.CV = cV;
        this.precio = precio;

    }

    //Otro constructor con distinta firma
    public Coche(String marca, String modelo, int numeroPuertas, int precio){}

    //Getter
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public int getCV() {
        return CV;
    }

    public int getPrecio() {
        return precio;
    }

    //Setter
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCV(int CV) {
        this.CV = CV;
    }
}
