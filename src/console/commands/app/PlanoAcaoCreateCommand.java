package console.commands.app;

import database.Database;
import domain.models.Estado;
import domain.models.PlanoAcao;
import domain.models.TipoPlanoAcao;

import java.util.ArrayList;
import java.util.List;
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

        Estado estado = chooseEstado(db);
        if(estado == null) { back(); return; }

        printer.sout("Defina o nome do plano de ação: ");
        String nome = sc.next() + sc.nextLine();

        printer.sout("Define a meta do plano de ação: ");
        String meta = sc.next() + sc.nextLine();

        printer.sout("Define a meta de adesão mínima: ");
        float metaAdesaoMin = sc.nextFloat();

        PlanoAcao plano = new PlanoAcao(tipo, estado, nome, meta, metaAdesaoMin);
        db.getPlanosAcao().put(plano.getId(), plano);

        printer.soutln("Plano de ação cadastrado com sucesso!");
        back();
    }

}
