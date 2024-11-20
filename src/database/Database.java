package database;

import database.seeders.DatabaseSeeder;
import domain.models.*;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private final DatabaseSeeder database;

    private Map<String, Usuario> usuarios;
    private Map<String, Estado> estados;
    private Map<String, Comunidade> comunidades;
    private Map<String, TipoPlanoAcao> tiposPlanoAcao = new HashMap<>();
    private Map<String, PlanoAcao> planosAcao = new HashMap<>();
    private Map<String, CronogramaExecucao> cronogramas = new HashMap<>();
    private Map<String, PlanoAcaoVoto> votos = new HashMap<>();
    private Map<String, ResultadoPlanoAcao> resultadosPlanosAcao = new HashMap<>();
    private Map<String, MercadoVerdeProduto> mercado = new HashMap<>();

    public Database() {
        this.database = DatabaseSeeder.getInstance();
        this.estados = database.getEstados();
        this.usuarios = database.getUsuarios();
        this.comunidades = database.getComunidades();
        this.tiposPlanoAcao = database.getTiposPlanosAcao();
        this.cronogramas = database.getCronogramas();
        this.planosAcao = database.getPlanosAcao();
        this.mercado = database.getProdutos();
    }

    public DatabaseSeeder getDatabase() {
        return database;
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public Map<String, Estado> getEstados() {
        return estados;
    }

    public Map<String, Comunidade> getComunidades() {
        return comunidades;
    }

    public Map<String, TipoPlanoAcao> getTiposPlanoAcao() {
        return tiposPlanoAcao;
    }

    public Map<String, PlanoAcao> getPlanosAcao() {
        return planosAcao;
    }

    public Map<String, CronogramaExecucao> getCronogramas() {
        return cronogramas;
    }

    public Map<String, PlanoAcaoVoto> getVotos() {
        return votos;
    }

    public Map<String, ResultadoPlanoAcao> getResultadosPlanosAcao() {
        return resultadosPlanosAcao;
    }

    public Map<String, MercadoVerdeProduto> getMercado() {
        return mercado;
    }
}
