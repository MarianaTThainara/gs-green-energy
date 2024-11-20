package console.commands.app.admin;

import console.commands.app.AppCommand;
import database.Database;
import domain.enums.PlanoAcaoStatusEnum;
import domain.models.Estado;
import domain.models.PlanoAcao;

import java.util.List;
import java.util.Scanner;

/**
 * Classe criada para simular o JOB do sistema que é responsável
 * por encerrar os planos de ação com base nas datas fim execução
 */
public class JobClosePlanoAcaoCommand extends AppCommand  {

    public JobClosePlanoAcaoCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("[JOB] Encerrar plano de ação.");

        List<Estado> estados = db.getEstados().values().stream().toList();

        for(Estado estado : estados) {

            printer.soutln("Estado: " + estado.getSigla());

            PlanoAcao planoAcao = choosePlanoAcao(db, estado);
            if(planoAcao == null) {
                continue;
            }

            planoAcao.setStatus(PlanoAcaoStatusEnum.FINALIZADO);
            db.getPlanosAcao().put(planoAcao.getId(), planoAcao);

            db.getUsuarios().forEach(
                    (s, usuario) -> usuario.getPlanosAcao().forEach(
                            (s1, planoAcao1) -> planoAcao1.setStatus(PlanoAcaoStatusEnum.FINALIZADO)
                    )
            );

        }

        printer.sout("Planos de ação encerrados com sucesso!");
        back();
    }
}
