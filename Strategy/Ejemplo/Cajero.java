package Strategy.Ejemplo;

public class Cajero {
    public static void main(String[] args) {
        CarritoCompras carrito = new CarritoCompras();

        carrito.setEstrategiaPago(new PagoTarjeta());
        carrito.realizarPago(150.75);

        carrito.setEstrategiaPago(new PagoEfectivo());
        carrito.realizarPago(89.99);

        carrito.setEstrategiaPago(new PagoTransferencia());
        carrito.realizarPago(250.00);
    }
}

