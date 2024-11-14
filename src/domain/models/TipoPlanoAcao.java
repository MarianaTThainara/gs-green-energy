package domain.models;

import domain.enums.PrioridadeTipoPlanoAcaoEnum;

public class TipoPlanoAcao extends Model {

    private String nome;
    private PrioridadeTipoPlanoAcaoEnum prioridade;
    private String descricao;

    public TipoPlanoAcao(String nome, String descricao, PrioridadeTipoPlanoAcaoEnum prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
