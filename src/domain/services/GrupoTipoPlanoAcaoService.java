package domain.services;

import domain.enums.GrupoPlanoAcaoEnum;
import domain.interfaces.GrupoTipoPlanoAcaoInterface;
import domain.models.Usuario;

import java.util.Scanner;

public class GrupoTipoPlanoAcaoService extends Service {

    private final GrupoPlanoAcaoEnum grupo;
    private final Usuario usuario;
    private final Scanner scanner;

    public GrupoTipoPlanoAcaoService(GrupoPlanoAcaoEnum grupo, Usuario usuario, Scanner scanner) {
        this.grupo = grupo;
        this.usuario = usuario;
        this.scanner = scanner;
    }

    public GrupoTipoPlanoAcaoInterface handle() {
        switch (grupo) {
            case GrupoPlanoAcaoEnum.ENERGIA -> {
                return new GrupoEnergiaTipoPlanoAcaoService(usuario);
            }
            case GrupoPlanoAcaoEnum.OBJETO -> {
                return new GrupoObjetoTipoPlanoAcaoService(scanner);
            }
//            case GrupoPlanoAcaoEnum.INFRAESTRUTURA -> {
//                return new GrupoObjetoTipoPlanoAcaoService(scanner);
//            }
            default -> throw new RuntimeException("Grupo inválido!");
        }
    }
}
