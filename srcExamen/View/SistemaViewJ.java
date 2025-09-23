package View;

import javax.swing.JOptionPane;

public class SistemaViewJ {
    
    public SistemaViewJ(){

    }

    public String pedirNombre(){
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del cliente");
        return nombre;
    } 

    public String pedirEmail(){
        String email = JOptionPane.showInputDialog("Ingresa el email del cliente");
        return email;
    }

    public String pedirTelefono(){
        String telefono = JOptionPane.showInputDialog("Ingresa el telefono del cliente");
        return telefono;
    }

    public double pedirSaldo(){
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el saldo del cliente"));
        return saldo;
    }

    public String pedirCodigo() {
        String codigo = JOptionPane.showInputDialog("Ingresa el codigo del prodcuto");
        return codigo;
    }

    public int pedirIdCliente(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el ID del Cliente"));
        return id;
    }

    public String pedirNombreProducto(){
        String nombreProduto = JOptionPane.showInputDialog("Ingresa el nombre del producto");
        return nombreProduto;
    }

    public double pedirPrecio(){
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el precio del producto"));
        return precio;
    }

    public int pedirCantidad(){
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de productos"));
        return cantidad;
    }

    public String pedirCategoria(){
        String categoria = JOptionPane.showInputDialog("ingresa la categoria del producto");
        return categoria;
    }

    public String pedirFechaVencimiento(){
        String fechaVencimiento = JOptionPane.showInputDialog("Ingresa la fecha de vencimiento del producto (dd/mm/aaaa)");
        return fechaVencimiento;
    }

    public int menuPrincipal(){
        StringBuilder sbPrincipal = new StringBuilder();
        sbPrincipal.append("====== SISTEMA DE INVENTARIO ======\n Seleccione una opcion\n")
        .append("1.- Gestionar Productos\n")
        .append("2.- Gestionar Clientes\n")
        .append("3.- Guardar y salir\n");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, sbPrincipal.toString(), 
                                "MENU PRINCIPAL", JOptionPane.QUESTION_MESSAGE));
        return opcion;
    }

    public int menuProductos(){
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

    public int menuClientes(){
        StringBuilder sbClientes = new StringBuilder();
        sbClientes.append("===== GESTION DE CLIENTES =====\n")
        .append("1.- Agregar Cliente\n")
        .append("2.- Modificar Cliente\n")
        .append("3.- Eliminar Cliente\n")
        .append("4.- Listar Clientes\n")
        .append("5.- Buscar CLiente\n")
        .append("6.- Volver al menu principal");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciona una de las siguientes opciones\n\n" + 
        sbClientes.toString(), "MENU GESTOR DE CLIENTES", JOptionPane.QUESTION_MESSAGE));
        return opcion;
    }

    public void menuDespedida(){
        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
    }

    public int menuBuscarProd(){
        StringBuilder sbBuscaProd = new StringBuilder();
        sbBuscaProd.append("1.- Buscar por nombre\n")
        .append("2.- Buscar por codigo\n")
        .append("3.- Salir\n");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciona una opcion\n\n" + 
        sbBuscaProd.toString(), "SubMenu de Busqueda de productos", JOptionPane.QUESTION_MESSAGE));
        return opcion;
    }


    public int menuBuscarCliente(){
        StringBuilder sbBuscarCLiente = new StringBuilder();
        sbBuscarCLiente.append("1.- Buscar por nombre\n")
        .append("2.- Buscar por ID\n")
        .append("3.- Salir");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciona una opcion\n\n" + 
        sbBuscarCLiente.toString(), "Menu de busqueda de productos", JOptionPane.QUESTION_MESSAGE));
        return opcion;
    }

    //Este metodo lo quite para usar el JOptionPane de todos los menus, pero lo deje en opciones especificas
    public int leerOpcion(){
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Selecciona una opcion"));
         return opcion;
    }
    

    public void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void error(String mensaje){
        JOptionPane.showMessageDialog(null, "ERROR: " + mensaje);
    }

    public String confirmacion(){
        String confimar = JOptionPane.showInputDialog(("Desea eliminar este cliente? (s/n): "));
        return confimar;
    }
}


