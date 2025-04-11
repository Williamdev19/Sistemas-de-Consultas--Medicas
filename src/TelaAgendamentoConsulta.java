import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAgendamentoConsulta extends JFrame {
    private SistemaConsultas sistema;
    private JComboBox<String> comboPacientes;
    private JTextField campoData, campoHora;
    private JButton btnAgendar;

    public TelaAgendamentoConsulta(SistemaConsultas sistema) {
        super("Agendar Consulta");
        this.sistema = sistema;

        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblPaciente = new JLabel("Paciente:");
        comboPacientes = new JComboBox<>();

        for (Paciente p : sistema.getPacientes()) {
            comboPacientes.addItem(p.getNome() + " - " + p.getCpf());
        }

        JLabel lblData = new JLabel("Data (dd/mm/aaaa):");
        campoData = new JTextField();

        JLabel lblHora = new JLabel("Hora (hh:mm):");
        campoHora = new JTextField();

        btnAgendar = new JButton("Agendar");
        btnAgendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agendarConsulta();
            }
        });

        painel.add(lblPaciente);
        painel.add(comboPacientes);
        painel.add(lblData);
        painel.add(campoData);
        painel.add(lblHora);
        painel.add(campoHora);
        painel.add(new JLabel());
        painel.add(btnAgendar);

        add(painel);
        setVisible(true);
    }

    private void agendarConsulta() {
        if (comboPacientes.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum paciente disponível.");
            return;
        }

        String pacienteSelecionado = (String) comboPacientes.getSelectedItem();
        String data = campoData.getText();
        String hora = campoHora.getText();

        JOptionPane.showMessageDialog(this, "Consulta agendada para " + pacienteSelecionado + "\nData: " + data + " às " + hora);
        campoData.setText("");
        campoHora.setText("");
    }
}
