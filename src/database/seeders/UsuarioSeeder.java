package database.seeders;

import database.interfaces.DatabaseSeederInterface;
import domain.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioSeeder implements DatabaseSeederInterface<Usuario> {

    private final Map<String, Comunidade> comunidades;

    public UsuarioSeeder(Map<String, Comunidade> comunidades) {
        this.comunidades = comunidades;
    }

    @Override
    public HashMap<String, Usuario> seed() {
        HashMap<String, Usuario> usuarios = new HashMap<>();

        Comunidade comunidade = comunidades.values().iterator().next();
        Usuario usuario = this.getUsuario(comunidade.getBairro());

        usuario.setCreditosVerde(365000);

        usuario.getComunidades().put(comunidade.getId(), comunidade);
        usuarios.put(usuario.getId(), usuario);
        
        return usuarios;
    }

    private Usuario getUsuario(Bairro bairro) {
        HashMap<String, UsuarioEndereco> enderecos = new HashMap<>();

        UsuarioEndereco endereco = new UsuarioEndereco(
                bairro,
            "Rua das Flores",
            "123",
            "Apartamento 101"
        );

        enderecos.put(endereco.getId(), endereco);

        return new Usuario(
                "Maria Lurdes",
                "Pereira",
                19362388022L,
                "maria.lurdes@email.com",
                "#^|!]73>SC",
                enderecos
        );
    }
}
