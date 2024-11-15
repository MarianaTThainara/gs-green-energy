package console.commands;

import console.Printer;
import database.Database;
import infra.exceptions.InvalidOptionException;

import java.util.Scanner;

public class OptionCommand {

    protected int op;
    protected final Scanner sc;
    protected final Printer printer;
    public final Database db;

    public OptionCommand(Scanner sc, Database db) {
        this.sc = sc;
        this.db = db;
        this.printer = new Printer();
    }

    public void handle() {
        do {
            option();
            choose();
        } while (op != 0);
    }

    private void option() {
        printer.soutln("----------------------------------------------");
        printer.soutln("|                  BEM VINDO                 |");
        printer.soutln("----------------------------------------------");
        printer.soutln("| Por favor, selecione um ambiente abaixo    |");
        printer.soutln("----------------------------------------------");
        printer.soutln("|  1  | Administrador                        |");
        printer.soutln("|  2  | Cidadão brasileiro                   |");
        printer.soutln("----------------------------------------------");
        printer.soutln("|  0  | Sair                                  |");
        printer.soutln("----------------------------------------------");
        printer.sout("Opção: "); op = sc.nextInt();
    }

    private void choose() {
        switch (op) {
            case 1:
                (new OptionAdminCommand(sc, db)).handle();
                return;
            case 2:
                (new OptionUserCommand(sc, db)).handle();
                return;
            case 0:
                printer.soutln("Saindo do sistema...");
                return;
            default:
                throw new InvalidOptionException();
        }
    }
}
