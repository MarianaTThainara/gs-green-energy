package infra.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Classe criada para simular a conexão a uma API
 * de uma concessionária de energia, onde vai retornar o consumo
 * do usuário.
 *
 * A classe pode ser aprimorada para considerar o consumo de energia
 * durante o período de execução do plano de ação
 */
public class EmpresaEnergiaApi {

    private final Long cpf;

    public EmpresaEnergiaApi(Long cpf) {
        this.cpf = cpf;
    }

    public int fetch() {
        // KWH
        int consumoMinimo = 10;
        int consumoMaximo = 200;

        Random r = new Random();
        return r.nextInt(consumoMaximo - consumoMinimo) + consumoMinimo;
    }
}
