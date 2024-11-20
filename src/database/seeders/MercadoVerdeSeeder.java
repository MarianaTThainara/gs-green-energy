package database.seeders;

import database.interfaces.DatabaseSeederInterface;
import domain.models.MercadoVerdeProduto;

import java.util.HashMap;
import java.util.List;

public class MercadoVerdeSeeder implements DatabaseSeederInterface<MercadoVerdeProduto> {

    @Override
    public HashMap<String, MercadoVerdeProduto> seed() {
        HashMap<String, MercadoVerdeProduto> produtos = new HashMap<>();

        List<MercadoVerdeProduto> produtosVerdes = List.of(
                new MercadoVerdeProduto("Painel Solar Residencial 500W", 120000.00f),
                new MercadoVerdeProduto("Turbina Eólica Doméstica 1kW", 150000.00f),
                new MercadoVerdeProduto("Bateria de Armazenamento de Energia 10kWh", 108000.00f),
                new MercadoVerdeProduto("Sistema de Aquecimento Solar para Piscina", 205000.00f),
                new MercadoVerdeProduto("Gerador Eólico Portátil 2kW", 220000.00f)
        );

        for (MercadoVerdeProduto produto : produtosVerdes) {
            produtos.put(produto.getId(), produto);
        }

        return produtos;
    }
}
