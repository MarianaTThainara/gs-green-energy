package domain.models;

import domain.repositories.Repository;

import java.util.HashMap;

public class Usuario extends Model {

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Long cpf;
    private HashMap<String, UsuarioEndereco> enderecos;
    private HashMap<String, Comunidade> comunidades;
    private int creditosVerde;

    public Usuario(String nome, String sobrenome, Long cpf, String email, String senha, HashMap<String, UsuarioEndereco> enderecos) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.enderecos = enderecos;
        this.comunidades = new HashMap<>();
        this.creditosVerde = 0;
    }

    public void adicionarCreditosVerde(int pontos) {
        this.creditosVerde += pontos;
    }

    public void removerCreditosVerde(int pontos) {
        if (this.creditosVerde >= pontos) {
            this.creditosVerde -= pontos;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public Long getCpf() {
        return cpf;
    }

    public HashMap<String, Comunidade> getComunidades() {
        return comunidades;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf=" + cpf +
                ", enderecos=" + enderecos +
                '}';
    }
}
