package domain.models;

import java.time.LocalDateTime;

public class PlanoAcao extends Model {

    private TipoPlanoAcao tipo;
    private Estado estado;
    private String nome;
    private String meta;
    private float metaAdesaoMin;
    private float metaCompletada;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;

    public PlanoAcao(TipoPlanoAcao tipo, Estado estado, String nome, String meta, float metaAdesaoMin) {
        this.tipo = tipo;
        this.estado = estado;
        this.nome = nome;
        this.meta = meta;
        this.metaAdesaoMin = metaAdesaoMin;
    }

    public TipoPlanoAcao getTipo() {
        return tipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getNome() {
        return nome;
    }

    public String getMeta() {
        return meta;
    }

    public float getMetaAdesaoMin() {
        return metaAdesaoMin;
    }

    public float getMetaCompletada() {
        return metaCompletada;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setMetaCompletada(float metaCompletada) {
        this.metaCompletada = metaCompletada;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
