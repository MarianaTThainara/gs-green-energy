package domain.models;

import java.time.LocalDateTime;

public class ComunidadeUsuarioPivot extends Model {

    private Usuario usuario;
    private Comunidade comunidade;
    private LocalDateTime dataEntrada;

    public ComunidadeUsuarioPivot(Usuario usuario, Comunidade comunidade) {
        this.usuario = usuario;
        this.comunidade = comunidade;
        this.dataEntrada = LocalDateTime.now();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Comunidade getComunidade() {
        return comunidade;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }
}
