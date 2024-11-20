package console.commands;

import console.Printer;
import database.Database;

import java.util.Scanner;

public class Command {

    protected int op;
    private final Database db;
    private final Printer printer;
    private final Scanner sc;

    public Command() {
        this.printer = new Printer();
        this.db = new Database();
        this.sc = new Scanner(System.in);
    }

    public void run() {
        (new OptionCommand(sc, db)).handle();
    }
}
