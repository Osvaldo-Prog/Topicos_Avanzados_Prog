class Bicicleta implements Vehiculo {
    private String tipo;
    private int numVelocidades;
    
    public Bicicleta(String tipo, int numVelocidades) {
        this.tipo = tipo;
        this.numVelocidades = numVelocidades;
    }
    
    @Override
    public void acelerar() {
        System.out.println("La bicicleta " + tipo + " está siendo pedaleada");
    }
    
    @Override
    public void frenar() {
        System.out.println("La bicicleta está frenando con frenos de mano");
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("🚲 Bicicleta: " + tipo + " - " + numVelocidades + " velocidades, ecológica");
    }

}
