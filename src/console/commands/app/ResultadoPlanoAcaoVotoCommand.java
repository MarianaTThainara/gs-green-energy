package console.commands.app;

import database.Database;
import domain.enums.PlanoAcaoStatusEnum;
import domain.enums.PrioridadeTipoPlanoAcaoEnum;
import domain.models.PlanoAcao;
import domain.models.PlanoAcaoVoto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResultadoPlanoAcaoVotoCommand extends AppCommand {

    public ResultadoPlanoAcaoVotoCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("Gerar resultado votação planos de ação");

        List<PlanoAcao> planosAprovados = new ArrayList<>();
        List<PlanoAcao> planosObrigatorios = new ArrayList();

        for (PlanoAcaoVoto voto : db.getVotos().values()) {
            voto.getPlanoAcao().setStatus(PlanoAcaoStatusEnum.APROVADO);

            planosAprovados.add(voto.getPlanoAcao());

            if (isPlanoAcaoObrigatorio(voto.getPlanoAcao())) {
                planosObrigatorios.add(voto.getPlanoAcao());
            }
        }

        printer.soutln("Planos de ação aprovados: ");
        for(PlanoAcao plano: planosAprovados) {
            printer.soutln("Plano ação: " + plano.getNome());
        }

        printer.soutln("");
        printer.soutln("Planos de ação obrigatórios: ");
        for(PlanoAcao plano: planosObrigatorios) {
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

    private boolean isPlanoAcaoObrigatorio(PlanoAcao planoAcao) {
        return planoAcao.getTipo().getPrioridade().equals(PrioridadeTipoPlanoAcaoEnum.ALTA);
    }
}
