package domain.models;

import domain.enums.GrupoPlanoAcaoEnum;
import domain.enums.PrioridadeTipoPlanoAcaoEnum;

public class TipoPlanoAcao extends Model {

    private String nome;
    private PrioridadeTipoPlanoAcaoEnum prioridade;
    private GrupoPlanoAcaoEnum grupo;
    private String descricao;

    public TipoPlanoAcao(String nome, PrioridadeTipoPlanoAcaoEnum prioridade, GrupoPlanoAcaoEnum grupo) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.grupo = grupo;
    }

    public TipoPlanoAcao(String nome, String descricao, PrioridadeTipoPlanoAcaoEnum prioridade, GrupoPlanoAcaoEnum grupo) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.grupo = grupo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public PrioridadeTipoPlanoAcaoEnum getPrioridade() {
        return prioridade;
    }

    public GrupoPlanoAcaoEnum getGrupo() {
        return grupo;
    }
}
