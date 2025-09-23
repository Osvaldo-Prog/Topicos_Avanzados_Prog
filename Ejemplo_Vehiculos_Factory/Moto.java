class Moto implements Vehiculo {
    private String marca;
    private int cilindrada;

    public Moto(String marca, int cilindrada){
        this.marca = marca;
        this.cilindrada = cilindrada;
    }

    @Override
    public void acelerar(){
        System.out.println("La moto " + marca + " esta acelerando con " + cilindrada + "cc");
    }

    @Override
    public void frenar(){
        System.out.println("La moto está frenando con precaución");
    }

    @Override
    public void mostrarInfo(){
        System.out.println("🏍️ Motocicleta: " + marca + " " + cilindrada + "cc - 2 ruedas, ágil y rápida");
    }
}
