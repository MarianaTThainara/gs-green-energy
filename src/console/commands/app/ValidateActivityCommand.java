package console.commands.app;

import domain.enums.PrioridadeTipoPlanoAcaoEnum;
import domain.enums.StatusValidacaoEnum;
import domain.models.*;
import domain.services.PlanoAcaoService;
import console.interfaces.CommandInterface;
import database.Database;

import java.util.Scanner;

public class ValidateActivityCommand implements CommandInterface {

    private final Scanner sc;
    private final Database db;

    public ValidateActivityCommand(Scanner sc, Database db) {
        this.sc = sc;
        this.db = db;
    }

    @Override
    public void run() {

        Usuario usuario = new Usuario("Maria", "Silva", 12345678901L, "maria@example.com", "senha123", null);
        Comunidade comunidade = new Comunidade("Comunidade Verde", "Focada em sustentabilidade", null);


        TipoPlanoAcao tipoPlanoAcao = new TipoPlanoAcao("Economia de Energia", PrioridadeTipoPlanoAcaoEnum.ALTA);
        PlanoAcao planoAcao = new PlanoAcao(tipoPlanoAcao, null, "Redução de Consumo", "20%", 75);


        ResultadoPlanoAcao resultado = new ResultadoPlanoAcao(planoAcao, comunidade, usuario, 15, "Economia registrada");
        resultado.setImagemUrl("caminho/para/imagem.jpg");


        PlanoAcaoService planoAcaoService = new PlanoAcaoService();


        boolean isAprovado = chooseApproval();
        planoAcaoService.validarAtividade(usuario, resultado, isAprovado);


        System.out.println("Status de Validação: " + resultado.getStatusValidacao());
        System.out.println("Créditos do Usuário: " + usuario.getNome() + " - Créditos: " + usuario.toString());
    }

    private boolean chooseApproval() {
        System.out.println("Deseja aprovar a atividade? (1 para Sim, 2 para Não)");
        int escolha = selectItem(1, 2);
        return escolha == 1;
    }

    private int selectItem(int min, int max) {
        int escolha;
        do {
            System.out.print("Escolha uma opção (" + min + " - " + max + "): ");
            while (!sc.hasNextInt()) {
                System.out.print("Por favor, insira um número válido: ");
                sc.next();
            }
            escolha = sc.nextInt();
        } while (escolha < min || escolha > max);
        return escolha;
    }
}
