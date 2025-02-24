import java.time.LocalDate;

public class Gato extends Mascota{
    private double peso;

    public Gato(String nombre, LocalDate fechaNac, double peso) {
        super(nombre, fechaNac);
        this.peso=peso;
        tiposVacunas();
    }

    @Override
    public void tiposVacunas() {
        vacunas.put("Trivalente",false);
        vacunas.put("Rabia",false);
    }


}
