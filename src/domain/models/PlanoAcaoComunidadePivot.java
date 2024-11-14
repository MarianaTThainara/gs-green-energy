package domain.models;

public class PlanoAcaoComunidadePivot extends Model {

    private PlanoAcao planoAcao;
    private Comunidade comunidade;

    public PlanoAcaoComunidadePivot(PlanoAcao planoAcao, Comunidade comunidade) {
        this.planoAcao = planoAcao;
        this.comunidade = comunidade;
    }

    public PlanoAcao getPlanoAcao() {
        return planoAcao;
    }

    public Comunidade getComunidade() {
        return comunidade;
    }
}
