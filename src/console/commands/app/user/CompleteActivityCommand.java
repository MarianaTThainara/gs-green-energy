package console.commands.app.user;

import console.commands.app.AppCommand;
import console.interfaces.CommandInterface;
import database.Database;
import domain.enums.StatusValidacaoEnum;
import domain.models.*;
import domain.services.GrupoTipoPlanoAcaoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        Comunidade comunidade = chooseComunidadeUsuario(usuario);
        if(comunidade == null) { back(); return; }

        PlanoAcao planoAcao = choosePlanoAcaoUsuario(usuario);
        if(planoAcao == null) { back(); return; }

        System.out.print("Insira o caminho do documento de comprovação: ");
        String imagemUrl = sc.next();

        GrupoTipoPlanoAcaoService grupoService = new GrupoTipoPlanoAcaoService(
                planoAcao.getTipo().getGrupo(), usuario, sc);

        float adesao = grupoService.handle().getData();

        usuario.setConsumoAtual(adesao);

        ResultadoPlanoAcao resultado = new ResultadoPlanoAcao(
                planoAcao,
                usuario,
                comunidade,
                adesao
        );

        AnexoResultadoPlanoAcao anexo = new AnexoResultadoPlanoAcao(resultado, imagemUrl);
        resultado.getAnexos().put(anexo.getId(), anexo);

        db.getResultadosPlanosAcao().put(resultado.getId(), resultado);
        usuario.getResultados().put(resultado.getId(), resultado);

        db.getComunidades().forEach((s, comunidade1) -> comunidade1.getUsuarios().put(usuario.getId(), usuario));

        db.getUsuarios().put(usuario.getId(), usuario);

        printer.soutln("Atividade enviada para análise com sucesso!");
        back();
    }
}
