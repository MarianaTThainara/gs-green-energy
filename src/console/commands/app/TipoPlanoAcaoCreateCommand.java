package console.commands.app;

import database.Database;
import domain.enums.PrioridadeTipoPlanoAcaoEnum;
import domain.models.TipoPlanoAcao;

import java.util.Scanner;

public class TipoPlanoAcaoCreateCommand extends AppCommand {

    public TipoPlanoAcaoCreateCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("Cadastrar tipo plano de ação");

        printer.sout("Defina o nome: ");
        String nome = sc.next() + sc.nextLine();
        PrioridadeTipoPlanoAcaoEnum prioridade = handlePrioridade();

        TipoPlanoAcao tipo = new TipoPlanoAcao(nome, prioridade);

        db.getTiposPlanoAcao().put(tipo.getId(), tipo);

        printer.soutln("Tipo de plano de ação cadastrado com sucesso!");
        back();
    }

    private PrioridadeTipoPlanoAcaoEnum handlePrioridade() {

        int prioridade;

        do {
            printer.soutln("Prioridade: ");
            printer.soutln("1 - " + PrioridadeTipoPlanoAcaoEnum.ALTA);
            printer.soutln("2 - " + PrioridadeTipoPlanoAcaoEnum.MEDIA);
            printer.soutln("Opção: ");
            prioridade = sc.nextInt();

            if(prioridade != 1 && prioridade != 2) {
                printer.soutln("Opção inválida! Tente novamente.");
            }

        } while (prioridade != 1 && prioridade != 2);

        return prioridade == 1 ? PrioridadeTipoPlanoAcaoEnum.ALTA :
                                 PrioridadeTipoPlanoAcaoEnum.MEDIA;
    }
}
