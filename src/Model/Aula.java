package Model;

import java.util.List;

public class Aula {
    private static int proximoId = 1;
    private final int id;
    private String nome;
    private String especializacao;
    private Instrutor instrutor;
    private int vaga;
    private List<Cliente> alunos;
    private boolean disponivel;


    private Aula(String nome, String especializacao, Instrutor instrutor, int vaga) {
        this.nome = nome;
        this.especializacao = especializacao;
        this.instrutor = instrutor;
        this.vaga = vaga;
        this.disponivel = true;
        this.id = proximoId++;
    }

    public static Aula registrarAula(String nome, String especializacao, Instrutor instrutor, int vaga){
        if (!instrutor.getEspecializacao().equalsIgnoreCase(especializacao)){
            throw new RuntimeException("Instrutor não especializado");
        }

        return new Aula(nome, especializacao, instrutor, vaga);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public List<Cliente> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Cliente> alunos) {
        this.alunos = alunos;
    }

    public int getVaga() {
        return vaga;
    }

    public void setVaga(int vaga) {
        this.vaga = vaga;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Aula {" +
                "nome = '" + nome + '\'' +
                ", especialização='" + especializacao + '\'' +
                ", quantidade de vagas disponíveis = '" + getVaga() + '\'' +
                ", disponível para inscrição = '" + isDisponivel() + '\'' +
                ", instrutor = " + instrutor + '}';
    }
}
