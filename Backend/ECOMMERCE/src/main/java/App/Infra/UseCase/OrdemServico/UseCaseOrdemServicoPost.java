package App.Infra.UseCase.OrdemServico;

import App.Domain.OrdemServicoResponseDTO;
import App.Infra.Gateway.OrdemServicoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseOrdemServicoPost {

    private final OrdemServicoGateway ordemServicoGateway;

    public UseCaseOrdemServicoPost(OrdemServicoGateway ordemServicoGateway) {
        this.ordemServicoGateway = ordemServicoGateway;
    }

    public ResponseEntity<OrdemServicoResponseDTO> NovaOrdemServico(Long idCliente,
                                                                    String cliente,
                                                                    @RequestParam Long prefixo,
                                                                    @RequestParam Long telefone,
                                                                    String email,
                                                                    @RequestParam String relato)
    {return ordemServicoGateway.NovaOrdemServico(idCliente, cliente, prefixo, telefone, email, relato);}
}
