package domain.models;

import domain.enums.CronogramaExecucaoStatusEnum;

import java.time.LocalDate;
import java.util.HashMap;

public class CronogramaExecucao extends Model {

    private CronogramaExecucaoStatusEnum status;
    private Estado estado;
    private LocalDate dataInicioVotacao;
    private LocalDate dataFimVotacao;
    private LocalDate dataInicioExe;
    private LocalDate dataFimExe;
    private HashMap<String, PlanoAcao> planosAcao;

    public CronogramaExecucao(Estado estado, LocalDate dataInicioVotacao, LocalDate dataFimVotacao, LocalDate dataInicioExe, LocalDate dataFimExe) {
        this.status = CronogramaExecucaoStatusEnum.EMABERTO;
        this.estado = estado;
        this.dataInicioVotacao = dataInicioVotacao;
        this.dataFimVotacao = dataFimVotacao;
        this.dataInicioExe = dataInicioExe;
        this.dataFimExe = dataFimExe;
        this.planosAcao = new HashMap<>();
    }

    public CronogramaExecucaoStatusEnum getStatus() {
        return status;
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

    public HashMap<String, PlanoAcao> getPlanosAcao() {
        return planosAcao;
    }

    public void setStatus(CronogramaExecucaoStatusEnum status) {
        this.status = status;
    }

}
