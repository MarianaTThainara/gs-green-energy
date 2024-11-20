package domain.services;

import console.Printer;
import domain.interfaces.GrupoTipoPlanoAcaoInterface;

import java.util.Scanner;

public class GrupoObjetoTipoPlanoAcaoService extends Service implements GrupoTipoPlanoAcaoInterface {

    private final Printer printer;
    private final Scanner scanner;

    public GrupoObjetoTipoPlanoAcaoService(Scanner scanner) {
        this.scanner = scanner;
        this.printer = new Printer();
    }

    @Override
    public float getData() {
        printer.sout("Informe a quantidade de dispositivos: ");
        return scanner.nextFloat();
    }
}
