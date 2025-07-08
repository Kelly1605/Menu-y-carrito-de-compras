import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carrito {

    private List<Producto> productos;

    public Carrito() {
        productos = new ArrayList<Producto>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
        Registrador.log("Agrego al carrito: " + producto.getNombre());
    }

    public void mostrarCarrito() {
        if (productos.isEmpty()) {
            System.out.println("El carrito esta vacio.");
            return;
        }

        double total = 0;
        System.out.println("\n======= CARRITO DE COMPRAS =======");
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.println(p);
            total += p.getPrecio();
        }

        System.out.println("=====================================");
        System.out.println("Total: $" + String.format("%.2f", total));
    }

    public void eliminarProducto(int codigo) {
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            if (p.getCodigo() == codigo) {
                productos.remove(i);
                System.out.println("Producto eliminado: " + p.getNombre());
                Registrador.log("Elimino del carrito: " + p.getNombre());
                return;
            }
        }
        System.out.println("Producto no encontrado en el carrito con codigo: " + codigo);
    }

    public void finalizarCompra() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el carrito.");
            return;
        }

        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            total += p.getPrecio();
        }

        System.out.println("=====================================");
        System.out.println("¡Compra finalizada con exito!");
        System.out.println("Total a pagar: $" + String.format("%.2f", total));
        Registrador.log("Finalizo compra. Total: $" + String.format("%.2f", total));
        productos.clear();
        System.out.println("El carrito ha sido vaciado.");

    }

}