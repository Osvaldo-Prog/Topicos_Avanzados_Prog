package View;

import java.util.Scanner;

import Model.ClienteModel;
import Model.InventarioModel;
import Model.ListaGenerica;

public class SistemaView implements ViewGlobal {
    private final Scanner sc;

    public SistemaView() {
        sc = new Scanner(System.in);
    }

    @Override
    public String pedirNombre() {
        System.out.print("Ingrese el nombre del cliente: ");
        return sc.nextLine();
    }

    @Override
    public String pedirEmail() {
        System.out.print("Ingrese el email del cliente: ");
        return sc.nextLine();
    }

    @Override
    public String pedirTelefono() {
        System.out.print("Ingrese el telefono del cliente: ");
        return sc.nextLine();
    }

    @Override
    public double pedirSaldo() {
        System.out.print("Ingrese el saldo del cliente: ");
        return Double.parseDouble(sc.nextLine());
    }

    @Override
    public String pedirCodigo() {
        System.out.print("Ingrese el código del producto: ");
        return sc.nextLine();
    }

    @Override
    public int pedirIdCliente() {
        System.out.print("Ingrese el ID del cliente: ");
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public String pedirNombreProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        return sc.nextLine();
    }

    @Override
    public double pedirPrecio() {
        System.out.print("Ingrese el precio del producto: ");
        return Double.parseDouble(sc.nextLine());
    }

    @Override
    public int pedirCantidad() {
        System.out.print("Ingrese la cantidad del producto: ");
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public String pedirCategoria() {
        System.out.print("Ingrese la categoria del producto: ");
        return sc.nextLine();
    }

    @Override
    public String pedirFechaVencimiento() {
        System.out.print("Ingrese la fecha de vencimiento del producto (dd/mm/aaaa): ");
        return sc.nextLine();
    }

    @Override
    /* Cambiar los metodos para que retornen el valor inrgesado */
    public int menuPrincipal() {
        int opcion;
        System.out.println("\n===== SISTEMA DE INVENTARIO =====");
        System.out.println("1. Gestionar Productos");
        System.out.println("2. Gestionar Clientes");
        System.out.println("3. Guardar y Salir");
        System.out.print("Seleccione una opción: ");
        opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    @Override
    public int menuProductos() {
        int opcion;
        System.out.println("\n----- GESTIÓN DE PRODUCTOS -----");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Modificar Producto");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Listar Productos");
        System.out.println("5. Buscar Producto");
        System.out.println("6. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
        opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    @Override
    public int menuClientes() {
        int opcion;
        System.out.println("\n----- GESTIÓN DE CLIENTES -----");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Modificar Cliente");
        System.out.println("3. Eliminar Cliente");
        System.out.println("4. Listar Clientes");
        System.out.println("5. Buscar Cliente");
        System.out.println("6. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
        opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    @Override
    public void menuDespedida() {
        System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
    }

    @Override
    public int menuBuscarProductos() {
        int opcion;
        System.out.println("1. Buscar por Nombre");
        System.out.println("2. Buscar por Código");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    @Override
    public int menuBuscarCliente() {
        System.out.println("1. Buscar por Nombre");
        System.out.println("2. Buscar por Id");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public int leerOpcion() {
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public void mensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void error(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }

    @Override
    public String confirmacion() {
        mensaje("Desea eliminar este cliente? (s/n): ");
        return sc.nextLine();
    }

    @Override
    public String mostrarDetallesProducto(ListaGenerica<InventarioModel> lista, String codigo) {
        boolean encontrado = false;
        StringBuilder sbDetallesProducto = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            InventarioModel producto = lista.get(i);
            if (producto.getCodigo().equals(codigo)) {
                sbDetallesProducto.append("\n---------- Detalles del Producto ----------\n")
                        .append("Codigo: ").append(producto.getCodigo()).append("\n")
                        .append("Nombre: ").append(producto.getNombre()).append("\n")
                        .append("Precio: $").append(producto.getPrecio()).append("\n")
                        .append("Cantidad: ").append(producto.getCantidad()).append("\n")
                        .append("Categoria: ").append(producto.getCategoria()).append("\n")
                        .append("Fecha de vencimiento: ").append(producto.getFechaVencimiento())
                        .append("\n----------------------------");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto con código " + codigo + " no encontrado.");
        }
        return sbDetallesProducto.toString();
    }

    @Override
    public String mostrarDetalleCliente(ListaGenerica<ClienteModel> listaClientes, int id) {
        boolean encontrado = false;

        StringBuilder sbDetallesCliente = new StringBuilder();
        for (int i = 0; i < listaClientes.size(); i++) {
            ClienteModel cliente = listaClientes.get(i);
            if (cliente.getId() == id) {
                sbDetallesCliente.append("\n--- Detalles del Cliente ---")
                        .append("ID: ").append(cliente.getId()).append("\n")
                        .append("Nombre: ").append(cliente.getNombre()).append("\n")
                        .append("Email: ").append(cliente.getEmail()).append("\n")
                        .append("Teléfono: ").append(cliente.getTelefono()).append("\n")
                        .append("Saldo: $").append(cliente.getSaldo()).append("\n");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Cliente con ID " + id + " no encontrado.");
        }
        return sbDetallesCliente.toString();
    }

    @Override
    public String listadoClientes(ListaGenerica<ClienteModel> listaClientes) {
        StringBuilder sbListaClientes = new StringBuilder("\n--- Listado de Clientes ---\n");
        for (int i = 0; i < listaClientes.size(); i++) {
            ClienteModel cliente = listaClientes.get(i);
            sbListaClientes.append((i + 1)).append(". ").append(cliente.toString()).append("\n");
        }
        return sbListaClientes.toString();
    }

    @Override
    public String listadoProductos(ListaGenerica<InventarioModel> listaInventario) {
        StringBuilder sbListaProductos = new StringBuilder("\n--- Listado de Productos ---\n");
        for (int i = 0; i < listaInventario.size(); i++) {
            InventarioModel producto = listaInventario.get(i);
            sbListaProductos.append((i + 1)).append(". ")
                    .append(producto.getCodigo()).append(" - ")
                    .append(producto.getNombre())
                    .append(" | Precio: $").append(producto.getPrecio())
                    .append(" | Cantidad: ").append(producto.getCantidad())
                    .append("\n");
        }
        return sbListaProductos.toString();
    }
}
