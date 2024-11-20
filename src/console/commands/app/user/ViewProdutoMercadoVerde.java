package console.commands.app.user;

import console.commands.app.AppCommand;
import database.Database;
import domain.models.CompraProdutoVerdeUsuario;
import domain.models.Usuario;

import java.util.List;
import java.util.Scanner;

public class ViewProdutoMercadoVerde extends AppCommand {

    private Usuario usuario;

    public ViewProdutoMercadoVerde(Scanner sc, Database db) {
        super(sc, db);
    }

    public ViewProdutoMercadoVerde(Scanner sc, Database db, Usuario usuario) {
        super(sc, db);
        this.usuario = usuario;
    }

    @Override
    public void run() {
        printer.banner("Produtos adquiridos no mercado verde");

        List<CompraProdutoVerdeUsuario> produtos = usuario.getProdutos().values().stream().toList();

        if(produtos.isEmpty()) {
            printer.soutln("Nenhum produto verde adquirido!");
            back();
            return;
        }

        for(CompraProdutoVerdeUsuario compra : produtos){
            System.out.printf("Produto: %s | Preço: %s | Data: %s",
                    compra.getProduto().getNome(),
                    compra.getProduto().getPrecoVerde(),
                    compra.getDataCompra()
            );
        }

        printer.soutln("");
        back();
    }
}
