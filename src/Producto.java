public class Producto {

    private int codigo;
    private String nombre;
    private double precio;

    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }

    public String toString() {
        return "[" + codigo + "]" + nombre + " - $" + String.format("%.2f", precio);

    }
}