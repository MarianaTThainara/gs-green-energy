package console.commands.app;

import database.Database;
import domain.enums.GrupoPlanoAcaoEnum;
import domain.enums.PrioridadeTipoPlanoAcaoEnum;
import domain.models.TipoPlanoAcao;

import java.util.List;
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

        printer.soutln("Escolha a prioridade:");
        PrioridadeTipoPlanoAcaoEnum prioridade = handleEnum(PrioridadeTipoPlanoAcaoEnum.class);

        printer.soutln("Escolha um grupo:");
        GrupoPlanoAcaoEnum grupo = handleEnum(GrupoPlanoAcaoEnum.class);

        TipoPlanoAcao tipo = new TipoPlanoAcao(nome, prioridade, grupo);
        db.getTiposPlanoAcao().put(tipo.getId(), tipo);

        printer.soutln("Tipo de plano de ação cadastrado com sucesso!");
        back();
    }

    private <T extends Enum<T>> T handleEnum(Class<T> enumClass) {
        List<T> options = List.of(enumClass.getEnumConstants());
        int op = 0;

        do {
            for (int i = 0; i < options.size(); i++) {
                printer.soutln((i + 1) + " - " + options.get(i));
            }
            printer.sout("Opção: ");
            op = sc.nextInt();

            if (op < 1 || op > options.size()) {
                printer.soutln("Opção inválida! Tente novamente.");
            }
        } while (op < 1 || op > options.size());

        return options.get(op - 1);
    }
}
