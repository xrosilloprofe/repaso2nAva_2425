import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public abstract class Mascota implements Etiquetaje, Comparable<Mascota>, Serializable {
    public static final Comparator<Mascota> BY_AGE =
            new Comparator<>() {
                @Override
                public int compare(Mascota o1, Mascota o2) {
                    return o1.fechaNac.compareTo(o2.fechaNac);
                }
            };

    private String nombre;
    private LocalDate fechaNac;
    private Sexo sexo;
    protected Map<String,Boolean> vacunas;
    //private Persona duenyo; //esto podría estra de más

    public Mascota(String nombre, LocalDate fechaNac) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        vacunas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public Map<String, Boolean> getVacunas() {
        return vacunas;
    }

    public void setVacunas(Map<String, Boolean> vacunas) {
        this.vacunas = vacunas;
    }

    public abstract void tiposVacunas();

    @Override
    public String etiqueta(){
        return nombre + " " + fechaNac;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", fechaNac=" + fechaNac +
                ", sexo=" + sexo;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Mascota mascota)) return false;
        return Objects.equals(nombre, mascota.nombre) && Objects.equals(fechaNac, mascota.fechaNac);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode()+ fechaNac.hashCode();
    }

    @Override
    public int compareTo(Mascota mascota){
        return nombre.compareTo(mascota.nombre);
    }

}
