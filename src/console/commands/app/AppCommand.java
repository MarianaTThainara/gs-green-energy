package console.commands.app;

import console.Printer;
import console.interfaces.CommandInterface;
import database.Database;
import domain.enums.CronogramaExecucaoStatusEnum;
import domain.enums.PlanoAcaoStatusEnum;
import domain.enums.StatusValidacaoEnum;
import domain.models.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
                t -> String.format("Nome: %s | Prioridade: %s | Grupo: %s", t.getNome(), t.getPrioridade(), t.getGrupo()),
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

    protected Comunidade chooseComunidadeUsuario(Usuario usuario) {
        List<Comunidade> comunidades = new ArrayList<>(usuario.getComunidades().values());

        return selectItem(
                comunidades,
                "Nenhuma comunidade encontrada!",
                e -> String.format(
                        "Nome: %s | Bairro: %s | Cidade: %s",
                        e.getNome(), e.getBairro().getNome(), e.getBairro().getCidade().getNome()
                ),
                "Escolha uma comunidade (número): "
        );
    }

    protected PlanoAcao choosePlanoAcao(Database db, Estado estado, PlanoAcaoStatusEnum status) {
        List<PlanoAcao> planosAcao = new ArrayList<>(db.getPlanosAcao().values().stream().filter(
                plano -> Objects.equals(plano.getEstado().getNome(), estado.getNome()) &&
                        plano.getStatus() == status
        ).toList());

        return selectItem(
                planosAcao,
                "Nenhum plano de ação encontrado!",
                plano -> String.format(
                        "Status: %s | Tipo: %s | Estado: %s | Plano: %s | Meta: %s | Meta adesão mínima: %.2f",
                        plano.getStatus(),
                        plano.getTipo().getNome(),
                        plano.getEstado().getSigla(),
                        plano.getNome(),
                        plano.getMeta(),
                        plano.getMetaAdesaoMin()
                ),
                "Escolha um plano de ação (número): "
        );

    }

    protected PlanoAcao choosePlanoAcaoUsuario(Usuario usuario) {
        List<PlanoAcao> planosAcao = usuario.getPlanosAcao().values().stream()
                .filter(planoAcao -> planoAcao.getStatus() == PlanoAcaoStatusEnum.APROVADO)
                .filter(planoAcao ->
                        usuario.getResultados().values().stream()
                                .noneMatch(resultado -> resultado.getPlanoAcao().equals(planoAcao))
                )
                .toList();

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
                crono -> String.format(
                        "Estado: %s | Data início votação: %s | Data fim votação: %s | Data início plano: %s | Data fim plano: %s ",
                        crono.getEstado().getNome(),
                        crono.getDataInicioVotacao(),
                        crono.getDataFimVotacao(),
                        crono.getDataInicioExe(),
                        crono.getDataFimExe()
                ),
                "Escolha um cronograma (número): "
        );
    }

    protected ResultadoPlanoAcao chooseResultadoPlanoAcao(Database db) {
        List<ResultadoPlanoAcao> resultados = db.getResultadosPlanosAcao().values().stream().filter(
                resultado -> resultado.getStatusValidacao().equals(StatusValidacaoEnum.AGUARDANDO)
        ).toList();

        return selectItem(
                resultados,
                "Nenhuma pendência encontrada!",
                res -> String.format(
                        "Plano ação: %s | Usuário: %s",
                        res.getPlanoAcao().getNome(),
                        res.getUsuario().getNome()
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
