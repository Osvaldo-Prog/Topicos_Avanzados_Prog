package ATM.Controllers;

import ATM.Views.CajeroView;
import ATM.CajeroModel;
import ATM.Strategy.*;

public class CajeroController {

    private CajeroModel model;
    private CajeroView view;
    private boolean sistemaActivo;
    private Operacion operacion;

    public CajeroController(CajeroModel model, CajeroView view) {
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
    }

    public void iniciarSistema() {
        view.mostrarBienvenida();
        while (sistemaActivo) {
            if (autenticarUsuario()) {
                ejecutarMenuPrincipal();
            } else {
                view.mostrarMensaje("Credenciales incorrectas");
            }
        }
        view.mostrarMensaje("Gracias por usar nuestro cajero, esperamos tu regreso");
    }

    private boolean autenticarUsuario() {
        String numeroCuenta = view.solicitarNumeroCuenta();
        String pin = view.solicitarPin();
        return model.autenticar(numeroCuenta, pin);
    }

    private void ejecutarMenuPrincipal() {
        boolean sesionActiva = true;
        while (sesionActiva) {
            view.mostrarMenuPrincipal(model.getCuentaActual().getTitular());
            int opcion = view.leerOpcion();

            switch (opcion) {
                case 1:
                    setOperacion(new ConsultarSaldo());
                    ejecutarOperacion(0, null);
                    break;
                case 2:
                    double montoRetiro = view.solicitarCantidad("Retiro");
                    setOperacion(new Retiro());
                    ejecutarOperacion(montoRetiro, null);
                    break;
                case 3:
                    double montoDeposito = view.solicitarCantidad("Depósito");
                    setOperacion(new Deposito());
                    ejecutarOperacion(montoDeposito, null);
                    break;
                case 4:
                    String cuentaDestino = view.solicitarCuentaDestino();
                    double montoTransferencia = view.solicitarCantidad("Transferencia");
                    setOperacion(new Transferencia());
                    ejecutarOperacion(montoTransferencia, cuentaDestino);
                    break;
                case 5:
                    String pinActual = view.solicitarPinActual();
                    String nuevoPin = view.solicitarNuevoPin();
                    setOperacion(new CambiarNip());
                    ejecutarOperacionCambioPin(pinActual, nuevoPin);
                    break;
                case 6:
                    sesionActiva = false;
                    sistemaActivo = false;
                    break;
                default:
                    view.mostrarMensaje("Opción inválida");
            }
        }
    }

    public void setOperacion(Operacion operacion) { this.operacion = operacion; }

    public void ejecutarOperacion(double monto, String cuentaDestino) {
        if (operacion != null)
            operacion.ejecutar(model.getCuentaActual(), monto, cuentaDestino, model, view);
        else
            view.mostrarError("No hay operación seleccionada.");
    }

    public void ejecutarOperacionCambioPin(String pinActual, String nuevoPin) {
        if (operacion != null)
            operacion.ejecutarCambioPin(model.getCuentaActual(), pinActual, nuevoPin, model, view);
        else
            view.mostrarError("No hay operación seleccionada.");
    }
}
