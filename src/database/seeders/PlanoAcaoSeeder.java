package database.seeders;

import database.interfaces.DatabaseSeederInterface;
import domain.enums.GrupoPlanoAcaoEnum;
import domain.enums.PrioridadeTipoPlanoAcaoEnum;
import domain.models.CronogramaExecucao;
import domain.models.Estado;
import domain.models.PlanoAcao;
import domain.models.TipoPlanoAcao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PlanoAcaoSeeder implements DatabaseSeederInterface<PlanoAcao> {

    private final Map<String, TipoPlanoAcao> tiposPlanosAcao;
    private final Map<String, CronogramaExecucao> cronogramas;

    public PlanoAcaoSeeder(Map<String, TipoPlanoAcao> tiposPlanosAcao, Map<String, CronogramaExecucao> cronogramas) {
        this.tiposPlanosAcao = tiposPlanosAcao;
        this.cronogramas = cronogramas;
    }

    @Override
    public HashMap<String, PlanoAcao> seed() {
        HashMap<String, PlanoAcao> planosAcao = new HashMap<>();

        CronogramaExecucao cronograma = cronogramas.values().stream().filter(
                crono -> crono.getEstado().getSigla() == "SP"
        ).findFirst().orElse(null);

        if(cronograma == null) {
            return planosAcao;
        }

        List<PlanoAcao> novosPlanos = List.of(
                new PlanoAcao(
                        tiposPlanosAcao.get("Redução do consumo de energia"),
                        cronograma,
                        "Sempre dentro do possível!!",
                        "Redução do consumo de energia em 15%",
                        15),
                new PlanoAcao(
                        tiposPlanosAcao.get("Instalar chuveiros solares em áreas comuns"),
                        cronograma,
                        "Banho quente",
                        "Criar um chuveiro externo para a família sem utilizar energia elétrica",
                        5)
        );

        for (PlanoAcao planoAcao: novosPlanos) {
            planosAcao.put(planoAcao.getId(), planoAcao);
        }

        return planosAcao;
    }
}
