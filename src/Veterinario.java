import java.time.LocalDate;

public class Veterinario extends Persona{
    private int anyosExperiencia;

    public Veterinario(String nombre, String DNI, LocalDate fechaNac, int anyosExperiencia) throws ExcepcionDNI{
        super(nombre, DNI, fechaNac);
        this.anyosExperiencia = anyosExperiencia;
    }

    public int getAnyosExperiencia() {
        return anyosExperiencia;
    }

    @Override
    public String toString() {
        return super.toString() + "anyosExperiencia=" + anyosExperiencia;
    }
}
