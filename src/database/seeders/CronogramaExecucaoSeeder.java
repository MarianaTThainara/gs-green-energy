package database.seeders;

import database.interfaces.DatabaseSeederInterface;
import domain.enums.GrupoPlanoAcaoEnum;
import domain.enums.PrioridadeTipoPlanoAcaoEnum;
import domain.models.Comunidade;
import domain.models.CronogramaExecucao;
import domain.models.Estado;
import domain.models.TipoPlanoAcao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CronogramaExecucaoSeeder implements DatabaseSeederInterface<CronogramaExecucao> {

    private final Map<String, Estado> estados;

    public CronogramaExecucaoSeeder(Map<String, Estado> estados) {
        this.estados = estados;
    }

    @Override
    public HashMap<String, CronogramaExecucao> seed() {
        HashMap<String, CronogramaExecucao> cronogramas = new HashMap<>();

        for (Estado estado: estados.values()) {
            List<CronogramaExecucao> novosCronogramas = List.of(
                    new CronogramaExecucao(
                            estado,
                            LocalDate.of(2024, 10, 18),
                            LocalDate.of(2024, 10, 19),
                            LocalDate.of(2024, 10, 20),
                            LocalDate.of(2024, 11, 21)
                    )
            );

            for(CronogramaExecucao cronograma : novosCronogramas) {
                cronogramas.put(cronograma.getId(), cronograma);
            }
        }

        return cronogramas;
    }
}
