package console.commands;

import console.Printer;
import console.commands.app.user.*;
import console.commands.app.ExibirRankingCommand;
import console.interfaces.CommandInterface;
import database.Database;
import domain.models.Usuario;
import infra.exceptions.InvalidOptionException;

import java.util.Scanner;

public class OptionUserCommand {

    protected int op;
    protected final Scanner sc;
    protected final Printer printer;
    public final Database db;

    public OptionUserCommand(Scanner sc, Database db) {
        this.sc = sc;
        this.db = db;
        this.printer = new Printer();
    }

    public void handle() {
        Usuario usuario = db.getUsuarios().values().iterator().next();

        printer.soutln("Realizando login...");
        printer.soutln("");
        printer.soutln("Bem-vindo! " + usuario.getNome());
        printer.soutln("");

        do {
            option();

            var choose = choose(usuario);

            if(choose == null) {
                return;
            }

            choose.run();
        } while (op != 0);
    }

    private CommandInterface choose(Usuario usuario) {
        switch (op) {
            case 1:
                return new ViewProfileCommand(sc, db, usuario);
            case 2:
                return new PlanoAcaoVotoCommand(sc, db, usuario);
            case 3:
                return new CompleteActivityCommand(sc, db, usuario);
            case 4:
                return new ExibirRankingCommand(sc, db);
            case 5:
                return new MercadoVerdeCommand(sc, db, usuario);
            case 6:
                return new ViewProdutoMercadoVerde(sc, db, usuario);
            case 0:
                printer.soutln("Saindo do sistema...");
                return null;
            default:
                throw new InvalidOptionException();
        }
    }

    private void option() {
        printer.soutln("----------------------------------------------");
        printer.soutln("|                MENU PRINCIPAL               |");
        printer.soutln("----------------------------------------------");
        printer.soutln("| Por favor, selecione uma das opções abaixo: |");
        printer.soutln("----------------------------------------------");
        printer.soutln("|  1  | Visualizar dados pessoais            |");
        printer.soutln("|  2  | Votar em um plano de ação            |");
        printer.soutln("|  3  | Completar plano de ação              |");
        printer.soutln("|  4  | Visualizar ranking de comunidades    |");
        printer.soutln("|  5  | Mercado verde                        |");
        printer.soutln("|  6  | Visualizar compras verdes            |");
        printer.soutln("----------------------------------------------");
        printer.soutln("|  0  | Sair                                  |");
        printer.soutln("----------------------------------------------");
        printer.sout("Opção: ");
        op = sc.nextInt();
    }
}
