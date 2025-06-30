package Model;

public class Instrutor extends Pessoa{
    private String especializacao;

    public Instrutor(String nome, String cpf, String especializacao) {
        super(nome, cpf);
        this.especializacao = especializacao;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    @Override
    public String toString() {
        return "Instrutor {" +
                "id = " + getId() +
                ", nome = '" + getNome() + '\'' +
                ", cpf = '" + getCpf() + '\'' +
                ", especialização = '" + getEspecializacao() + '\'' +
                '}';
    }
}
