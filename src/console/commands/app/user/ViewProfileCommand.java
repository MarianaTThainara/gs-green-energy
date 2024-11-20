package console.commands.app.user;

import console.commands.app.AppCommand;
import database.Database;
import domain.models.Usuario;

import java.util.Scanner;

public class ViewProfileCommand extends AppCommand {

    private Usuario usuario;

    public ViewProfileCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    public ViewProfileCommand(Scanner sc, Database db, Usuario usuario) {
        super(sc, db);
        this.usuario = usuario;
    }

    @Override
    public void run() {
        printer.banner("Visualizar dados pessoais");

        System.out.printf(
                "Nome: %s | E-mail: %s | CPF: %s | Créditos verdes: %2.2f",
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getCreditosVerde()
        );
        System.out.println("");

        back();
    }
}
