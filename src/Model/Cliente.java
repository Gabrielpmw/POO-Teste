package Model;

public class Cliente extends Pessoa{
    TipoPlano tipoPlano;
    private boolean status;

    public Cliente(String nome, String cpf, TipoPlano tipoPlano, boolean status) {
        super(nome, cpf);
        this.tipoPlano = tipoPlano;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "id = " + getId() +
                ", nome = '" + getNome() + '\'' +
                ", cpf = '" + getCpf() + '\'' +
                ", plano = '" + getTipoPlano().getNome() + '\'' +
                ", ativo = '" + status + '\'' +
                '}';
    }

    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(TipoPlano tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
