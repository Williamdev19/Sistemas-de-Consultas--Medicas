import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroPaciente extends JFrame {
    private JTextField campoNome, campoIdade, campoCPF;
    private JButton btnCadastrar;
    private SistemaConsultas sistema;

    public TelaCadastroPaciente(SistemaConsultas sistema) {
        super("Cadastro de Paciente");
        this.sistema = sistema; // Agora está correto!

        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painel.add(new JLabel("Nome:"));
        campoNome = new JTextField();
        painel.add(campoNome);

        painel.add(new JLabel("Idade:"));
        campoIdade = new JTextField();
        painel.add(campoIdade);

        painel.add(new JLabel("CPF:"));
        campoCPF = new JTextField();
        painel.add(campoCPF);

        btnCadastrar = new JButton("Cadastrar Paciente");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPaciente();
            }
        });

        painel.add(new JLabel()); // Espaço vazio
        painel.add(btnCadastrar);

        add(painel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void cadastrarPaciente() {
        String nome = campoNome.getText().trim();
        String idadeStr = campoIdade.getText().trim();
        String cpf = campoCPF.getText().trim();

        if (nome.isEmpty() || idadeStr.isEmpty() || cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade inválida! Insira um número.");
            return;
        }

        Paciente paciente = new Paciente(nome, idade, cpf);
        sistema.cadastrarPaciente(paciente);
        JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!");

        campoNome.setText("");
        campoIdade.setText("");
        campoCPF.setText("");
    }
}
