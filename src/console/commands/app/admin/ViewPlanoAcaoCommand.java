package console.commands.app.admin;

import console.commands.app.AppCommand;
import database.Database;
import domain.models.PlanoAcao;
import java.util.List;
import java.util.Scanner;

public class ViewPlanoAcaoCommand extends AppCommand {
    public ViewPlanoAcaoCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("Visualizar planos de ação");

        List<PlanoAcao> planosAcao = db.getPlanosAcao().values().stream().toList();

        for(PlanoAcao plano : planosAcao) {
            System.out.printf(
                    "Nome: %s | Tipo: %s | Status: %s | Estado: %s | Data início: %s | Meta: %s | Meta Adesão Mínima: %.2f | Meta Completada: %.2f | Créditos Verdes: %.2f | Data Criação: %s | Data Alteração: %s",
                    plano.getNome(),
                    plano.getTipo().getNome(),
                    plano.getStatus(),
                    plano.getEstado().getSigla(),
                    plano.getCronograma().getDataInicioExe(),
                    plano.getMeta(),
                    plano.getMetaAdesaoMin(),
                    plano.getMetaCompletada(),
                    plano.getCreditosVerdes(),
                    plano.getDataCriacao(),
                    plano.getDataAlteracao()
            );
            System.out.println("");
        }

        back();
    }
}
