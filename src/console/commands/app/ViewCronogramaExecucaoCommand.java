package console.commands.app;

import database.Database;
import domain.models.CronogramaExecucao;
import java.util.List;
import java.util.Scanner;

public class ViewCronogramaExecucaoCommand extends AppCommand {

    public ViewCronogramaExecucaoCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("Visualizar cronogramas de execução");

        List<CronogramaExecucao> cronogramas = db.getCronogramas().values().stream().toList();

        for(CronogramaExecucao cronograma : cronogramas) {
            System.out.printf(
                    "Estado: %s | Status: %s | Data início votação: %s | Data fim votação: %s | Data início exe.: %s | Data fim exec.: %s",
                    cronograma.getEstado().getSigla(),
                    cronograma.getStatus(),
                    cronograma.getDataInicioVotacao(),
                    cronograma.getDataFimVotacao(),
                    cronograma.getDataInicioExe(),
                    cronograma.getDataFimExe()
            );
            System.out.println("");
        }

        back();
    }
}
