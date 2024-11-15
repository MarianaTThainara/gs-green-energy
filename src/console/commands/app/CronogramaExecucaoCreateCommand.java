package console.commands.app;

import database.Database;
import domain.models.CronogramaExecucao;
import domain.models.PlanoAcao;

import java.time.LocalDate;
import java.util.Scanner;

public class CronogramaExecucaoCreateCommand extends AppCommand {

    public CronogramaExecucaoCreateCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("Cadastrar cronograma de execução");

        PlanoAcao planoAcao = choosePlanoAcao(db);
        if(planoAcao == null) { back(); return; }

        LocalDate dataInicioVotacao = chooseDate("Defina a data de início da votação");
        LocalDate dataFimVotacao = chooseDate("Defina a data fim da votação");
        LocalDate dataInicioExe = chooseDate("Defina a data de início do plano de ação");
        LocalDate dataFimExe = chooseDate("Defina a data fim do plano de ação");

        CronogramaExecucao cronograma = new CronogramaExecucao(
                planoAcao,
                planoAcao.getEstado(),
                dataInicioVotacao,
                dataFimVotacao,
                dataInicioExe,
                dataFimExe
        );

        db.getCronogramas().put(cronograma.getId(), cronograma);

        printer.soutln("Cronograma de execução cadastrado com sucesso!");
        back();
    }
}
