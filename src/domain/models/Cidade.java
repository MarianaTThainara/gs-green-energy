package domain.models;

import java.util.HashMap;

public class Cidade extends Model {

    private String nome;
    private Estado estado;
    private HashMap<String, Bairro> bairros;

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
        this.bairros = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public HashMap<String, Bairro> getBairros() {
        return bairros;
    }
}