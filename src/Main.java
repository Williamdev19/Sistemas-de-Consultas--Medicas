import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private SistemaConsultas sistema;

    public Main() {
        super("Sistema de Consultas Médicas");
        sistema = new SistemaConsultas();

        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(4, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Menu Principal", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnCadastro = new JButton("Cadastrar Paciente");
        JButton btnListar = new JButton("Listar Pacientes");
        JButton btnAgendar = new JButton("Agendar Consulta");

        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroPaciente(sistema);
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaListaPacientes(sistema);
            }
        });

        btnAgendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaAgendamentoConsulta(sistema);
            }
        });

        painel.add(titulo);
        painel.add(btnCadastro);
        painel.add(btnListar);
        painel.add(btnAgendar);

        add(painel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
