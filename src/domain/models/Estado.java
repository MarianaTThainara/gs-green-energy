package domain.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Estado extends Model {

    private String nome;
    private String sigla;
    private String codigoIbge;
    private HashMap<String, Cidade> cidades;

    public Estado(String nome, String sigla, String codigoIbge) {
        this.nome = nome;
        this.sigla = sigla;
        this.codigoIbge = codigoIbge;
        this.cidades = new HashMap<>();
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

    public HashMap<String, Cidade> getCidades() {
        return cidades;
    }
}
