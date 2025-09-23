/**
 * Clase que solo muestra lo que ve el usuario mediante la consola por ahora
 */
import java.util.Scanner;

public class ViewProducto {
    private Controlador controller;
    private Scanner sc = new Scanner(System.in);
  /**
   * 
   * @param controller controlador asociado a view
   */  
public ViewProducto(Controlador controller) {
    this.controller = controller;
}


/**
 * Menu principal del programa
 */
    public void menu() {
        int opcion;
        do {
            System.out.println("=== Menú Inventario ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch(opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    controller.mostrarProductos();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while(opcion != 3);
    }

    /**
     * Solicita los datos del prducto al usuario
     * al final los agrega al controlador
     */
    private void agregarProducto() {
        System.out.print("Tipo (electronica/alimento): ");
        String tipo = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        controller.agregarProducto(tipo, nombre, precio);
    }
}
