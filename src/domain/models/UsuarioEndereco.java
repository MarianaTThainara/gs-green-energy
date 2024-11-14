package domain.models;

public class UsuarioEndereco extends Model {

    private Bairro bairro;
    private String logradouro;
    private String numero;
    private String complemento;

    public UsuarioEndereco(Bairro bairro, String logradouro, String numero, String complemento) {
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public UsuarioEndereco(Bairro bairro, String logradouro, String numero) {
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }
}
