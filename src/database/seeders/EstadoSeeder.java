package database.seeders;

import database.interfaces.DatabaseSeederInterface;
import domain.models.Bairro;
import domain.models.Cidade;
import domain.models.Estado;

import java.util.HashMap;

public class EstadoSeeder implements DatabaseSeederInterface<Estado> {

    @Override
    public HashMap<String, Estado> seed() {
        HashMap<String, Estado> estados = new HashMap<>();

        Estado sp = createSaoPaulo();
        Estado rj = createRioDeJaneiro();
        Estado mg = createMinasGerais();

        estados.put(sp.getSigla(), sp);
        estados.put(rj.getSigla(), rj);
        estados.put(mg.getSigla(), mg);

        return estados;
    }

    private Estado createSaoPaulo() {
        Estado sp = new Estado("São Paulo", "SP", "35");

        Cidade spCapital = new Cidade("São Paulo", sp);
        Cidade campinas = new Cidade("Campinas", sp);
        Cidade santos = new Cidade("Santos", sp);
        Cidade sorocaba = new Cidade("Sorocaba", sp);
        Cidade saoBernardo = new Cidade("São Bernardo do Campo", sp);

        Bairro centro = new Bairro("Centro", spCapital);
        Bairro jardins = new Bairro("Jardins", spCapital);
        Bairro cambui = new Bairro("Cambuí", campinas);
        Bairro gonzaga = new Bairro("Gonzaga", santos);
        Bairro campolim = new Bairro("Campolim", sorocaba);

        spCapital.getBairros().put(centro.getId(), centro);
        spCapital.getBairros().put(jardins.getId(), jardins);
        campinas.getBairros().put(cambui.getId(), cambui);
        santos.getBairros().put(gonzaga.getId(), gonzaga);
        sorocaba.getBairros().put(campolim.getId(), campolim);

        sp.getCidades().put(spCapital.getId(), spCapital);
        sp.getCidades().put(campinas.getId(), campinas);
        sp.getCidades().put(santos.getId(), santos);
        sp.getCidades().put(sorocaba.getId(), sorocaba);
        sp.getCidades().put(saoBernardo.getId(), saoBernardo);

        return sp;
    }

    private Estado createRioDeJaneiro() {
        Estado rioDeJaneiro = new Estado("Rio de Janeiro", "RJ", "33");

        Cidade rjCapital = new Cidade("Rio de Janeiro", rioDeJaneiro);
        Cidade niteroi = new Cidade("Niterói", rioDeJaneiro);
        Cidade petropolis = new Cidade("Petrópolis", rioDeJaneiro);
        Cidade campos = new Cidade("Campos dos Goytacazes", rioDeJaneiro);
        Cidade angra = new Cidade("Angra dos Reis", rioDeJaneiro);

        rjCapital.getBairros().put(new Bairro("Copacabana", rjCapital).getId(), new Bairro("Copacabana", rjCapital));
        rjCapital.getBairros().put(new Bairro("Ipanema", rjCapital).getId(), new Bairro("Ipanema", rjCapital));
        niteroi.getBairros().put(new Bairro("Icaraí", niteroi).getId(), new Bairro("Icaraí", niteroi));
        petropolis.getBairros().put(new Bairro("Centro", petropolis).getId(), new Bairro("Centro", petropolis));
        campos.getBairros().put(new Bairro("Centro", campos).getId(), new Bairro("Centro", campos));

        rioDeJaneiro.getCidades().put(rjCapital.getId(), rjCapital);
        rioDeJaneiro.getCidades().put(niteroi.getId(), niteroi);
        rioDeJaneiro.getCidades().put(petropolis.getId(), petropolis);
        rioDeJaneiro.getCidades().put(campos.getId(), campos);
        rioDeJaneiro.getCidades().put(angra.getId(), angra);

        return rioDeJaneiro;
    }

    private Estado createMinasGerais() {
        Estado minasGerais = new Estado("Minas Gerais", "MG", "31");

        Cidade bh = new Cidade("Belo Horizonte", minasGerais);
        Cidade uberlandia = new Cidade("Uberlândia", minasGerais);
        Cidade contagem = new Cidade("Contagem", minasGerais);
        Cidade juizDeFora = new Cidade("Juiz de Fora", minasGerais);
        Cidade betim = new Cidade("Betim", minasGerais);

        bh.getBairros().put(new Bairro("Savassi", bh).getId(), new Bairro("Savassi", bh));
        bh.getBairros().put(new Bairro("Pampulha", bh).getId(), new Bairro("Pampulha", bh));
        uberlandia.getBairros().put(new Bairro("Centro", uberlandia).getId(), new Bairro("Centro", uberlandia));
        contagem.getBairros().put(new Bairro("Industrial", contagem).getId(), new Bairro("Industrial", contagem));
        juizDeFora.getBairros().put(new Bairro("São Mateus", juizDeFora).getId(), new Bairro("São Mateus", juizDeFora));

        minasGerais.getCidades().put(bh.getId(), bh);
        minasGerais.getCidades().put(uberlandia.getId(), uberlandia);
        minasGerais.getCidades().put(contagem.getId(), contagem);
        minasGerais.getCidades().put(juizDeFora.getId(), juizDeFora);
        minasGerais.getCidades().put(betim.getId(), betim);

        return minasGerais;
    }
}
