package domain.models;

import java.time.LocalDateTime;

public class AnexoResultadoPlanoAcao extends Model {

    private ResultadoPlanoAcao resultado;
    private String url;
    private LocalDateTime dataEnvio;

    public AnexoResultadoPlanoAcao(ResultadoPlanoAcao resultado, String url) {
        this.resultado = resultado;
        this.url = url;
        this.dataEnvio = LocalDateTime.now();
    }

    public ResultadoPlanoAcao getResultado() {
        return resultado;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }
}
