package domain.models;

import domain.enums.CronogramaExecucaoStatusEnum;

import java.time.LocalDateTime;

public class CronogramaExecucao extends Model {

    private CronogramaExecucaoStatusEnum status;
    private PlanoAcao planoAcao;
    private Estado estado;
    private LocalDateTime dataInicioVotacao;
    private LocalDateTime dataFimVotacao;
    private LocalDateTime dataInicioExe;
    private LocalDateTime dataFimExe;

    public CronogramaExecucao(PlanoAcao planoAcao, Estado estado, LocalDateTime dataInicioVotacao, LocalDateTime dataFimVotacao, LocalDateTime dataInicioExe, LocalDateTime dataFimExe) {
        this.status = CronogramaExecucaoStatusEnum.EMABERTO;
        this.planoAcao = planoAcao;
        this.estado = estado;
        this.dataInicioVotacao = dataInicioVotacao;
        this.dataFimVotacao = dataFimVotacao;
        this.dataInicioExe = dataInicioExe;
        this.dataFimExe = dataFimExe;
    }

    public CronogramaExecucaoStatusEnum getStatus() {
        return status;
    }

    public PlanoAcao getPlanoAcao() {
        return planoAcao;
    }

    public Estado getEstado() {
        return estado;
    }

    public LocalDateTime getDataInicioVotacao() {
        return dataInicioVotacao;
    }

    public LocalDateTime getDataFimVotacao() {
        return dataFimVotacao;
    }

    public LocalDateTime getDataInicioExe() {
        return dataInicioExe;
    }

    public LocalDateTime getDataFimExe() {
        return dataFimExe;
    }

    public void setStatus(CronogramaExecucaoStatusEnum status) {
        this.status = status;
    }
}
