import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaListaPacientes extends JFrame {
    private SistemaConsultas sistema;

    public TelaListaPacientes(SistemaConsultas sistema) {
        super("Lista de Pacientes");
        this.sistema = sistema;

        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea areaPacientes = new JTextArea();
        areaPacientes.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaPacientes);

        ArrayList<Paciente> lista = sistema.getPacientes();
        if (lista.isEmpty()) {
            areaPacientes.setText("Nenhum paciente cadastrado.");
        } else {
            for (Paciente p : lista) {
                areaPacientes.append(p.toString() + "\n");
            }
        }

        add(scroll, BorderLayout.CENTER);
        setVisible(true);
    }
}
