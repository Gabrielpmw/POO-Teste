package Model;

public enum TipoPlano {
    BASIC("basic" ,"Acesso apenas à musculação", 80.0),
    PREMIUM("premium", "acesso a musculação e aulas em grupo0", 100.0),
    ULTIMATE("ultimate", "acesso total, incluindo áreas especiais", 150.0);

    private String nome;
    private String descricao;
    private double valor;

    TipoPlano(String nome, String descricao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}
