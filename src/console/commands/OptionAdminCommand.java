package console.commands;

import console.Printer;
import console.commands.app.CronogramaExecucaoCreateCommand;
import console.commands.app.PlanoAcaoCreateCommand;
import console.commands.app.TipoPlanoAcaoCreateCommand;
import console.commands.app.ReviewActivityCommand;
import console.interfaces.CommandInterface;
import database.Database;
import infra.exceptions.InvalidOptionException;

import java.util.Scanner;

public class OptionAdminCommand {

    protected int op;
    protected final Scanner sc;
    protected final Printer printer;
    public final Database db;

    public OptionAdminCommand(Scanner sc, Database db) {
        this.sc = sc;
        this.db = db;
        this.printer = new Printer();
    }

    public void handle() {
        do {
            option();
            var choose = choose();

            if (choose == null) {
                return;
            }

            choose.run();
        } while (op != 0);
    }

    private CommandInterface choose() {
        switch (op) {
            case 1:
                return new TipoPlanoAcaoCreateCommand(sc, db);
            case 2:
                return new PlanoAcaoCreateCommand(sc, db);
            case 3:
                return new CronogramaExecucaoCreateCommand(sc, db);
            case 4:
                return new ReviewActivityCommand(sc, db); // Novo comando de revisão de atividade
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
        printer.soutln("|  1  | Cadastrar tipos planos de ação       |");
        printer.soutln("|  2  | Cadastrar planos de ação             |");
        printer.soutln("|  3  | Cadastrar cronograma de execução     |");
        printer.soutln("|  4  | Validar atividade                    |");
        printer.soutln("----------------------------------------------");
        printer.soutln("|  0  | Sair                                  |");
        printer.soutln("----------------------------------------------");
        printer.sout("Opção: ");
        op = sc.nextInt();
    }
}
