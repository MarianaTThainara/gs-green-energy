package domain.models;

import domain.enums.PlanoAcaoStatusEnum;

import java.time.LocalDateTime;

public class PlanoAcao extends Model {

    private TipoPlanoAcao tipo;
    private PlanoAcaoStatusEnum status;
    private Estado estado;
    private CronogramaExecucao cronograma;
    private String nome;
    private String meta;
    private float metaAdesaoMin;
    private float metaCompletada;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;

    public PlanoAcao(TipoPlanoAcao tipo, CronogramaExecucao cronograma, String nome, String meta, float metaAdesaoMin) {
        this.tipo = tipo;
        this.estado = cronograma.getEstado();
        this.nome = nome;
        this.meta = meta;
        this.metaAdesaoMin = metaAdesaoMin;
        this.dataCriacao = LocalDateTime.now();
        this.status = PlanoAcaoStatusEnum.EMABERTO;
    }

    public TipoPlanoAcao getTipo() {
        return tipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public CronogramaExecucao getCronograma() {
        return cronograma;
    }

    public String getNome() {
        return nome;
    }

    public String getMeta() {
        return meta;
    }

    public PlanoAcaoStatusEnum getStatus() {
        return status;
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
