package console.commands.app.admin;

import console.commands.app.AppCommand;
import database.Database;
import domain.models.CronogramaExecucao;
import domain.models.PlanoAcao;
import domain.models.TipoPlanoAcao;

import java.util.Scanner;

public class PlanoAcaoCreateCommand extends AppCommand {

    public PlanoAcaoCreateCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("CADASTRAR PLANO DE AÇÃO");

        TipoPlanoAcao tipo = chooseTipoPlanoAcao(db);
        if(tipo == null) { back(); return; }

        CronogramaExecucao cronogramaExecucao = chooseCronogramaExecucao(db);
        if(cronogramaExecucao == null) { back(); return; }

        printer.sout("Defina o nome do plano de ação: ");
        String nome = sc.next() + sc.nextLine();

        printer.sout("Define a meta do plano de ação: ");
        String meta = sc.next() + sc.nextLine();

        printer.sout("Define a meta de adesão mínima: ");
        float metaAdesaoMin = sc.nextFloat();

        printer.sout("Recompensa créditos verdes: ");
        float creditosVerdes = sc.nextFloat();

        PlanoAcao plano = new PlanoAcao(tipo, cronogramaExecucao, nome, meta, metaAdesaoMin, creditosVerdes);
        db.getPlanosAcao().put(plano.getId(), plano);

        printer.soutln("Plano de ação cadastrado com sucesso!");
        back();
    }

}
