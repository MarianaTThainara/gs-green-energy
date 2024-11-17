package domain.models;

import java.time.LocalDateTime;

public class PlanoAcaoVoto extends Model {

    private PlanoAcao planoAcao;
    private Usuario usuario;
    private LocalDateTime dataVoto;
    private String observacoes;

    public PlanoAcaoVoto(PlanoAcao planoAcao, Usuario usuario) {
        this.planoAcao = planoAcao;
        this.usuario = usuario;
        this.dataVoto = LocalDateTime.now();
    }
}
