package console.commands.app;

import console.Printer;
import console.interfaces.CommandInterface;
import database.Database;
import domain.enums.CronogramaExecucaoStatusEnum;
import domain.models.CronogramaExecucao;
import domain.models.Estado;
import domain.models.PlanoAcao;
import domain.models.TipoPlanoAcao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AppCommand implements CommandInterface {

    protected final Database db;
    protected final Scanner sc;
    protected final Printer printer;

    public AppCommand(Scanner sc, Database db) {
        this.sc = sc;
        this.db = db;
        this.printer = new Printer();
    }

    protected void back() {
        printer.soutln("\nPressione Enter para voltar ao menu principal...");
        sc.nextLine();
        sc.nextLine();
    }

    protected TipoPlanoAcao chooseTipoPlanoAcao(Database db) {
        List<TipoPlanoAcao> tipos = new ArrayList<>(db.getTiposPlanoAcao().values());

        return selectItem(
                tipos,
                "Nenhum tipo de ação encontrado!",
                t -> String.format("Nome: %s | Prioridade: %s", t.getNome(), t.getPrioridade()),
                "Escolha um tipo de plano de ação (número): "
        );
    }

    protected Estado chooseEstado(Database db) {
        List<Estado> estados = new ArrayList<>(db.getEstados().values());

        return selectItem(
                estados,
                "Nenhum estado encontrado!",
                e -> String.format("Nome: %s | Sigla: %s", e.getNome(), e.getSigla()),
                "Escolha um estado (número): "
        );
    }

    protected PlanoAcao choosePlanoAcao(Database db) {
        List<PlanoAcao> planosAcao = new ArrayList<>(db.getPlanosAcao().values());

        return selectItem(
                planosAcao,
                "Nenhum plano de ação encontrado!",
                plano -> String.format(
                        "Tipo: %s | Estado: %s | Plano: %s | Meta: %s | Meta adesão mínima: %.2f",
                        plano.getTipo().getNome(),
                        plano.getEstado().getSigla(),
                        plano.getNome(),
                        plano.getMeta(),
                        plano.getMetaAdesaoMin()
                ),
                "Escolha um plano de ação (número): "
        );

    }

    protected CronogramaExecucao chooseCronogramaExecucao(Database db) {
        List<CronogramaExecucao> cronogramas = db.getCronogramas().values().stream().filter(
                cronograma -> cronograma.getStatus() == CronogramaExecucaoStatusEnum.EMABERTO
        ).toList();

        return selectItem(
                cronogramas,
                "Nenhum cronograma encontrado!",
                plano -> String.format(
                        "Plano de ação: %s | Meta: %s",
                        plano.getPlanoAcao().getNome(),
                        plano.getPlanoAcao().getMeta()
                ),
                "Escolha um cronograma (número): "
        );
    }

    public LocalDate chooseDate(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            printer.sout(message + " (YYYY-MM-DD): ");

            String input = sc.next() + sc.nextLine();

            try {
                LocalDate dataFimVotacao = LocalDate.parse(input, formatter);
                return dataFimVotacao;
            } catch (Exception e) {
                printer.soutln("Data inválida! Tente novamente no formato correto (YYYY-MM-DD): ");
            }
        }
    }

    private  <T> T selectItem(List<T> items, String emptyMessage, Formatter<T> formatter, String promptMessage) {
        if (items.isEmpty()) {
            printer.soutln(emptyMessage);
            return null;
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d- %s%n", i + 1, formatter.format(items.get(i)));
        }

        System.out.print(promptMessage);
        int choice = sc.nextInt();

        return (choice < 1 || choice > items.size()) ? null : items.get(choice - 1);
    }

    @FunctionalInterface
    interface Formatter<T> {
        String format(T item);
    }
}
