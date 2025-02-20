package App.Infra.UseCase.OrdemServico;

import App.Domain.Response.VendaResponseDTO;
import App.Infra.Gateway.VendaGateway;
import org.springframework.http.ResponseEntity;

public class UseCaseOrdemServicoPost {

    private final VendaGateway vendaGateway;

    public UseCaseOrdemServicoPost(VendaGateway vendaGateway) {
        this.vendaGateway = vendaGateway;
    }

    public ResponseEntity<VendaResponseDTO> NovaVenda()
    {return vendaGateway.NovaVenda();}
}
