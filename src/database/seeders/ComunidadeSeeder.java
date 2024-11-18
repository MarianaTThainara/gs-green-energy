package database.seeders;

import database.interfaces.DatabaseSeederInterface;
import domain.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        // Users ficticios associados a comunidade
        comunidade.setUsuarios(getUsuariosFicticios(bairro));

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

    private List<Usuario> getUsuariosFicticios(Bairro bairro) {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario1 = new Usuario(
                "João",
                "Silva",
                12345678901L,
                "joao@email.com",
                "senha123",
                getEnderecoUsuario(bairro, "Rua A", "101")
        );

        Usuario usuario2 = new Usuario(
                "Maria",
                "Oliveira",
                98765432100L,
                "maria@email.com",
                "senha123",
                getEnderecoUsuario(bairro, "Rua B", "202")
        );

        usuarios.add(usuario1);
        usuarios.add(usuario2);

        return usuarios;
    }

    private HashMap<String, UsuarioEndereco> getEnderecoUsuario(Bairro bairro, String logradouro, String numero) {
        HashMap<String, UsuarioEndereco> enderecos = new HashMap<>();

        UsuarioEndereco endereco = new UsuarioEndereco(
                bairro,
                logradouro,
                numero
        );

        enderecos.put(endereco.getId(), endereco);

        return enderecos;
    }
}

