public enum Sexo {

    FEMENINO("Hembra"),
    MASCULINO("Macho");

    private String tipo;

    Sexo(String tipo){ this.tipo=tipo;}

    public String getTipo() {
        return tipo;
    }
}
