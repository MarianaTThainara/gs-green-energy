package domain.models;

public class Estado extends Model {

    private String nome;
    private String sigla;
    private String codigoIbge;

    public Estado(String nome, String sigla, String codigoIbge) {
        this.nome = nome;
        this.sigla = sigla;
        this.codigoIbge = codigoIbge;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getCodigoIbge() {
        return codigoIbge;
    }
}
