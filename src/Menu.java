import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<Producto> catalogo;
    private Carrito carrito;
    private Scanner sc;

    public Menu() {
        this.catalogo = new ArrayList<Producto>();
        this.carrito = new Carrito();
        this.sc = new Scanner(System.in);
        cargarProductos();
    }

    private void cargarProductos() {
        catalogo.add(new Producto(1, "Gaseosa", 11.00));
        catalogo.add(new Producto(2, "Fideos", 5.00));
        catalogo.add(new Producto(3, "Café", 15.00));
        catalogo.add(new Producto(4, "Queso", 35.00));
        catalogo.add(new Producto(5, "Pollo", 16.00));
        catalogo.add(new Producto(6, "Azúcar", 7.00));
    }

    public void mostrarMenuPrincipal() {
        int opcion = -1;

        do {
            System.out.println("=====================================");
            System.out.println("----SISTEMA DE COMPRAS EN CONSOLA----");
            System.out.println("1. Ver catalogo de productos");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver carrito");
            System.out.println("4. Eliminar producto del carrito");
            System.out.println("5. Finalizar compra");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");


            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            } else {
                System.out.println("Error: Debe ingresar un numero valido.");
                opcion = -1;
            }

            sc.nextLine();

            switch (opcion) {
                case 1:
                    mostrarCatalogo();
                    break;
                case 2:
                    agregarAlCarrito();
                    break;
                case 3:
                    carrito.mostrarCarrito();
                    break;
                case 4:
                    eliminarDelCarrito();
                    break;
                case 5:
                    carrito.finalizarCompra();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema.");
                    Registrador.log("Cerro el programa.");
                    break;
                default:
                    if (opcion != -1) {
                        System.out.println("Opcion no valida.");
                    }
            }

        } while (opcion != 0);
    }

    private void mostrarCatalogo() {
        System.out.println("\n======= CATALOGO DE PRODUCTOS =======");
        for (int i = 0; i < catalogo.size(); i++) {
            Producto p = catalogo.get(i);
            System.out.println(p);
        }
        System.out.println("=====================================");
        Registrador.log("Vio el catalogo de productos.");
    }

    private void agregarAlCarrito() {
        mostrarCatalogo();
        System.out.print("Ingrese el codigo del producto a agregar: ");
        int codigo = sc.nextInt();

        Producto productoEncontrado = null;

        for (int i = 0; i < catalogo.size(); i++) {
            Producto p = catalogo.get(i);
            if (p.getCodigo() == codigo) {
                productoEncontrado = p;
                break;
            }
        }

        if (productoEncontrado != null) {
            carrito.agregarProducto(productoEncontrado);
        } else {
            System.out.println("Producto con codigo '" + codigo + "' no encontrado.");
            Registrador.log("Intento agregar producto con codigo no existente: " + codigo);
        }
    }

    private void eliminarDelCarrito() {
        carrito.mostrarCarrito();
        System.out.print("Ingrese el codigo del producto a eliminar: ");
        int codigo = sc.nextInt();
        carrito.eliminarProducto(codigo);
    }
}