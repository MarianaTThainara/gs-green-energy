package console.commands;

import console.Printer;
import console.commands.app.*;
import console.commands.app.admin.*;
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
                return new ViewTipoPlanoAcaoCommand(sc, db);
            case 3:
                return new CronogramaExecucaoCreateCommand(sc, db);
            case 4:
                return new ViewCronogramaExecucaoCommand(sc, db);
            case 5:
                return new PlanoAcaoCreateCommand(sc, db);
            case 6:
                return new ViewPlanoAcaoCommand(sc, db);
            case 7:
                return new ReviewActivityCommand(sc, db);
            case 8:
                return new ExibirRankingCommand(sc, db);
            case 9:
                return new GerarResultadoPlanoAcaoVotoCommand(sc, db);
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
        printer.soutln("|  2  | Visualizar tipos planos de ação      |");
        printer.soutln("|  3  | Cadastrar cronograma de execução     |");
        printer.soutln("|  4  | Visualizar cronogramas de execução   |");
        printer.soutln("|  5  | Cadastrar planos de ação             |");
        printer.soutln("|  6  | Visualizar planos de ação            |");
        printer.soutln("|  7  | Validar planos ação                  |");
        printer.soutln("|  8  | Exibir ranking de comunidades        |");
        printer.soutln("----------------------------------------------");
        printer.soutln("|  9  | [JOB] Gerar resultado votação         |");
        printer.soutln("----------------------------------------------");
        printer.soutln("|  0  | Sair                                  |");
        printer.soutln("----------------------------------------------");
        printer.sout("Opção: ");
        op = sc.nextInt();
    }
}
