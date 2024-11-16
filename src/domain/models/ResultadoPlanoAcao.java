package domain.models;

import java.time.LocalDateTime;
import domain.enums.StatusValidacaoEnum;

public class ResultadoPlanoAcao extends Model {

    private PlanoAcao planoAcao;
    private Comunidade comunidade;
    private Usuario usuario;
    private LocalDateTime dataConclusao;
    private float ecoEnergia;
    private float qtd_disp;
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

    public ResultadoPlanoAcao(PlanoAcao planoAcao, Usuario usuario, Comunidade comunidade, float qtd_disp, String observacoes) {
        this.planoAcao = planoAcao;
        this.usuario = usuario;
        this.comunidade = comunidade;
        this.qtd_disp = qtd_disp;
        this.observacoes = observacoes;
    }

    public ResultadoPlanoAcao(PlanoAcao planoAcao, Usuario usuario, Comunidade comunidade, float ecoEnergia) {
        this.planoAcao = planoAcao;
        this.usuario = usuario;
        this.comunidade = comunidade;
        this.ecoEnergia = ecoEnergia;
    }

    public ResultadoPlanoAcao(PlanoAcao planoAcao, Comunidade comunidade, Usuario usuario, float qtd_disp) {
        this.planoAcao = planoAcao;
        this.comunidade = comunidade;
        this.usuario = usuario;
        this.qtd_disp = qtd_disp;
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