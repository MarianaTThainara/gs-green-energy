package console.commands.app.admin;

import console.commands.app.AppCommand;
import database.Database;
import domain.enums.PlanoAcaoStatusEnum;
import domain.enums.PrioridadeTipoPlanoAcaoEnum;
import domain.models.PlanoAcao;
import domain.models.PlanoAcaoVoto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerarResultadoPlanoAcaoVotoCommand extends AppCommand {

    public GerarResultadoPlanoAcaoVotoCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("Gerar resultado votação planos de ação");

        ArrayList<PlanoAcaoVoto> votos =  new ArrayList<>(db.getVotos().values().stream().filter(
                planoAcaoVoto -> planoAcaoVoto.getPlanoAcao().getStatus() == PlanoAcaoStatusEnum.EMABERTO
        ).toList());

        if(votos.isEmpty()) {
            printer.sout("Nenhum plano de ação em aberto!");
            back();
            return;
        }

        List<PlanoAcao> planosAprovados = new ArrayList<>();

        for (PlanoAcaoVoto voto : votos) {
            voto.getPlanoAcao().setStatus(PlanoAcaoStatusEnum.APROVADO);

            planosAprovados.add(voto.getPlanoAcao());
        }

        printer.soutln("Planos de ação aprovados: ");
        for(PlanoAcao plano: planosAprovados) {
            printer.soutln("Plano ação: " + plano.getNome());
        }

        for (PlanoAcao planoAcao : db.getPlanosAcao().values()) {
            boolean foiVotado = false;
            for (PlanoAcaoVoto voto : db.getVotos().values()) {
                if (voto.getPlanoAcao().equals(planoAcao)) {
                    foiVotado = true;
                    break;
                }
            }

            if (!foiVotado) {
                planoAcao.setStatus(PlanoAcaoStatusEnum.RECUSADO);
            }
        }

        printer.soutln("");
        printer.soutln("Planos de ação não votados foram marcados como RECUSADOS.");
        back();
    }
}
