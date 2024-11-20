package console.commands.app.admin;

import console.commands.app.AppCommand;
import database.Database;
import domain.enums.PlanoAcaoStatusEnum;
import domain.enums.StatusValidacaoEnum;
import domain.models.Estado;
import domain.models.ResultadoPlanoAcao;
import domain.models.TipoPlanoAcao;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DashboardCommand extends AppCommand {

    public DashboardCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("Dashboard");

        Estado estado = chooseEstado(db);
        if(estado == null) { back(); return; }

        List<ResultadoPlanoAcao> resultados = db.getResultadosPlanosAcao().values().stream().filter(
                resultadoPlanoAcao -> resultadoPlanoAcao.getPlanoAcao().getStatus() == PlanoAcaoStatusEnum.FINALIZADO &&
                        Objects.equals(resultadoPlanoAcao.getPlanoAcao().getEstado().getId(), estado.getId()) &&
                        resultadoPlanoAcao.getStatusValidacao() == StatusValidacaoEnum.APROVADO
        ).toList();

        if (resultados.isEmpty()) {
            printer.sout("Nenhum plano de ação foi executado nesse estado!");
            printer.sout("");
            back();
            return;
        }

        Map<TipoPlanoAcao, List<ResultadoPlanoAcao>> agrupados = resultados.stream()
                .collect(Collectors.groupingBy(resultadoPlanoAcao -> resultadoPlanoAcao.getPlanoAcao().getTipo()));

        agrupados.forEach((tipoPlano, listaResultados) -> {
            printer.soutln("");
            System.out.printf("Tipo plano ação: %s\n", tipoPlano.getNome());
            System.out.printf("Grupo: %s\n", tipoPlano.getGrupo());
            System.out.printf("Total de participantes: %d\n", listaResultados.size());

            double mediaAdesao = listaResultados.stream()
                    .mapToDouble(ResultadoPlanoAcao::getAdesao)
                    .average()
                    .orElse(0.0);

            System.out.println("Média da adesão: " + mediaAdesao);
            System.out.println("");
            System.out.println("Observações: se o grupo for ENERGIA, considere a adesão como Kwh, o contrário é a participação do usuário");
        });

        printer.sout("");
        back();
    }
}
