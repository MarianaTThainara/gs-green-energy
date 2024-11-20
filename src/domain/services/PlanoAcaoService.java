package domain.services;

import domain.enums.StatusValidacaoEnum;
import domain.models.Usuario;
import domain.models.ResultadoPlanoAcao;
import domain.models.PlanoAcao;

public class PlanoAcaoService extends Service {

    public void validate(Usuario usuario, ResultadoPlanoAcao resultado, boolean isAprovado) {
        if (!isAprovado) {
            resultado.setStatusValidacao(StatusValidacaoEnum.NEGADO);
            System.out.println(
                    "Plano de ação realizado pelo usuário foi negado com sucesso!"
            );
            return;
        }

        float pontos = handleCreditosVerdes(resultado);

        usuario.setCreditosVerde(usuario.getCreditosVerde() + pontos);
        resultado.setStatusValidacao(StatusValidacaoEnum.APROVADO);
        System.out.println(
                "Plano de ação validado! "
                        + pontos +
                        " créditos foram adicionados para o usuário "
                        + usuario.getNome()
        );
    }

    /**
     * Simula a geração de creditos verdes com base na adesão minima
     * definida no plano de ação e a adesão informada pelo usuario
     */
    private float handleCreditosVerdes(ResultadoPlanoAcao resultado) {

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
