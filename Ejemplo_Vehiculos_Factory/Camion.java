class Camion implements Vehiculo{
    private String marca;
    private double capacidadCarga;

    public Camion(String marca, double capacidadCarga){
        this.marca = marca;
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public void acelerar(){
        System.out.println("El camión: " + marca + " está acelerando lentamente con " + capacidadCarga + " toneladas");
    }
    @Override
    public void frenar() {
        System.out.println("El camión está frenando con sistema de frenos neumático");
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("🚛 Camión: " + marca + " - Capacidad: " + capacidadCarga + " toneladas");
    }

}
