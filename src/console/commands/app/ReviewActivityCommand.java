package console.commands.app;

import console.interfaces.CommandInterface;
import database.Database;
import domain.enums.StatusValidacaoEnum;
import domain.models.ResultadoPlanoAcao;
import domain.services.PlanoAcaoService;

import java.util.Map;
import java.util.Scanner;

public class ReviewActivityCommand implements CommandInterface {

    private final Scanner sc;
    private final Database db;
    private final PlanoAcaoService planoAcaoService;

    public ReviewActivityCommand(Scanner sc, Database db) {
        this.sc = sc;
        this.db = db;
        this.planoAcaoService = new PlanoAcaoService();
    }

    @Override
    public void run() {
        System.out.println("Atividades pendentes de validação:");

        for (Map.Entry<String, ResultadoPlanoAcao> entry : db.getResultadosPlanosAcao().entrySet()) {
            ResultadoPlanoAcao resultado = entry.getValue();

            if (resultado.getStatusValidacao() == null) {
                System.out.println("ID: " + resultado.getId() + " | Plano: " + resultado.getPlanoAcao().getNome() + " | Usuário: " + resultado.getUsuario().getNome());
                System.out.println("Imagem: " + resultado.getImagemUrl());
                System.out.print("Deseja aprovar a atividade? (1 para Sim, 2 para Não): ");
                int escolha = sc.nextInt();

                if (escolha == 1) {
                    resultado.setStatusValidacao(StatusValidacaoEnum.APROVADO);
                    planoAcaoService.validarAtividade(resultado.getUsuario(), resultado, true);
                    System.out.println("Atividade aprovada. Pontos adicionados ao usuário.");
                } else {
                    resultado.setStatusValidacao(StatusValidacaoEnum.NEGADO);
                    System.out.println("Atividade rejeitada. Usuário será notificado para reenviar.");
                }
            }
        }
    }
}
