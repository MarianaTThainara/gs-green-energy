package domain.services;

import domain.models.Comunidade;
import domain.models.Usuario;

import java.util.*;
import java.util.stream.Collectors;

public class PontuacaoService {

    private static final int PONTOS_PRIORIDADE_ALTA = 10;
    private static final int PONTOS_PRIORIDADE_MEDIA = 5;
    private static final Map<Integer, Integer> PONTOS_RANKING_COMUNIDADES = Map.of(
            1, 500, // Primeira posição no ranking
            2, 300, // Segunda posição no ranking
            3, 200  // Terceira posição no ranking
    );
    private static final int PONTOS_PARTICIPACAO_COMUNIDADE = 100; // Para comunidades fora do top 3

    public void pontuarAtividade(Usuario usuario, String prioridade) {
        int pontos = switch (prioridade.toUpperCase()) {
            case "ALTA" -> PONTOS_PRIORIDADE_ALTA;
            case "MEDIA" -> PONTOS_PRIORIDADE_MEDIA;
            default -> 0;
        };

        usuario.setCreditosVerde(usuario.getCreditosVerde() + pontos);
    }

    private void distribuirPontosPorUsuario(Comunidade comunidade, int pontosPorUsuario) {
        for (Usuario usuario : comunidade.getUsuarios()) {
            usuario.setCreditosVerde(usuario.getCreditosVerde() + pontosPorUsuario);
        }
    }

    public void distribuirPontosRanking(List<Comunidade> comunidadesRanking) {
        for (int i = 0; i < comunidadesRanking.size(); i++) {
            Comunidade comunidade = comunidadesRanking.get(i);
            int pontosPorUsuario = PONTOS_RANKING_COMUNIDADES.getOrDefault(i + 1, PONTOS_PARTICIPACAO_COMUNIDADE);
            distribuirPontosPorUsuario(comunidade, pontosPorUsuario);
        }
    }

    public List<Comunidade> calcularRankingEconomia(Map<String, Comunidade> comunidades) {
        Map<Comunidade, Double> economias = new HashMap<>();

        for (Comunidade comunidade : comunidades.values()) {
            double consumoAnteriorTotal = 0.0;
            double consumoAtualTotal = 0.0;

            // Soma os consumos de todos os usuários da comunidade
            for (Usuario usuario : comunidade.getUsuarios()) {
                consumoAnteriorTotal += usuario.getConsumoAnterior();
                consumoAtualTotal += usuario.getConsumoAtual();
            }

            // Calcula a economia percentual
            double economia = consumoAnteriorTotal > 0
                    ? ((consumoAnteriorTotal - consumoAtualTotal) / consumoAnteriorTotal) * 100
                    : 0; // Se não houver consumo anterior, economia é 0

            economias.put(comunidade, economia);
        }

        // Ordena comunidades por economia em ordem decrescente
        return economias.entrySet().stream()
                .sorted(Map.Entry.<Comunidade, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
