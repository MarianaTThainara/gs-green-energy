package console.commands.app;

import database.Database;
import domain.models.CronogramaExecucao;
import domain.models.PlanoAcaoVoto;
import domain.models.Usuario;

import java.util.Scanner;

public class PlanoAcaoVotoCommand extends AppCommand {
    public PlanoAcaoVotoCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("Votar em um plano de ação");

        CronogramaExecucao cronograma = chooseCronogramaExecucao(db);
        if(cronograma == null) { back(); return; }

//        PlanoAcaoVoto voto = new PlanoAcaoVoto(
//                cronograma,
//                Usuario
//        );
//
//        db.getVotos().put(voto);

        printer.soutln("Voto computado com sucesso!");
        back();
    }
}
