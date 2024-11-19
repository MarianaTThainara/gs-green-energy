package console.commands;

import console.Printer;
import console.commands.app.CompleteActivityCommand;
import console.commands.app.PlanoAcaoVotoCommand;
import console.commands.app.RegistrarConsumoCommand;
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
                return new PlanoAcaoVotoCommand(sc, db, usuario);
            case 2:
                return new CompleteActivityCommand(sc, db, usuario); // Novo comando para completar atividade
            case 3:
                return new RegistrarConsumoCommand(sc, db);
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
        printer.soutln("|  1  | Votar em um plano de ação            |");
        printer.soutln("|  2  | Completar uma atividade              |"); // Nova opção para completar atividade
        printer.soutln("|  3  | Registrar consumo de energia         |");
        printer.soutln("----------------------------------------------");
        printer.soutln("|  0  | Sair                                  |");
        printer.soutln("----------------------------------------------");
        printer.sout("Opção: ");
        op = sc.nextInt();
    }
}
