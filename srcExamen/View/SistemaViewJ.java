package View;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.ClienteModel;
import Model.InventarioModel;
import Model.ListaGenerica;

import java.awt.Dimension;

public class SistemaViewJ implements ViewGlobal {

    public SistemaViewJ() {

    }

    @Override
    public String pedirNombre() {
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del cliente");
        return nombre;
    }

    @Override
    public String pedirEmail() {
        String email = JOptionPane.showInputDialog("Ingresa el email del cliente");
        return email;
    }

    @Override
    public String pedirTelefono() {
        String telefono = JOptionPane.showInputDialog("Ingresa el telefono del cliente");
        return telefono;
    }

    @Override
    public double pedirSaldo() {
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el saldo del cliente"));
        return saldo;
    }

    @Override
    public String pedirCodigo() {
        String codigo = JOptionPane.showInputDialog("Ingresa el codigo del prodcuto");
        return codigo;
    }

    @Override
    public int pedirIdCliente() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el ID del Cliente"));
        return id;
    }

    @Override
    public String pedirNombreProducto() {
        String nombreProduto = JOptionPane.showInputDialog("Ingresa el nombre del producto");
        return nombreProduto;
    }

    @Override
    public double pedirPrecio() {
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el precio del producto"));
        return precio;
    }

    @Override
    public int pedirCantidad() {
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de productos"));
        return cantidad;
    }

    @Override
    public String pedirCategoria() {
        String categoria = JOptionPane.showInputDialog("ingresa la categoria del producto");
        return categoria;
    }

    @Override
    public String pedirFechaVencimiento() {
        String fechaVencimiento = JOptionPane
                .showInputDialog("Ingresa la fecha de vencimiento del producto (dd/mm/aaaa)");
        return fechaVencimiento;
    }

    @Override
    public int menuPrincipal() {
        StringBuilder sbPrincipal = new StringBuilder();
        sbPrincipal.append("====== SISTEMA DE INVENTARIO ======\n Seleccione una opcion\n")
                .append("1.- Gestionar Productos\n")
                .append("2.- Gestionar Clientes\n")
                .append("3.- Guardar y salir\n");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, sbPrincipal.toString(),
                "MENU PRINCIPAL", JOptionPane.QUESTION_MESSAGE));
        return opcion;
    }

    @Override
    public int menuProductos() {
        StringBuilder sbProducto = new StringBuilder();
        sbProducto.append("===== GESTION DE PRODUCTOS =====\n")
                .append("1.- Agregar un producto\n")
                .append("2.- Modificar un producto\n")
                .append("3.- Eliminar un producto\n")
                .append("4.- Listar productos\n")
                .append("5.- Buscar producto\n")
                .append("6.- Volver al menu principal\n");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciona una opcion\n\n" +
                sbProducto.toString(), "MENU GESTOR DE PRODUCTOS", JOptionPane.QUESTION_MESSAGE));
        return opcion;
    }

    @Override
    public int menuClientes() {
        StringBuilder sbClientes = new StringBuilder();
        sbClientes.append("===== GESTION DE CLIENTES =====\n")
                .append("1.- Agregar Cliente\n")
                .append("2.- Modificar Cliente\n")
                .append("3.- Eliminar Cliente\n")
                .append("4.- Listar Clientes\n")
                .append("5.- Buscar CLiente\n")
                .append("6.- Volver al menu principal");
        int opcion = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Selecciona una de las siguientes opciones\n\n" +
                        sbClientes.toString(), "MENU GESTOR DE CLIENTES", JOptionPane.QUESTION_MESSAGE));
        return opcion;
    }

    @Override
    public void menuDespedida() {
        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
    }

    @Override
    public int menuBuscarProductos() {
        StringBuilder sbBuscaProd = new StringBuilder();
        sbBuscaProd.append("1.- Buscar por nombre\n")
                .append("2.- Buscar por codigo\n")
                .append("3.- Salir\n");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciona una opcion\n\n" +
                sbBuscaProd.toString(), "SubMenu de Busqueda de productos", JOptionPane.QUESTION_MESSAGE));
        return opcion;
    }

    @Override
    public int menuBuscarCliente() {
        StringBuilder sbBuscarCLiente = new StringBuilder();
        sbBuscarCLiente.append("1.- Buscar por nombre\n")
                .append("2.- Buscar por ID\n")
                .append("3.- Salir");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciona una opcion\n\n" +
                sbBuscarCLiente.toString(), "Menu de busqueda de productos", JOptionPane.QUESTION_MESSAGE));
        return opcion;
    }

    @Override
    // Este metodo lo quite para usar el JOptionPane de todos los menus, pero lo
    // deje en opciones especificas
    public int leerOpcion() {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Selecciona una opcion"));
        return opcion;
    }

    @Override
    public void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @Override
    public void error(String mensaje) {
        JOptionPane.showMessageDialog(null, "ERROR: " + mensaje);
    }

    @Override
    public String confirmacion() {
        String confimar = JOptionPane.showInputDialog(("Desea eliminar este cliente? (s/n): "));
        return confimar;
    }

    @Override
    /*  -----------------CAMBIAR A METODO TOSTRING Y CON SCROLL PARA MOSTRAR LA LISTA
    Se creo un JTextArea y un JScrollPane para mostrar la lista en una sola
    ventana y lo mismo con la lista de productos
    Se paso el metodo completo del controllador aqui pero con la diferencia de los parametros, todos los metodos desde este hacia abajo fueron movidos del contorllador a esta clase view
    */

    public String listadoClientes(ListaGenerica<ClienteModel> listaClientes) {
        StringBuilder sbListaClientes = new StringBuilder();
        sbListaClientes.append("                     =====Lista de Clientes=====\n");
        for (int i = 0; i < listaClientes.size(); i++) {
            ClienteModel cliente = listaClientes.get(i);
            sbListaClientes.append((i + 1)).append(". ").append(cliente.toString()).append("\n");
        }
        // Crear el area de texto
        JTextArea areaTextoClientes = new JTextArea(sbListaClientes.toString(), 10, 30);
        areaTextoClientes.setEditable(false);// Para que no sea editable
        areaTextoClientes.setCaretPosition(0);// Para inicar desde el inicio
        areaTextoClientes.setLineWrap(true); // para que las líneas no se corten, hace que salte de linea si el texto supera el ancho visible (Sin scroll horizontal)
        areaTextoClientes.setWrapStyleWord(true);//Para que las palabras no se corten en el salto de linea por si no cbane en el ancho del area de texto
        
        // Crear la ventana Scrolleable
        JScrollPane ventanaScroll = new JScrollPane(areaTextoClientes);
        ventanaScroll.setPreferredSize(new Dimension(300, 250));

        JOptionPane.showMessageDialog(null, ventanaScroll, "Lista de clientes", JOptionPane.INFORMATION_MESSAGE);
        return sbListaClientes.toString();
    }

    @Override
    public String listadoProductos(ListaGenerica<InventarioModel> listaInventario) {
        StringBuilder sbListaProductos = new StringBuilder();
        sbListaProductos.append("                       ----------- Lista de Productos -----------\n");
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
        return sbListaProductos.toString();
    }

    @Override
    public String mostrarDetalleCliente(ListaGenerica<ClienteModel> listaClientes, int id) {
        StringBuilder sbDetallesCliente = new StringBuilder();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getId() == id) {
                ClienteModel cliente = listaClientes.get(i);
                sbDetallesCliente.append("\n        ---------- Detalles del Cliente ----------\n")
                        .append("ID: ").append(cliente.getId()).append("\n")
                        .append("Nombre: ").append(cliente.getNombre()).append("\n")
                        .append("Email: ").append(cliente.getEmail()).append("\n")
                        .append("Telefono: ").append(cliente.getTelefono()).append("\n")
                        .append("Saldo: ").append(cliente.getSaldo()).append("\n-------------------------------------------");

                // Crear un textArea para guardar la informacion
                JTextArea areaTextoDetallesCliente = new JTextArea(sbDetallesCliente.toString(), 10, 10);
                areaTextoDetallesCliente.setEditable(false);
                areaTextoDetallesCliente.setCaretPosition(0);
                areaTextoDetallesCliente.setWrapStyleWord(true);
                areaTextoDetallesCliente.setLineWrap(true);

                // Crear un ScrollPane para mostarlo
                JScrollPane scrollPaneDetallesCliente = new JScrollPane(areaTextoDetallesCliente);
                scrollPaneDetallesCliente.setPreferredSize(new Dimension(250, 200));

                JOptionPane.showMessageDialog(null, scrollPaneDetallesCliente, "Detalles del cliente",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
        return sbDetallesCliente.toString();
    }

    @Override
    public String mostrarDetallesProducto(ListaGenerica<InventarioModel> listaInventario, String codigo) {
        StringBuilder sbDetallesProducto = new StringBuilder();
        for (int i = 0; i < listaInventario.size(); i++) {
            if (listaInventario.get(i).getCodigo().equals(codigo)) {
                InventarioModel producto = listaInventario.get(i);
                sbDetallesProducto.append("\n       ---------- Detalles del Producto ----------\n")
                        .append("Codigo: ").append(producto.getCodigo()).append("\n")
                        .append("Nombre: ").append(producto.getNombre()).append("\n")
                        .append("Precio: $").append(producto.getPrecio()).append("\n")
                        .append("Cantidad: ").append(producto.getCantidad()).append("\n")
                        .append("Categoria: ").append(producto.getCategoria()).append("\n")
                        .append("Fecha de vencimiento: ").append(producto.getFechaVencimiento())
                        .append("\n----------------------------");

                // Crear un JTextArea para mostrar los detalles del producto
                JTextArea areaTextoDetallesProducto = new JTextArea(sbDetallesProducto.toString(), 15, 15);
                areaTextoDetallesProducto.setEditable(false);
                areaTextoDetallesProducto.setCaretPosition(0);
                areaTextoDetallesProducto.setWrapStyleWord(true);
                areaTextoDetallesProducto.setLineWrap(true);

                // Crear el JScrollPane para mostrar el textArea
                JScrollPane scrollDetallesProductos = new JScrollPane(areaTextoDetallesProducto);
                scrollDetallesProductos.setPreferredSize(new Dimension(250, 300));

                JOptionPane.showMessageDialog(null, scrollDetallesProductos, "Detalles del producto",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
        return sbDetallesProducto.toString();
    }
}
