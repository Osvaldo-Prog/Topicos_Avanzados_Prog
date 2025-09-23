package PatronBuilder;

public class Main {
    public static void main(String[] args) {
        Orden orden1 = new Orden.Builder()
                        .setCliente("Juan Pérez")
                        .setBebida("Coca-Cola")
                        .setPlatilloPrincipal("Hamburguesa doble")
                        .setPostre("Helado de vainilla")
                        .setParaLlevar(true)
                        .build();

        Orden orden2 = new Orden.Builder()
                        .setCliente("María López")
                        .setPlatilloPrincipal("Pizza margarita")
                        .build();

        System.out.println(orden1);
        System.out.println(orden2);
    }
}
