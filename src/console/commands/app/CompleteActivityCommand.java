package console.commands.app;

import console.interfaces.CommandInterface;
import database.Database;
import domain.models.AnexoResultadoPlanoAcao;
import domain.models.PlanoAcao;
import domain.models.ResultadoPlanoAcao;
import domain.models.Usuario;

import java.util.Scanner;

public class CompleteActivityCommand implements CommandInterface {

    private final Scanner sc;
    private final Database db;
    private final Usuario usuario;

    public CompleteActivityCommand(Scanner sc, Database db, Usuario usuario) {
        this.sc = sc;
        this.db = db;
        this.usuario = usuario;
    }

    @Override
    public void run() {
        PlanoAcao planoAcao = escolherPlanoAcao();

        if (planoAcao == null) {
            System.out.println("Nenhum plano de ação disponível para completar.");
            return;
        }

        System.out.print("Insira o caminho da imagem de comprovação: ");
        String imagemUrl = sc.next(); // Simula o envio de imagem com uma string representando o caminho

        // Cria um novo resultado de atividade para ser revisado pelo administrador
        ResultadoPlanoAcao resultado = new ResultadoPlanoAcao(planoAcao, usuario.getComunidades().values().iterator().next(), usuario, 0);

        AnexoResultadoPlanoAcao anexo = new AnexoResultadoPlanoAcao(resultado, imagemUrl);
        resultado.getAnexos().put(anexo.getId(), anexo);

        // Salva o resultado no banco de dados para que o administrador possa revisá-lo
        db.getResultadosPlanosAcao().put(resultado.getId(), resultado);

        System.out.println("Atividade registrada com sucesso. Aguardando validação do administrador.");
    }

    private PlanoAcao escolherPlanoAcao() {
        System.out.println("Escolha um plano de ação disponível:");

        int index = 1;
        for (PlanoAcao plano : db.getPlanosAcao().values()) {
            System.out.println(index + " - " + plano.getNome() + " (Meta: " + plano.getMeta() + ")");
            index++;
        }

        System.out.print("Digite o número do plano de ação: ");
        int escolha = sc.nextInt();

        index = 1;
        for (PlanoAcao plano : db.getPlanosAcao().values()) {
            if (index == escolha) {
                return plano;
            }
            index++;
        }

        System.out.println("Opção inválida.");
        return null;
    }
}
