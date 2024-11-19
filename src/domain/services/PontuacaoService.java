package domain.services;

import domain.models.Comunidade;
import domain.models.Usuario;

import java.util.*;

public class PontuacaoService {

    private static final Map<Integer, Integer> PONTOS_RANKING_COMUNIDADES = Map.of(
            1, 500, // Primeira posição no ranking
            2, 300, // Segunda posição no ranking
            3, 200  // Terceira posição no ranking
    );
    private static final int PONTOS_PARTICIPACAO_COMUNIDADE = 100; // Comunidades fora do top 3

    // Calcula o ranking das comunidades com base no maior número de atividades validadas e no menor consumo de energia.

    public List<Map.Entry<Comunidade, Double>> calcularRanking(Map<String, Comunidade> comunidades) {
        Map<Comunidade, Double> rankingValues = new HashMap<>();

        for (Comunidade comunidade : comunidades.values()) {
            int atividadesValidadas = calcularAtividadesValidadas(comunidade);
            double consumoTotal = calcularConsumoTotal(comunidade);

            // Fórmula: maior número de atividades validadas / menor consumo
            double rankingValue = atividadesValidadas / (consumoTotal + 1); // +1 evita divisão por zero
            rankingValues.put(comunidade, rankingValue);
        }

        // Ordena comunidades por valor de rankeamento em ordem decrescente
        return rankingValues.entrySet().stream()
                .sorted(Map.Entry.<Comunidade, Double>comparingByValue().reversed())
                .toList();
    }

    //Distribui os pontos para os usuários das comunidades com base na posição no ranking.

    public void distribuirPontosRanking(List<Map.Entry<Comunidade, Double>> ranking) {
        for (int i = 0; i < ranking.size(); i++) {
            Comunidade comunidade = ranking.get(i).getKey();
            int pontosPorUsuario = PONTOS_RANKING_COMUNIDADES.getOrDefault(i + 1, PONTOS_PARTICIPACAO_COMUNIDADE);
            distribuirPontosPorUsuario(comunidade, pontosPorUsuario);
        }
    }

    private void distribuirPontosPorUsuario(Comunidade comunidade, int pontosPorUsuario) {
        List<Usuario> usuarios = comunidade.getUsuarios().values().stream().toList();

        for (Usuario usuario : usuarios) {
            usuario.setCreditosVerde(usuario.getCreditosVerde() + pontosPorUsuario);
        }
    }

    public int calcularAtividadesValidadas(Comunidade comunidade) {
        return comunidade.getUsuarios().values().stream()
                .mapToInt(usuario -> (int) usuario.getResultados().values().stream()
                        .filter(resultado -> resultado.getStatusValidacao() != null && resultado.getStatusValidacao().toString().equals("APROVADO"))
                        .count())
                .sum();
    }

    public double calcularConsumoTotal(Comunidade comunidade) {
        return comunidade.getUsuarios().values().stream()
                .mapToDouble(Usuario::getConsumoAtual)
                .sum();
    }
}
