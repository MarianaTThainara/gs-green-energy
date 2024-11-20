package console.commands.app;

import database.Database;
import domain.enums.GrupoPlanoAcaoEnum;
import domain.enums.PrioridadeTipoPlanoAcaoEnum;
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
            System.out.println(
                    "Nome: " + tipo.getNome() + " |  Prioridade: " + tipo.getPrioridade() + " |  Grupo: " + tipo.getGrupo() + " | Descrição: " + tipo.getDescricao()
            );
        }


        back();
    }
}
