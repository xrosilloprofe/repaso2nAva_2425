import java.util.Set;
import java.util.TreeSet;

public class Cliente extends Persona{
    private Set<Mascota> mascotas;
    private static int codCliente=0;

    public Cliente(String nombre, String DNI, Set<Mascota> mascotas) {
        super(nombre, DNI);
        codCliente++;
        this.mascotas = mascotas;
    }

    public Set<Mascota> getMascotas() {
        return mascotas;
    }

    public static int getCodCliente() {
        return codCliente;
    }
}
