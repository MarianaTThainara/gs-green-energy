package database.seeders;

import database.interfaces.DatabaseSeederInterface;
import domain.models.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseSeeder {

    private static database.seeders.DatabaseSeeder instance;
    private Map<String, Estado> estados;
    private Map<String, Usuario> usuarios;
    private Map<String, Comunidade> comunidades;
    private Map<String, TipoPlanoAcao> tiposPlanosAcao;
    private Map<String, CronogramaExecucao> cronogramas;
    private Map<String, PlanoAcao> planosAcao;
    private Map<String, MercadoVerdeProduto> produtos;

    private DatabaseSeeder() {
        seed();
    }

    public static synchronized database.seeders.DatabaseSeeder getInstance() {
        if (instance == null) {
            instance = new database.seeders.DatabaseSeeder();
        }
        return instance;
    }

    private void seed() {
        this.estados = (new EstadoSeeder()).seed();
        this.comunidades = (new ComunidadeSeeder(estados)).seed();
        this.usuarios = (new UsuarioSeeder(comunidades)).seed();
        this.tiposPlanosAcao = (new TipoPlanoAcaoSeeder()).seed();
        this.cronogramas = (new CronogramaExecucaoSeeder(estados)).seed();
        this.planosAcao = (new PlanoAcaoSeeder(tiposPlanosAcao, cronogramas)).seed();
        this.produtos = (new MercadoVerdeSeeder()).seed();
    }

    public Map<String, Estado> getEstados() {
        return Collections.unmodifiableMap(estados);
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public Map<String, Comunidade> getComunidades() {
        return Collections.unmodifiableMap(comunidades);
    }

    public Map<String, TipoPlanoAcao> getTiposPlanosAcao() {
        return tiposPlanosAcao;
    }

    public Map<String, CronogramaExecucao> getCronogramas() {
        return cronogramas;
    }

    public Map<String, PlanoAcao> getPlanosAcao() {
        return planosAcao;
    }

    public Map<String, MercadoVerdeProduto> getProdutos() {
        return Collections.unmodifiableMap(produtos);
    }
}
