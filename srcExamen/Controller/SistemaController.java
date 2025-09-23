package Controller;
/*  ~Stretegy con parametro global para switchear enre interfaz grafica y consola con strategy
    ~mover los textArea y JSCROLL A LA VISTA, ESO NO DEBE ESTAR EN EL CONTROLADOR, en pocas palabras, no poner ningunJOptionPaneo sout en el controllador*/
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;

import Model.ClienteModel;
import Model.InventarioModel;
import Model.ListaGenerica;
//import View.SistemaView;
import View.SistemaViewJ;

public class SistemaController {
    private final ListaGenerica<InventarioModel> listaInventario;
    private final ListaGenerica<ClienteModel> listaClientes;
    private final SistemaViewJ view;

    public SistemaController(SistemaViewJ view) {
        this.view = view;
        this.listaInventario = new ListaGenerica<>();
        this.listaClientes = new ListaGenerica<>();
    }

    /**
     * Inicia el sistema y muestra el menú principal, manejando las opciones
     * seleccionadas por el usuario.
     * Para volver a cambiarlo a consola, solo se pone el view.manuprincipal() despues de inicar el ciclo
     * y la opcion es igual a view.leerOpcion()
     */
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = view.menuPrincipal();
            switch (opcion) {
                case 1 -> productos();
                case 2 -> clientes();
                case 3 -> {
                    view.mensaje("Guardando y saliendo...");
                    view.menuDespedida();
                    salir = true;
                }
                default -> view.error("Opción inválida");
            }
        }
    }

    /**
     * Muestra el menú de gestión de productos y maneja las opciones seleccionadas
     * por el usuario.
     */
    public void productos() {
        boolean volver = false;
        while (!volver) {
            int opcion = view.menuProductos();
            switch (opcion) {
                case 1: {
                    agregarProducto();
                    break;
                }
                case 2: {
                    modificarProducto();
                    break;
                }
                case 3: {
                    eliminarProducto();
                    break;
                }
                case 4: {
                    listarProductos();
                    break;
                }
                case 5: {
                    menuBuscar();
                    break;
                }
                case 6: {
                    volver = true;
                    break;
                }
                default: {
                    view.error("Opcion no valida");
                }
            }
        }
    }

    /**
     * Muestra el menú de gestión de clientes y maneja las opciones seleccionadas
     * por el usuario.
     */
    public void clientes() {
        boolean volver = false;
        while (!volver) {
            int opcion = view.menuClientes();
            switch (opcion) {
                case 1: {
                    agregarCliente();
                    break;
                }
                case 2: {
                    modificarCliente();
                    break;
                }
                case 3: {
                    eliminarCliente();
                    break;
                }
                case 4: {
                    listarClientes();
                    break;
                }
                case 5: {
                    menuBuscarClientes();
                    break;
                }
                case 6: {
                    volver = true;
                    break;
                }
                default: {
                    view.error("Opcion no valida");
                }
            }
        }
    }

    /**
     * Agrega un nuevo cliente a la lista de clientes.
     */
    public void agregarCliente() {
        int id = view.pedirIdCliente();
        /*
         * en este if se usa el metodo recursivo pero se pone return para que se deje de
         * ejecutar lo de abajo y regrese al metodo llamado en la recurisividad
         */
        if (corroborarIdCliente(id)) {
            agregarCliente();
            return;
        } else {
            String nombre = view.pedirNombre();
            String email = view.pedirEmail();
            String telefono = view.pedirTelefono();
            double saldo = view.pedirSaldo();
            ClienteModel nuevoCliente = new ClienteModel(id, nombre, email, telefono, saldo);
            listaClientes.agregar(nuevoCliente);
        }
    }

    /**
     * Agrega un nuevo producto al inventario si no se ha alcanzado el límite máximo
     * de 100 productos.
     */
    public void agregarProducto() {
        if (listaInventario.size() >= 100) {
            view.error("No se pueden agregar mas productos, inventario lleno");
            return;
        }
        String codigo = view.pedirCodigo();
        if(corroborarCodigoProducto(codigo)){
            agregarProducto();
            return;
        }else{
            String nombre = view.pedirNombreProducto();
            double precio = view.pedirPrecio();
            int cantidad = view.pedirCantidad();
            String categoria = view.pedirCategoria();
            String fechaVencimiento = view.pedirFechaVencimiento();
            InventarioModel nuevoProducto = new InventarioModel(codigo, nombre, precio, cantidad, categoria, fechaVencimiento);
            listaInventario.agregar(nuevoProducto);
        }
    }

    /**
     * Elimina un cliente de la lista de clientes después de confirmar la acción con
     * el usuario.
     */
    public void eliminarCliente() {
        view.mensaje("----------- Eliminar Cliente -----------");
        view.mensaje("Ingrese el numero del cliente a eliminar (1 - " + listaClientes.size() + "): ");
        int index = view.leerOpcion();

        if (index < 1 || index > listaClientes.size()) {
            view.error("Numero invalido");
            return;
        }
        view.mensaje("Cliente encontrado: " + listaClientes.get(index - 1).getNombre());

        String confirmacion = view.confirmacion();

        if (confirmacion.equalsIgnoreCase("S")) {
            listaClientes.eliminar(index - 1);
            view.mensaje("Cliente eliminado");
        } else {
            view.mensaje("Operacion cancelada");
        }
    }

    /**
     * Elimina un producto del inventario basado en su código.
     */
    public void eliminarProducto() {
        String codigo = view.pedirCodigo();
        for (int i = 0; i < listaInventario.size(); i++) {
            if (listaInventario.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaInventario.get(i).totalProductos -= listaInventario.get(i).getCantidad();
                listaInventario.eliminar(i);
                view.mensaje("Producto eliminado");
                return;
            } else {
                view.error("Inventario no encontrado");
            }
        }
    }

    /**
     * Modifica los datos de un cliente existente en la lista de clientes.
     */
    public void modificarCliente() {
        view.mensaje("----------- Entrando a Modificar Cliente -----------");

        view.mensaje("Ingrese el numero del cliente a modificar (1 - " + listaClientes.size() + "): ");
        int index = view.leerOpcion();

        if (index < 1 || index > listaClientes.size()) {
            view.error("Numero invalido");
            return;
        }

        view.mensaje("Cliente encontrado: " + listaClientes.get(index - 1).getNombre());
        view.mensaje("Ingrese los nuevos datos:");

        int id = view.pedirIdCliente();
        String nombre = view.pedirNombre();
        String email = view.pedirEmail();
        String telefono = view.pedirTelefono();
        double saldo = view.pedirSaldo();
        ClienteModel clienteMod = new ClienteModel(id, nombre, email, telefono, saldo);
        listaClientes.actualizar(index - 1, clienteMod);
        view.mensaje("Cliente modificado");
    }

    /**
     * Modifica los datos de un producto existente en el inventario basado en su
     * código.
     */
    public void modificarProducto() {
        view.mensaje("----------- Entrando a Modificar Producto -----------");

        String codigo = view.pedirCodigo();
        for (int i = 0; i < listaInventario.size(); i++) {
            if (listaInventario.get(i).getCodigo().equals(codigo)) {
                view.mensaje("Producto encontrado: " + listaInventario.get(i).getNombre());
                view.mensaje("Ingrese los nuevos datos:");

                String nombre = view.pedirNombreProducto();
                double precio = view.pedirPrecio();
                int cantidad = view.pedirCantidad();
                String categoria = view.pedirCategoria();
                String fechaVencimiento = view.pedirFechaVencimiento();
                InventarioModel productoMod = new InventarioModel(codigo, nombre, precio, cantidad, categoria,
                        fechaVencimiento);
                listaInventario.actualizar(i, productoMod);
                view.mensaje("Producto modificado: " + productoMod.getNombre());
            } else {
                view.error("Producto no encontrado");
            }
        }
    }

    /**
     * Lista todos los clientes registrados en el sistema.
     */
    // -----------------CAMBIAR A METODO TOSTRING Y CON SCROLL PARA MOSTRAR LA LISTA
    // Se creo un JTextArea y un JScrollPane para mostrar la lista en una sola
    // ventana y lo mismo con la lista de productos
    public void listarClientes() {
        StringBuilder sbListaClientes = new StringBuilder();
        sbListaClientes.append("=====Lista de Clientes=====\n");
        for (int i = 0; i < listaClientes.size(); i++) {
            ClienteModel cliente = listaClientes.get(i);
            sbListaClientes.append((i + 1)).append(". ").append(cliente.toString()).append("\n");
        }
        // Crear el area de texto
        JTextArea areaTextoClientes = new JTextArea(sbListaClientes.toString(), 10, 30);
        areaTextoClientes.setEditable(false);
        areaTextoClientes.setCaretPosition(0);
        areaTextoClientes.setWrapStyleWord(true);

        // Crear la ventana Scrolleable
        JScrollPane ventanaScroll = new JScrollPane(areaTextoClientes);
        ventanaScroll.setPreferredSize(new Dimension(400, 250));

        JOptionPane.showMessageDialog(null, ventanaScroll, "Lista de clientes", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Lista todos los productos en el inventario.
     */
    public void listarProductos() {
        StringBuilder sbListaProductos = new StringBuilder();
        sbListaProductos.append("----------- Lista de Productos -----------\n");
        for (int i = 0; i < listaInventario.size(); i++) {
            InventarioModel producto = listaInventario.get(i);
            sbListaProductos.append((i + 1)).append(". ").append(producto.toString()).append("\n");
        }

        // Crear la JTextArea para lista de productos
        JTextArea areaTextoProductos = new JTextArea(sbListaProductos.toString(), 20, 30);
        areaTextoProductos.setEditable(false);
        areaTextoProductos.setCaretPosition(0);
        areaTextoProductos.setWrapStyleWord(true);

        // Crear el scroll para la ventana de la lisat de productos
        JScrollPane ventanaScrollProductos = new JScrollPane(areaTextoProductos);
        ventanaScrollProductos.setPreferredSize(new Dimension(400, 300));
        JOptionPane.showMessageDialog(null, ventanaScrollProductos, "Lista de productos",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Busca un cliente por su ID y muestra sus detalles si se encuentra.
     */
    public void buscarClienteById() {
        int id = view.pedirIdCliente();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getId() == id) {
                mostrarDetallesCliente(listaClientes.get(i).getId());
                return;
            }
        }
        view.error("Cliente no encontrado");
    }

    /**
     * Busca un cliente por su nombre y muestra sus detalles si se encuentra.
     */
    public void buscarClienteByNombre() {
        String nombre = view.pedirNombre();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getNombre().equalsIgnoreCase(nombre)) {
                mostrarDetallesCliente(listaClientes.get(i).getId());
                return;
            }
        }
        view.error("Cliente no encontrado");
    }

    /**
     * Muestra los detalles de un cliente dado su ID.
     * Este antes estaba en el view, pero ahora en el view solo se manda a llamar
     * @param id El ID del cliente cuyos detalles se desean mostrar.
     */
    public void mostrarDetallesCliente(int id) {
        StringBuilder sbDetallesCliente = new StringBuilder();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getId() == id) {
                ClienteModel cliente = listaClientes.get(i);
                sbDetallesCliente.append("\n---------- Detalles del Cliente ----------\n")
                        .append("ID: ").append(cliente.getId()).append("\n")
                        .append("Nombre: ").append(cliente.getNombre()).append("\n")
                        .append("Email: ").append(cliente.getEmail()).append("\n")
                        .append("Telefono: ").append(cliente.getTelefono()).append("\n")
                        .append("Saldo: ").append(cliente.getSaldo()).append("\n--------------------------");

                // Crear un textArea para guardar la informacion
                JTextArea areaTextoDetallesCliente = new JTextArea(sbDetallesCliente.toString(), 30, 30);
                areaTextoDetallesCliente.setEditable(false);
                areaTextoDetallesCliente.setCaretPosition(0);
                areaTextoDetallesCliente.setWrapStyleWord(true);
                areaTextoDetallesCliente.setLineWrap(true);

                // Crear un ScrollPane para mostarlo
                JScrollPane scrollPaneDetallesCliente = new JScrollPane(areaTextoDetallesCliente);
                scrollPaneDetallesCliente.setPreferredSize(new Dimension(400, 400));

                JOptionPane.showMessageDialog(null, scrollPaneDetallesCliente, "Detalles del cliente",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }

    /**
     * Busca un producto por su código y muestra sus detalles si se encuentra.
     */
    public void buscarProductoByCodigo() {
        String codigo = view.pedirCodigo();
        for (int i = 0; i < listaInventario.size(); i++) {
            if (listaInventario.get(i).getCodigo().equals(codigo)) {
                mostrarDetallesProducto(listaInventario.get(i).getCodigo());
                return;
            }
        }
        view.error("Producto no encontrado");
    }

    /**
     * Busca un producto por su nombre y muestra sus detalles si se encuentra.
     */
    public void buscarProductoByNombre() {
        String nombre = view.pedirNombreProducto();
        for (int i = 0; i < listaInventario.size(); i++) {
            if (listaInventario.get(i).getNombre().equalsIgnoreCase(nombre)) {
                mostrarDetallesProducto(listaInventario.get(i).getCodigo());
                return;
            }
        }
        view.error("Producto no encontrado");
    }

    /**
     * Muestra los detalles de un producto dado su código.
     * 
     * @param codigo El código del producto cuyos detalles se desean mostrar.
     */
    public void mostrarDetallesProducto(String codigo) {
        StringBuilder sbDetallesProducto = new StringBuilder();
        for (int i = 0; i < listaInventario.size(); i++) {
            if (listaInventario.get(i).getCodigo().equals(codigo)) {
                InventarioModel producto = listaInventario.get(i);
                sbDetallesProducto.append("\n---------- Detalles del Producto ----------\n")
                        .append("Codigo: ").append(producto.getCodigo()).append("\n")
                        .append("Nombre: ").append(producto.getNombre()).append("\n")
                        .append("Precio: $").append(producto.getPrecio()).append("\n")
                        .append("Cantidad: ").append(producto.getCantidad()).append("\n")
                        .append("Categoria: ").append(producto.getCategoria()).append("\n")
                        .append("Fecha de vencimiento: ").append(producto.getFechaVencimiento())
                        .append("\n----------------------------");

                // Crear un JTextArea para mostrar los detalles del producto
                JTextArea areaTextoDetallesProducto = new JTextArea(sbDetallesProducto.toString(), 20, 30);
                areaTextoDetallesProducto.setEditable(false);
                areaTextoDetallesProducto.setCaretPosition(0);
                areaTextoDetallesProducto.setWrapStyleWord(true);
                areaTextoDetallesProducto.setLineWrap(true);

                // Crear el JScrollPane para mostrar el textArea
                JScrollPane scrollDetallesProductos = new JScrollPane(areaTextoDetallesProducto);
                scrollDetallesProductos.setPreferredSize(new Dimension(400, 450));

                JOptionPane.showMessageDialog(null, scrollDetallesProductos, "Detalles del producto",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }

    /**
     * Muestra el menú de búsqueda de productos y maneja las opciones seleccionadas
     * por el usuario.
     */
    public void menuBuscar() {
        boolean salir = false;
        while (!salir) {
            int opcion = view.menuBuscarProd();
            switch (opcion) {
                case 1 -> {
                    buscarProductoByNombre();
                    salir = true;
                }
                case 2 -> {
                    buscarProductoByCodigo();
                    salir = true;
                }
                case 3 -> salir = true;
                default -> view.error("Opcion no valida");
            }
        }
    }

    /**
     * Muestra el menú de búsqueda de clientes y maneja las opciones seleccionadas
     * por el usuario.
     */
    public void menuBuscarClientes() {
        boolean salir = false;
        while (!salir) {
            int opcion = view.menuBuscarCliente();
            switch (opcion) {
                case 1 -> {
                    buscarClienteByNombre();
                    salir = true;
                }
                case 2 -> {
                    buscarClienteById();
                    salir = true;
                }
                case 3 -> salir = true;
                default -> view.error("Opcion no valida");
            }
        }
    }

    // corroborar si el id de clienre existe o no
    public boolean corroborarIdCliente(int id) {
        for (int i = 0; i < listaClientes.size(); i++) {
            ClienteModel cliente = listaClientes.get(i);
            if (cliente.getId() == id) {
                //Este Pane no va aqui, va un view.mensaje y dando el mensaje de error
                JOptionPane.showMessageDialog(null, "Ingresa otro ID, ese ya existe");
                return true;
            }
        }
        return false;
    }

    //Corroborar si existe el Codigo de Producto
    public boolean corroborarCodigoProducto(String codigo){
        //listaInventario es la lista de los productos
        for (int i = 0; i < listaInventario.size(); i++){
            InventarioModel producto = listaInventario.get(i);
            if(producto.getCodigo().equals(codigo)){
                JOptionPane.showMessageDialog(null, "Ingresa otro codigo, ese ya existe en otro producto");
                return true;
            }
        }
        return false;
    }
}
// HAcer que solo pueda haber un id del cliente y un codigo de producto