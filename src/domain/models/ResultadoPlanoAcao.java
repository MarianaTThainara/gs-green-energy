package domain.models;

import java.time.LocalDateTime;
import domain.enums.StatusValidacaoEnum;

public class ResultadoPlanoAcao extends Model {

    private PlanoAcao planoAcao;
    private Comunidade comunidade;
    private Usuario usuario;
    private LocalDateTime dataConclusao;
    private float ecoEnergia;
    private float qtdDisp;
    private String observacoes;
    private String imagemUrl;
    private StatusValidacaoEnum statusValidacao;

    // Construtores existentes
    public ResultadoPlanoAcao(PlanoAcao planoAcao, Comunidade comunidade, Usuario usuario, float ecoEnergia, String observacoes) {
        this.planoAcao = planoAcao;
        this.comunidade = comunidade;
        this.usuario = usuario;
        this.ecoEnergia = ecoEnergia;
        this.observacoes = observacoes;
    }

    public ResultadoPlanoAcao(PlanoAcao planoAcao, Usuario usuario, Comunidade comunidade, float qtdDisp, String observacoes) {
        this.planoAcao = planoAcao;
        this.usuario = usuario;
        this.comunidade = comunidade;
        this.qtdDisp = qtdDisp;
        this.observacoes = observacoes;
    }

    public ResultadoPlanoAcao(PlanoAcao planoAcao, Usuario usuario, Comunidade comunidade, float ecoEnergia) {
        this.planoAcao = planoAcao;
        this.usuario = usuario;
        this.comunidade = comunidade;
        this.ecoEnergia = ecoEnergia;
    }

    public ResultadoPlanoAcao(PlanoAcao planoAcao, Comunidade comunidade, Usuario usuario, float qtdDisp) {
        this.planoAcao = planoAcao;
        this.comunidade = comunidade;
        this.usuario = usuario;
        this.qtdDisp = qtdDisp;
    }

    // Métodos getters para obter as propriedades

    public PlanoAcao getPlanoAcao() {
        return planoAcao;
    }

    public Comunidade getComunidade() {
        return comunidade;
    }

    public Usuario getUsuario() { // Novo método getUsuario
        return usuario;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public StatusValidacaoEnum getStatusValidacao() {
        return statusValidacao;
    }

    public void setStatusValidacao(StatusValidacaoEnum statusValidacao) {
        this.statusValidacao = statusValidacao;
    }
}