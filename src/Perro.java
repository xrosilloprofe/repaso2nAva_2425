import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Perro extends Mascota {
    private String raza;


    public Perro(String nombre, LocalDate fechaNac, String raza) {
        super(nombre, fechaNac);
        this.raza=raza;
    }

    public String getRaza() {
        return raza;
    }

    @Override
    public void tiposVacunas() {
        vacunas.put("Rabia",false);
        vacunas.put("Lesmaniosis",false);
    }

    @Override
    public String toString() {
        return super.toString() +
                "raza='" + raza + '\'';
    }
}
