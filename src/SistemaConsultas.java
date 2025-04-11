import java.util.ArrayList;

public class SistemaConsultas {
    private ArrayList<Paciente> pacientes;

    public SistemaConsultas() {
        pacientes = new ArrayList<>();
    }

    public void cadastrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
}

