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
    private float creditosVerde;
    private double consumoAnterior = 0.0;
    private double consumoAtual = 0.0;

    public Usuario(String nome, String sobrenome, Long cpf, String email, String senha, HashMap<String, UsuarioEndereco> enderecos) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.enderecos = enderecos;
        this.comunidades = new HashMap<>();
        this.creditosVerde = 0f;
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

    public float getCreditosVerde() {
        return creditosVerde;
    }

    public void setCreditosVerde(float creditosVerde) {
        this.creditosVerde = creditosVerde;
    }

    public double getConsumoAnterior() { return consumoAnterior; }

    public void setConsumoAnterior(double consumoAnterior) { this.consumoAnterior = consumoAnterior; }

    public double getConsumoAtual() { return consumoAtual; }

    public void setConsumoAtual(double consumoAtual) { this.consumoAtual = consumoAtual; }

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
