package domain.models;

public class MercadoVerdeProduto extends Model {

    private String nome;
    private float precoVerde;

    public MercadoVerdeProduto(String nome, float precoVerde) {
        this.nome = nome;
        this.precoVerde = precoVerde;
    }

    public String getNome() {
        return nome;
    }

    public float getPrecoVerde() {
        return precoVerde;
    }
}
