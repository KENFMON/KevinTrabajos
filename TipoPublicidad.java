public enum TipoPublicidad {
    INTERNET(700000),
    RADIO(200000),
    TELEVISION(600000);

    private final int costoPorVoto;

    TipoPublicidad(int costo) {
        this.costoPorVoto = costo;
    }

    public int getCostoPorVoto() {
        return costoPorVoto;
    }

    @Override
    public String toString() {
        return name();
    }
}