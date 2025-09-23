package Model;

/**
 * Clase que representa un cliente.
 */
public class ClienteModel {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private double saldo;

    /**
     * Constructor de la clase ClienteModel.
     *
     * @param id      ID del cliente.
     * @param nombre  Nombre del cliente.
     * @param email   Email del cliente.
     * @param telefono Teléfono del cliente.
     * @param saldo   Saldo del cliente.
     */
    public ClienteModel(int id, String nombre, String email, String telefono, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "\nID: " + id + 
        "\nNombre: " + nombre + 
        "\nEmail: " + email + 
        "\nTelefono: " + telefono +
        "\nSaldo: $" + saldo + "\n---------------------------------";    }

 }
