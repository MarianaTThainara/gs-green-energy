package console.commands.app.admin;

import console.commands.app.AppCommand;
import database.Database;
import domain.models.TipoPlanoAcao;

import java.util.List;
import java.util.Scanner;

public class ViewTipoPlanoAcaoCommand extends AppCommand {

    public ViewTipoPlanoAcaoCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("Visualizar tipos de plano de ação");

        List<TipoPlanoAcao> tiposPlanosAcao = db.getTiposPlanoAcao().values().stream().toList();

        for(TipoPlanoAcao tipo : tiposPlanosAcao) {
            System.out.printf(
                    "Nome: %s | Prioridade: %s | Grupo: %s",
                    tipo.getNome(),
                    tipo.getPrioridade(),
                    tipo.getGrupo()
            );
            System.out.println("");
        }

        back();
    }
}
