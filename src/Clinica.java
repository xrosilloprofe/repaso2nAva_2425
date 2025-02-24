import java.util.*;

public class Clinica {

    private List<Veterinario> veterinarios;
    private Set<Cliente> clientes;

    public Clinica(){
        veterinarios = new ArrayList<>();
        clientes = new HashSet<>();
    }

    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void setVeterinarios(List<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
}
