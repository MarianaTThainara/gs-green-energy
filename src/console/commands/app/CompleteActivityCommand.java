package console.commands.app;

import console.interfaces.CommandInterface;
import database.Database;
import domain.models.*;

import java.util.Scanner;

public class CompleteActivityCommand extends AppCommand {

    private Usuario usuario;

    private CompleteActivityCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    public CompleteActivityCommand(Scanner sc, Database db, Usuario usuario) {
        super(sc, db);
        this.usuario = usuario;
    }

    @Override
    public void run() {
        printer.banner("Completar plano de ação");

        PlanoAcao planoAcao = choosePlanoAcaoUsuario(usuario);
        if(planoAcao == null) { back(); return; }

        System.out.print("Insira o caminho da imagem de comprovação: ");
        String imagemUrl = sc.next(); // Simula o envio de imagem com uma string representando o caminho

        // Cria um novo resultado de atividade para ser revisado pelo administrador
        ResultadoPlanoAcao resultado = new ResultadoPlanoAcao(planoAcao, usuario.getComunidades().values().iterator().next(), usuario, 0);

        AnexoResultadoPlanoAcao anexo = new AnexoResultadoPlanoAcao(resultado, imagemUrl);
        resultado.getAnexos().put(anexo.getId(), anexo);

        // Salva o resultado no banco de dados para que o administrador possa revisá-lo
        db.getResultadosPlanosAcao().put(resultado.getId(), resultado);

        printer.soutln("Atividade registrada com sucesso. Aguardando validação do administrador.");
    }
}
