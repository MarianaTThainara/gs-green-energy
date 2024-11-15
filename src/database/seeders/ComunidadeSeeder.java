package database.seeders;

import database.interfaces.DatabaseSeederInterface;
import domain.models.*;

import java.util.HashMap;
import java.util.Map;

public class ComunidadeSeeder implements DatabaseSeederInterface<Comunidade> {

    private final Map<String, Estado> estados;

    public ComunidadeSeeder(Map<String, Estado> estados) {
        this.estados = estados;
    }

    @Override
    public HashMap<String, Comunidade> seed() {
        HashMap<String, Comunidade> comunidades = new HashMap<>();

        Estado sp = this.estados.get("SP");
        Cidade cidade = sp.getCidades().values().iterator().next();
        Bairro bairro = cidade.getBairros().values().iterator().next();

        Comunidade comunidade = this.getComunidade(bairro);

        comunidades.put(comunidade.getId(), comunidade);
        
        return comunidades;
    }

    private Comunidade getComunidade(Bairro bairro) {
        return new Comunidade(
            "Brasilândia",
            "Comunidade de São Paulo",
            bairro
        );
    }
}
