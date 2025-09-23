package PatronBuilder;

public class Orden {
    private String cliente;
    private String bebida;
    private String platilloPrincipal;
    private String postre;
    private boolean paraLlevar;

    private Orden(Builder builder) {
        this.cliente = builder.cliente;
        this.bebida = builder.bebida;
        this.platilloPrincipal = builder.platilloPrincipal;
        this.postre = builder.postre;
        this.paraLlevar = builder.paraLlevar;
    }

    public static class Builder {
        private String cliente;
        private String bebida;
        private String platilloPrincipal;
        private String postre;
        private boolean paraLlevar;

        public Builder setCliente(String cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder setBebida(String bebida) {
            this.bebida = bebida;
            return this;
        }

        public Builder setPlatilloPrincipal(String platilloPrincipal) {
            this.platilloPrincipal = platilloPrincipal;
            return this;
        }

        public Builder setPostre(String postre) {
            this.postre = postre;
            return this;
        }

        public Builder setParaLlevar(boolean paraLlevar) {
            this.paraLlevar = paraLlevar;
            return this;
        }

        public Orden build() {
            return new Orden(this);
        }
    }

    @Override
    public String toString() {
        return "Orden [Cliente: " + cliente +
               ", Bebida: " + bebida +
               ", Platillo: " + platilloPrincipal +
               ", Postre: " + postre +
               ", Para llevar: " + paraLlevar + "]";
    }
}

