package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    private static int proximoId = 1;
    private final int id;
    private Pessoa pessoa;
    private List<Pessoa> pessoas = new ArrayList<>();

    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.id = proximoId++;
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
