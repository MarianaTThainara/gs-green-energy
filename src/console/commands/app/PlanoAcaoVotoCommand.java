package console.commands.app;

import database.Database;
import domain.models.CronogramaExecucao;
import domain.models.PlanoAcao;
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

        Usuario usuario = db.getUsuarios().values().iterator().next();

        PlanoAcao planoAcao = choosePlanoAcao(db);
        if(planoAcao == null) { back(); return; }

        PlanoAcaoVoto voto = new PlanoAcaoVoto(
                planoAcao,
                usuario
        );

        db.getVotos().put(voto.getId(), voto);

        printer.soutln("Voto computado com sucesso!");
        back();
    }
}
