package database.seeders;

import database.interfaces.DatabaseSeederInterface;
import domain.models.Comunidade;
import domain.models.Estado;
import domain.models.Usuario;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseSeeder {

    private static database.seeders.DatabaseSeeder instance;
    private Map<String, Estado> estados;
    private Map<String, Usuario> usuarios;
    private Map<String, Comunidade> comunidades;

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
    }

    public Map<String, Estado> getEstados() {
        return Collections.unmodifiableMap(estados);
    }

    public Map<String, Usuario> getUsuarios() {
        return Collections.unmodifiableMap(usuarios);
    }

    public Map<String, Comunidade> getComunidades() {
        return Collections.unmodifiableMap(comunidades);
    }
}
