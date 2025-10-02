package ATM;

public class Cuenta {

    private String numeroCuenta;
    private String pin;
    private double saldo;
    private String titular;

    private Cuenta(CuentaBuilder builder) {
        this.numeroCuenta = builder.numeroCuenta;
        this.pin = builder.pin;
        this.saldo = builder.saldo;
        this.titular = builder.titular;
    }

    public String getNumeroCuenta() { 
        return numeroCuenta; }
        
    public String getPin() {
         return pin; }

    public double getSaldo() { 
        return saldo; }

    public String getTitular() {
         return titular; }

    public boolean validarPin(String pinIngresado) { return this.pin.equals(pinIngresado); }
    public void setPin(String nuevoPin) { this.pin = nuevoPin; }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) saldo += cantidad;
    }

    public void transferir(double cantidad) {
        saldo -= cantidad;
    }

    // Patron builder para la cuenta
    public static class CuentaBuilder {
        private String numeroCuenta;
        private String pin;
        private double saldo;
        private String titular;

        public CuentaBuilder numeroCuenta(String numeroCuenta) { 
            this.numeroCuenta = numeroCuenta; return this; }

        public CuentaBuilder pin(String pin) { 
            this.pin = pin; return this; }

        public CuentaBuilder saldo(double saldo) { 
            this.saldo = saldo; return this; }

        public CuentaBuilder titular(String titular) { 
            this.titular = titular; return this; }

        public Cuenta build() { 
            return new Cuenta(this); }
    }
}
