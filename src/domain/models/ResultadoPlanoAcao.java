package domain.models;

import java.time.LocalDateTime;
import java.util.HashMap;

import domain.enums.StatusValidacaoEnum;

public class ResultadoPlanoAcao extends Model {

    private PlanoAcao planoAcao;
    private Comunidade comunidade;
    private Usuario usuario;
    private LocalDateTime dataConclusao;
    private float ecoEnergia;
    private int qtdDisp;
    private String observacoes;
    private StatusValidacaoEnum statusValidacao;
    private HashMap<String, AnexoResultadoPlanoAcao> anexos;

    private ResultadoPlanoAcao(PlanoAcao planoAcao, Comunidade comunidade, Usuario usuario) {
        this.planoAcao = planoAcao;
        this.comunidade = comunidade;
        this.usuario = usuario;
        this.anexos = new HashMap<>();
    }

    public ResultadoPlanoAcao(PlanoAcao planoAcao, Usuario usuario, Comunidade comunidade, float ecoEnergia) {
        this(planoAcao, comunidade, usuario);
        this.ecoEnergia = ecoEnergia;
    }

    public ResultadoPlanoAcao(PlanoAcao planoAcao, Comunidade comunidade, Usuario usuario, int qtdDisp) {
        this(planoAcao, comunidade, usuario);
        this.qtdDisp = qtdDisp;
    }

    public ResultadoPlanoAcao(PlanoAcao planoAcao, Comunidade comunidade, Usuario usuario, float ecoEnergia, String observacoes) {
        this(planoAcao, comunidade, usuario);
        this.ecoEnergia = ecoEnergia;
        this.observacoes = observacoes;
    }

    public ResultadoPlanoAcao(PlanoAcao planoAcao, Usuario usuario, Comunidade comunidade, int qtdDisp, String observacoes) {
        this(planoAcao, comunidade, usuario);
        this.qtdDisp = qtdDisp;
        this.observacoes = observacoes;
    }

    public PlanoAcao getPlanoAcao() { return planoAcao; }

    public Comunidade getComunidade() { return comunidade; }

    public Usuario getUsuario() { return usuario; }

    public LocalDateTime getDataConclusao() { return dataConclusao; }

    public void setDataConclusao(LocalDateTime dataConclusao) { this.dataConclusao = dataConclusao; }

    public float getEcoEnergia() { return ecoEnergia; }

    public int getQtdDisp() { return qtdDisp; }

    public String getObservacoes() { return observacoes; }

    public StatusValidacaoEnum getStatusValidacao() { return statusValidacao; }

    public void setStatusValidacao(StatusValidacaoEnum statusValidacao) { this.statusValidacao = statusValidacao; }

    public HashMap<String, AnexoResultadoPlanoAcao> getAnexos() { return anexos; }

    public void addAnexo(AnexoResultadoPlanoAcao anexo) { this.anexos.put(anexo.getId(), anexo); }

    public void removeAnexo(String anexoId) { this.anexos.remove(anexoId); }
}
