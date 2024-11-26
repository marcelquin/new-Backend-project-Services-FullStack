package App.Infra.UseCase.OrdemServico;

import App.Domain.OrdemServicoResponseDTO;
import App.Infra.Gateway.OrdemServicoGateway;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseOrdemServicoPut {

    private final OrdemServicoGateway ordemServicoGateway;

    public UseCaseOrdemServicoPut(OrdemServicoGateway ordemServicoGateway) {
        this.ordemServicoGateway = ordemServicoGateway;
    }

    public ResponseEntity<OrdemServicoResponseDTO> AdicionarServico(@RequestParam Long idOrdemServico,
                                                                    @RequestParam Long idServico)
    {return ordemServicoGateway.AdicionarServico(idOrdemServico, idServico);}

    public ResponseEntity<OrdemServicoResponseDTO> IniciarOrdemServico(@RequestParam Long idOrdemServico)
    {return ordemServicoGateway.IniciarOrdemServico(idOrdemServico);}

    public ResponseEntity<OrdemServicoResponseDTO> FinalizarOrdemServico(@RequestParam Long idOrdemServico,
                                                                         @RequestParam FORMAPAGAMENTO formapagamento,
                                                                         Double valorPago,
                                                                         Double parcelas)
    {return ordemServicoGateway.FinalizarOrdemServico(idOrdemServico, formapagamento, valorPago, parcelas);}

}
