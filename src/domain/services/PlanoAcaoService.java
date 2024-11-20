package domain.services;

import domain.enums.GrupoPlanoAcaoEnum;
import domain.enums.PrioridadeTipoPlanoAcaoEnum;
import domain.enums.StatusValidacaoEnum;
import domain.models.Usuario;
import domain.models.ResultadoPlanoAcao;
import domain.models.PlanoAcao;
import domain.models.TipoPlanoAcao;

public class PlanoAcaoService extends Service {

    public void validarAtividade(Usuario usuario, ResultadoPlanoAcao resultado, boolean isAprovado) {
        if (isAprovado) {
            float pontos = calcularPontosPorPrioridade(resultado);

            usuario.setCreditosVerde(usuario.getCreditosVerde() + pontos);
            resultado.setStatusValidacao(StatusValidacaoEnum.APROVADO);
            System.out.println("Atividade validada! " + pontos + " créditos foram adicionados para o usuário " + usuario.getNome());
            return;
        }

        resultado.setStatusValidacao(StatusValidacaoEnum.NEGADO);
        System.out.println("A atividade não atende aos requisitos de validação. Por favor, revise e envie uma nova imagem.");
    }

    private float calcularPontosPorPrioridade(ResultadoPlanoAcao resultado) {

        PlanoAcao planoAcao = resultado.getPlanoAcao();

        // Verifica se a adesão já atingiu a meta
        if(resultado.getAdesao() > planoAcao.getMetaAdesaoMin()) {
            return planoAcao.getCreditosVerdes();
        }

        // Calcula a porcentagem que falta para atingir a meta de adesão
        float percentualFaltante = (planoAcao.getMetaAdesaoMin() - resultado.getAdesao()) / planoAcao.getMetaAdesaoMin();

        // Calcula os créditos verdes com base no percentual faltante
        return planoAcao.getCreditosVerdes() * (1 - percentualFaltante);
    }
}
