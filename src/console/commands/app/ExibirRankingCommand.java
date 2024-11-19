package console.commands.app;

import database.Database;
import domain.models.Comunidade;
import domain.services.PontuacaoService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExibirRankingCommand extends AppCommand {

    public ExibirRankingCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("Ranking de Comunidades");

        PontuacaoService pontuacaoService = new PontuacaoService();
        List<Map.Entry<Comunidade, Double>> ranking = pontuacaoService.calcularRanking(db.getComunidades());

        int posicao = 1;
        for (Map.Entry<Comunidade, Double> entry : ranking) {
            Comunidade comunidade = entry.getKey();
            double rankingValue = entry.getValue();

            int atividadesValidadas = pontuacaoService.calcularAtividadesValidadas(comunidade);
            double consumoTotal = pontuacaoService.calcularConsumoTotal(comunidade);

            printer.soutln(String.format(
                    "%dº lugar: %s | %s | Atividades Validadas: %d | Consumo Total: %.2f kWh | Ranking Value: %.2f",
                    posicao,
                    comunidade.getNome(),
                    comunidade.getBairro().getCidade().getNome(),
                    atividadesValidadas,
                    consumoTotal,
                    rankingValue
            ));

            posicao++;
        }

        back();
    }
}
