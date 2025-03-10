import java.time.LocalDate;

public abstract class Persona implements Etiquetaje{
    public static final String CONSTANTEHUMANA = "Humano";

    //Atributos
    private String nombre;
    private String DNI;
    private LocalDate fechaNac;
    private Sexo sexo;

    //Constructores
    public Persona(String nombre, String DNI) throws ExcepcionDNI{
        this.nombre = nombre;
        if(DNI.length()==0) throw new ExcepcionDNI("sin DNI");
        this.DNI = DNI;
    }

    public Persona(String nombre, String DNI, LocalDate fechaNac) throws ExcepcionDNI{
        this(nombre, DNI);
        this.fechaNac = fechaNac;
    }

    //Getter
    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    //Setter
    public void setFechaNac(LocalDate fechaNac){
        this.fechaNac=fechaNac;
    }

    @Override
    public String etiqueta(){
        return nombre + " " + fechaNac;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", fechaNac=" + fechaNac;
    }
}
