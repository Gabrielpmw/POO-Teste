package Model;

public class Equipamento {
    private static int proximoId = 1;
    private final int id;
    private String nome;
    private String grupoMuscular;

    public Equipamento(String nome, String grupoMuscular) {
        this.id = proximoId++;
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
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

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    @Override
    public String toString() {
        return "Equipamento {" +
                "id = " + id +
                ", nome = '" + nome + '\'' +
                ", grupo muscular = '" + grupoMuscular + '\'' +
                '}';
    }
}
