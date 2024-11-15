package domain.models;

import domain.enums.CronogramaExecucaoStatusEnum;

import java.time.LocalDate;

public class CronogramaExecucao extends Model {

    private CronogramaExecucaoStatusEnum status;
    private PlanoAcao planoAcao;
    private Estado estado;
    private LocalDate dataInicioVotacao;
    private LocalDate dataFimVotacao;
    private LocalDate dataInicioExe;
    private LocalDate dataFimExe;

    public CronogramaExecucao(PlanoAcao planoAcao, Estado estado, LocalDate dataInicioVotacao, LocalDate dataFimVotacao, LocalDate dataInicioExe, LocalDate dataFimExe) {
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

    public LocalDate getDataInicioVotacao() {
        return dataInicioVotacao;
    }

    public LocalDate getDataFimVotacao() {
        return dataFimVotacao;
    }

    public LocalDate getDataInicioExe() {
        return dataInicioExe;
    }

    public LocalDate getDataFimExe() {
        return dataFimExe;
    }

    public void setStatus(CronogramaExecucaoStatusEnum status) {
        this.status = status;
    }
}
