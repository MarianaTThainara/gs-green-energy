package console.commands.app.user;

import console.commands.app.AppCommand;
import database.Database;
import domain.models.CompraProdutoVerdeUsuario;
import domain.models.MercadoVerdeProduto;
import domain.models.Usuario;

import java.util.Scanner;

public class MercadoVerdeCommand extends AppCommand  {

    private Usuario usuario;

    public MercadoVerdeCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    public MercadoVerdeCommand(Scanner sc, Database db, Usuario usuario) {
        super(sc, db);
        this.usuario = usuario;
    }

    @Override
    public void run() {
        printer.banner("Mercado verde");

        MercadoVerdeProduto produto = chooseProdutoMercadoVerde(db);
        if(produto == null) { back(); return; }

        CompraProdutoVerdeUsuario compraProdutoVerdeUsuario = new CompraProdutoVerdeUsuario(produto, usuario);

        usuario.getProdutos().put(produto.getId(), compraProdutoVerdeUsuario);

        float saldoVerdeUsuario = usuario.getCreditosVerde();

        if(produto.getPrecoVerde() > saldoVerdeUsuario) {
            printer.soutln("Saldo insuficiente!");
            back();
            return;
        }

        usuario.setCreditosVerde(usuario.getCreditosVerde() - produto.getPrecoVerde());
        db.getUsuarios().put(usuario.getId(), usuario);

        printer.soutln("Produto comprado com sucesso!");
        back();
    }
}
