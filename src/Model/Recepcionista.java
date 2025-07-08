package Model;

public class Recepcionista extends Pessoa{
    public Recepcionista(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public String toString() {
        return "Recepcionista {" +
                "id = " + getId() +
                ", nome = '" + getNome() + '\'' +
                ", cpf = '" + getCpf() + '\'' +
                '}';
    }
}
