class Coche implements Vehiculo {
    private String marca;
    private String modelo;
    
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override 
    public void acelerar(){
        System.out.println("El coche " + marca + " " + modelo + " esta acelerando por la carretera");
    }
    @Override
    public void frenar(){
        System.out.println("El coche esta frenando con sus frenos respectivos");
    }

    @Override
    public void mostrarInfo(){
        System.out.println("🚗 Coche: " + marca + " " + modelo + " tiene 4 ruedas, luces y es de motor a gasolina" );
    }
}
