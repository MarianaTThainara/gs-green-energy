package infra.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class EmpresaEnergiaApi {

    private final Long cpf;

    public EmpresaEnergiaApi(Long cpf) {
        this.cpf = cpf;
    }

    public float fetch() {
        Random random = new Random();

        // KWH
        double consumoMinimo = 50.0;
        double consumoMaximo = 1000.0;

        return (float) (consumoMinimo + (consumoMaximo - consumoMinimo) * random.nextFloat());
    }
}
