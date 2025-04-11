public class Paciente {
    private String nome;
    private int idade;
    private String cpf;

    public Paciente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return nome + " - CPF: " + cpf + " - Idade: " + idade;
    }
}

