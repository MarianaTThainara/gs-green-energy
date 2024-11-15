package domain.services;
import domain.models.TipoPlanoAcao;
import domain.enums.PrioridadeTipoPlanoAcaoEnum;

public class PlanoAcaoService extends Service {

    public int calcularPontosPorPrioridade(TipoPlanoAcao tipoPlano) {
        switch (tipoPlano.getPrioridade()) {
            case ALTA:
                return 10;
            case MEDIA:
                return 5;
            default:
                return 0;
        }
    }

}
