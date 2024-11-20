package console.commands.app.admin;

import console.commands.app.AppCommand;
import database.Database;
import domain.enums.StatusValidacaoEnum;
import domain.models.AnexoResultadoPlanoAcao;
import domain.models.ResultadoPlanoAcao;
import domain.services.PlanoAcaoService;

import java.util.Map;
import java.util.Scanner;

public class ReviewActivityCommand extends AppCommand {

    private final PlanoAcaoService planoAcaoService;

    public ReviewActivityCommand(Scanner sc, Database db) {
        super(sc, db);
        this.planoAcaoService = new PlanoAcaoService();
    }

    @Override
    public void run() {
        printer.banner("Atividades pendentes de avaliação");

        var resultadosPlanosAcao = db.getResultadosPlanosAcao().values().stream().filter(
                r -> r.getStatusValidacao() == StatusValidacaoEnum.AGUARDANDO
        ).toList();

        if(resultadosPlanosAcao.isEmpty()) {
            printer.soutln("Nenhum resultado do plano de ação encontrado!");
            back();
            return;
        }

        for (ResultadoPlanoAcao resultado : resultadosPlanosAcao) {
            printer.soutln("ID: " + resultado.getId());
            printer.soutln("Plano: " + resultado.getPlanoAcao().getNome());
            printer.soutln("Usuário: " + resultado.getUsuario().getNome());
            printer.soutln("CPF: " + resultado.getUsuario().getCpf());

            // Exibe todos os anexos relacionados à atividade
            printer.soutln("Anexos:");
            for (Map.Entry<String, AnexoResultadoPlanoAcao> anexoEntry : resultado.getAnexos().entrySet()) {
                AnexoResultadoPlanoAcao anexo = anexoEntry.getValue();
                printer.soutln("  - Anexo ID: " + anexo.getId() + " | URL: " + anexo.getUrl() + " | Data de Envio: " + anexo.getDataEnvio());
            }

            printer.sout("Deseja aprovar a atividade? (S/N): ");
            String input = sc.next() + sc.nextLine();

            planoAcaoService.validate(resultado.getUsuario(), resultado, input.equals("S"));
            printer.soutln("");
        }

        back();
    }
}
