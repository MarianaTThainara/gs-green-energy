package domain.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comunidade extends Model {

    private String nome;
    private String descricao;
    private Bairro bairro;
    private LocalDateTime dataCadastro;
    private List<Usuario> usuarios; // Lista de usuários

    public Comunidade(String nome, String descricao, Bairro bairro) {
        this.nome = nome;
        this.descricao = descricao;
        this.bairro = bairro;
        this.dataCadastro = LocalDateTime.now();
        this.usuarios = new ArrayList<>(); // Inicializa a lista de usuários
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

    public List<Usuario> getUsuarios() { return usuarios; }

    public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }
}
