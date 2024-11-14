package domain.models;

import java.time.LocalDateTime;

public class Comunidade extends Model {

    private String nome;
    private String descricao;
    private Bairro bairro;
    private LocalDateTime dataCadastro;

    public Comunidade(String nome, String descricao, Bairro bairro) {
        this.nome = nome;
        this.descricao = descricao;
        this.bairro = bairro;
        this.dataCadastro = LocalDateTime.now();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}
