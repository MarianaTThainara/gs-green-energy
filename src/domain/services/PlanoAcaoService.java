package domain.services;

import domain.enums.StatusValidacaoEnum;
import domain.models.Usuario;
import domain.models.ResultadoPlanoAcao;
import domain.models.PlanoAcao;
import domain.models.TipoPlanoAcao;

public class PlanoAcaoService extends Service {

    public void validarAtividade(Usuario usuario, ResultadoPlanoAcao resultado, boolean isAprovado) {
        if (isAprovado) {
            int pontos = calcularPontosPorPrioridade(resultado.getPlanoAcao().getTipo());

            usuario.setCreditosVerde(usuario.getCreditosVerde() + pontos);
            resultado.setStatusValidacao(StatusValidacaoEnum.APROVADO);
            System.out.println("Atividade validada! " + pontos + " créditos foram adicionados para o usuário " + usuario.getNome());
            return;
        }

        resultado.setStatusValidacao(StatusValidacaoEnum.NEGADO);
        System.out.println("A atividade não atende aos requisitos de validação. Por favor, revise e envie uma nova imagem.");
    }

    private int calcularPontosPorPrioridade(TipoPlanoAcao tipoPlano) {
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
