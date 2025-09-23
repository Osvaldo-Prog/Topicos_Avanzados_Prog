package View;

import Controller.SistemaController;

public class Main {
    public static void main(String[] args) {
        SistemaViewJ view = new SistemaViewJ();
        SistemaController controller = new SistemaController(view);
        controller.iniciar();
    }
}
