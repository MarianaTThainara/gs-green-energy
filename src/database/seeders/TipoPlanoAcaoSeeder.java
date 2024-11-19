package database.seeders;

import database.interfaces.DatabaseSeederInterface;
import domain.enums.GrupoPlanoAcaoEnum;
import domain.enums.PrioridadeTipoPlanoAcaoEnum;
import domain.models.TipoPlanoAcao;

import java.util.HashMap;
import java.util.List;

public class TipoPlanoAcaoSeeder implements DatabaseSeederInterface<TipoPlanoAcao>  {

    @Override
    public HashMap<String, TipoPlanoAcao> seed() {
        HashMap<String, TipoPlanoAcao> tipos = new HashMap<>();

        List<TipoPlanoAcao> novosPlanos = List.of(
                // ENERGIA - Focado no consumo e análise do uso de energia
                new TipoPlanoAcao("Redução do consumo de energia", PrioridadeTipoPlanoAcaoEnum.ALTA, GrupoPlanoAcaoEnum.ENERGIA),
                new TipoPlanoAcao("Instalar termostatos inteligentes para controle de temperatura", PrioridadeTipoPlanoAcaoEnum.ALTA, GrupoPlanoAcaoEnum.ENERGIA),
                new TipoPlanoAcao("Utilizar eletrodomésticos com selo de eficiência energética", PrioridadeTipoPlanoAcaoEnum.BAIXA, GrupoPlanoAcaoEnum.ENERGIA),
                new TipoPlanoAcao("Monitorar consumo de energia com dispositivos de medição inteligente", PrioridadeTipoPlanoAcaoEnum.ALTA, GrupoPlanoAcaoEnum.ENERGIA),
                new TipoPlanoAcao("Participar de programas de descontos para redução do consumo de energia", PrioridadeTipoPlanoAcaoEnum.BAIXA, GrupoPlanoAcaoEnum.ENERGIA),

                // OBJETO - Aquisição de dispositivos sustentáveis e relacionados à energia limpa
                new TipoPlanoAcao("Instalar painéis solares em residências", PrioridadeTipoPlanoAcaoEnum.ALTA, GrupoPlanoAcaoEnum.OBJETO),
                new TipoPlanoAcao("Adquirir lanternas solares para uso em ambientes externos", PrioridadeTipoPlanoAcaoEnum.BAIXA, GrupoPlanoAcaoEnum.OBJETO),
                new TipoPlanoAcao("Comprar baterias solares portáteis para carregar dispositivos móveis", PrioridadeTipoPlanoAcaoEnum.BAIXA, GrupoPlanoAcaoEnum.OBJETO),
                new TipoPlanoAcao("Instalar chuveiros solares em áreas comuns", PrioridadeTipoPlanoAcaoEnum.ALTA, GrupoPlanoAcaoEnum.OBJETO),
                new TipoPlanoAcao("Instalar sistemas de aquecimento solar em residências", PrioridadeTipoPlanoAcaoEnum.ALTA, GrupoPlanoAcaoEnum.OBJETO),

                // INFRAESTRUTURA - Focado em melhorar a estrutura da casa ou bairro
                new TipoPlanoAcao("Instalação de telhados verdes em residências", PrioridadeTipoPlanoAcaoEnum.BAIXA, GrupoPlanoAcaoEnum.INFRAESTRUTURA),
                new TipoPlanoAcao("Construção de cisternas para captação de água da chuva", PrioridadeTipoPlanoAcaoEnum.BAIXA, GrupoPlanoAcaoEnum.INFRAESTRUTURA),
                new TipoPlanoAcao("Implementação de sistemas de drenagem para prevenir alagamentos", PrioridadeTipoPlanoAcaoEnum.ALTA, GrupoPlanoAcaoEnum.INFRAESTRUTURA),
                new TipoPlanoAcao("Reformar a casa com materiais ecológicos e sustentáveis", PrioridadeTipoPlanoAcaoEnum.BAIXA, GrupoPlanoAcaoEnum.INFRAESTRUTURA),
                new TipoPlanoAcao("Criar jardins e áreas verdes na comunidade para reduzir o impacto urbano", PrioridadeTipoPlanoAcaoEnum.BAIXA, GrupoPlanoAcaoEnum.INFRAESTRUTURA)
        );

        for(TipoPlanoAcao tipo : novosPlanos) {
            tipos.put(tipo.getId(), tipo);
        }

        return tipos;
    }
}
