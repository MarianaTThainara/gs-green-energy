package console.commands.app;

import database.Database;
import domain.models.Usuario;

import java.util.Scanner;

public class RegistrarConsumoCommand extends AppCommand {

    public RegistrarConsumoCommand(Scanner sc, Database db) {
        super(sc, db);
    }

    @Override
    public void run() {
        printer.banner("Registrar Consumo de Energia");

        Usuario usuario = db.getUsuarios().values().iterator().next(); // Simula o login do usuário

        printer.soutln("Consumo atual: ");
        double consumoAtual = sc.nextDouble();

        // Atualiza o consumo anterior com o valor atual anterior, se não existir mantém igual
        usuario.setConsumoAnterior(usuario.getConsumoAtual() == 0 ? consumoAtual : usuario.getConsumoAtual());
        usuario.setConsumoAtual(consumoAtual);

        printer.soutln("Consumo registrado com sucesso!");
        back();
    }
}
