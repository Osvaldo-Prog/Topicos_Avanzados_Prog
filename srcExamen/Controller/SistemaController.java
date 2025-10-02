package Controller;
/*  ~Stretegy con parametro global para switchear enre interfaz grafica y consola con strategy
    ~mover los textArea y JSCROLL A LA VISTA, ESO NO DEBE ESTAR EN EL CONTROLADOR, en pocas palabras, no poner ningunJOptionPane o sout en el controllador*/
/* Cambios hechos aqui, quitar los JOptionPane y pasarlos a SistemaViewJ 
 * con ese cambio se creo la interface ViewGlobal (Strategy) que tiene todos los metodos para asi decidir que estrategia de vista usará
 * metodos modificados que tenian el JOptionPane aqui -> listarClientes();, listarProductos();, mostrarDetalleCliente();, mostrarDetalleProducto();
 *
*/

import Model.ClienteModel;
import Model.InventarioModel;
import Model.ListaGenerica;
import View.SistemaViewJ;
//import View.SistemaView;
//import View.SistemaViewJ;
import View.ViewGlobal;

public class SistemaController {
    private final ListaGenerica<InventarioModel> listaInventario;
    private final ListaGenerica<ClienteModel> listaClientes;
    private final ViewGlobal view;

    public SistemaController(ViewGlobal view) {
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
            if (listaInventario.get(i).getCodigo().equals(codigo)) {
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
                break;
            } else {
                view.error("Producto no encontrado");
            }
        }
    }

    /**
     * Lista todos los clientes registrados en el sistema.
     * se añadió una condicion para saber si se esta trabajando con la view de consola o la de GUI
     * el instanceof es un operador para definir el tipo de view con el que se esta trabajando,
     * la condicion dice que si es la view es la de SistemaViewJ se usara la GUI y si no la de consola, es decir el SistemView 
     */
    public void listarClientes() {
        if(view instanceof SistemaViewJ){
            view.listadoClientes(listaClientes);
        }else{
        System.out.println(view.listadoClientes(listaClientes));
        }
    }

    /**
     * Lista todos los productos en el inventario.
     */
    public void listarProductos() {
        if(view instanceof SistemaViewJ){
        view.listadoProductos(listaInventario);
        }else{
            System.out.println(view.listadoProductos(listaInventario));
        }
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
     * @param id El ID del cliente cuyos detalles se desean mostrar.
     * @param listaClientes es la lista de los clientes pero en este caso en la lista solo se mostrará el cliente cuyo ID se ingreso
     */
    public void mostrarDetallesCliente(int id) {
        if(view instanceof SistemaViewJ){
        view.mostrarDetalleCliente(listaClientes, id);
        }else{
            System.out.println(view.mostrarDetalleCliente(listaClientes, id));
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
        if(view instanceof SistemaViewJ){
       view.mostrarDetallesProducto(listaInventario, codigo);
        }else{
            System.out.println(view.mostrarDetallesProducto(listaInventario, codigo));
        }
    }

    /**
     * Muestra el menú de búsqueda de productos y maneja las opciones seleccionadas
     * por el usuario.
     */
    public void menuBuscar() {
        boolean salir = false;
        while (!salir) {
            int opcion = view.menuBuscarProductos();
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
                view.error("Error, el ID ya existe, ingresa otro");
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
                view.error("Error, el codigo de producto ya es existente, ingresa otro");
                return true;
            }
        }
        return false;
    }
}
// HAcer que solo pueda haber un id del cliente y un codigo de producto