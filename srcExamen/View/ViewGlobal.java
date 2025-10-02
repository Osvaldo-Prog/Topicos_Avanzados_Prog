package View;
//se creó la clase interface para poder elegir entre la estrategia de la interfaz grafica o la consola
import Model.ClienteModel;
import Model.InventarioModel;
import Model.ListaGenerica;

public interface ViewGlobal {
    //Metodos de cliente
    String pedirNombre();
    String pedirEmail();
    String pedirTelefono();
    double pedirSaldo();
    String pedirCodigo();
    int pedirIdCliente();
    int menuBuscarCliente();
    String listadoClientes(ListaGenerica<ClienteModel> listaClientes);
    String mostrarDetalleCliente(ListaGenerica<ClienteModel> listaClientes, int id);

    //metodos de productos
    String pedirNombreProducto();
    double pedirPrecio();
    int pedirCantidad();
    String pedirCategoria();
    String pedirFechaVencimiento();
    int menuBuscarProductos();
    String listadoProductos(ListaGenerica<InventarioModel> listaInventario);
    String mostrarDetallesProducto(ListaGenerica<InventarioModel> listaInventario, String codigo);

    //Metodos de la vista
    int menuPrincipal();
    int menuProductos();
    int menuClientes();
    void menuDespedida();
    int leerOpcion();
    void mensaje(String mensaje);
    void error(String mensaje);
    String confirmacion();

}
