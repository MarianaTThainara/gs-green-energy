package domain.services;

import domain.interfaces.GrupoTipoPlanoAcaoInterface;
import domain.models.Usuario;
import infra.api.EmpresaEnergiaApi;

public class GrupoEnergiaTipoPlanoAcaoService extends Service implements GrupoTipoPlanoAcaoInterface {

    private final Usuario usuario;

    public GrupoEnergiaTipoPlanoAcaoService(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public float getData() {
        EmpresaEnergiaApi api = new EmpresaEnergiaApi(usuario.getCpf());
        return (float) api.fetch();
    }
}
