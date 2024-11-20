package domain.models;

import java.time.LocalDateTime;

public class CompraProdutoVerdeUsuario extends Model {

    private MercadoVerdeProduto produto;
    private Usuario usuario;
    private LocalDateTime dataCompra;

    public CompraProdutoVerdeUsuario(MercadoVerdeProduto produto, Usuario usuario) {
        this.produto = produto;
        this.usuario = usuario;
        this.dataCompra = LocalDateTime.now();
    }

    public MercadoVerdeProduto getProduto() {
        return produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    @Override
    public String toString() {
        return "CompraProdutoVerdeUsuario{" +
                "produto=" + produto +
                ", usuario=" + usuario +
                ", dataCompra=" + dataCompra +
                '}';
    }
}
