package console.commands.app;

import database.Database;
import domain.models.Comunidade;
import domain.services.PontuacaoService;

import java.util.List;
import java.util.Scanner;

public class ExibirRankingCommand extends AppCommand {

    public ExibirRankingCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("Ranking de Economia por Comunidade");

        PontuacaoService pontuacaoService = new PontuacaoService();
        List<Comunidade> rankingEconomia = pontuacaoService.calcularRankingEconomia(db.getComunidades());

        int posicao = 1;
        for (Comunidade comunidade : rankingEconomia) {
            printer.soutln(posicao + "º lugar: " + comunidade.getNome());
            posicao++;
        }

        back();
    }
}

