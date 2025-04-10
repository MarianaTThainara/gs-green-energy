package console.commands.app.user;

import console.commands.app.AppCommand;
import database.Database;
import domain.enums.PlanoAcaoStatusEnum;
import domain.models.*;

import java.util.Scanner;

public class PlanoAcaoVotoCommand extends AppCommand {

    private Usuario usuario;

    public PlanoAcaoVotoCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    public PlanoAcaoVotoCommand(Scanner sc, Database db, Usuario usuario) {
        super(sc, db);
        this.usuario = usuario;
    }

    @Override
    public void run() {
        printer.banner("Votar em um plano de ação");

        Comunidade comunidade = chooseComunidadeUsuario(usuario);
        if(comunidade == null) { back(); return; }

        PlanoAcao planoAcao = choosePlanoAcao(db, comunidade.getBairro().getCidade().getEstado(), PlanoAcaoStatusEnum.EMABERTO);
        if(planoAcao == null) { back(); return; }

        if(usuario.getPlanosAcao().containsKey(planoAcao.getId())) {
            printer.soutln("Você já votou nesse plano de ação!");
            back();
            return;
        }

        PlanoAcaoVoto voto = new PlanoAcaoVoto(
                planoAcao,
                usuario
        );

        db.getVotos().put(voto.getId(), voto);
        usuario.getPlanosAcao().put(planoAcao.getId(), planoAcao);
        db.getUsuarios().put(usuario.getId(), usuario);

        printer.soutln("Voto computado com sucesso!");
        back();
    }
}
