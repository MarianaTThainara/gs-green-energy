package domain.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Comunidade extends Model {

    private String nome;
    private String descricao;
    private Bairro bairro;
    private LocalDateTime dataCadastro;
    private HashMap<String, Usuario> usuarios;

    public Comunidade(String nome, String descricao, Bairro bairro) {
        this.nome = nome;
        this.descricao = descricao;
        this.bairro = bairro;
        this.dataCadastro = LocalDateTime.now();
        this.usuarios = new HashMap<>();
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

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
