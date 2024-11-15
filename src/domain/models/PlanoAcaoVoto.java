package domain.models;

import java.time.LocalDateTime;

public class PlanoAcaoVoto extends Model {

    private CronogramaExecucao cronograma;
    private Usuario usuario;
    private LocalDateTime dataVoto;
    private String observacoes;

    public PlanoAcaoVoto(CronogramaExecucao cronograma, Usuario usuario) {
        this.cronograma = cronograma;
        this.usuario = usuario;
        this.dataVoto = LocalDateTime.now();
    }
}
