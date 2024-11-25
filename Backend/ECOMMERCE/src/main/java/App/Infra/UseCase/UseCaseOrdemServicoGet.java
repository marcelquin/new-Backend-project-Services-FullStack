package App.Infra.UseCase;

import App.Domain.OrdemServicoResponseFullDTO;
import App.Infra.Gateway.OrdemServicoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseOrdemServicoGet {

    private final OrdemServicoGateway ordemServicoGateway;


    public UseCaseOrdemServicoGet(OrdemServicoGateway ordemServicoGateway) {
        this.ordemServicoGateway = ordemServicoGateway;
    }

    public ResponseEntity<List<OrdemServicoResponseFullDTO>> ListarOrdemServico()
    { return ordemServicoGateway.ListarOrdemServico();}
    public ResponseEntity<OrdemServicoResponseFullDTO> BuscarOrdemServicoPorId(@RequestParam Long id)
    {return ordemServicoGateway.BuscarOrdemServicoPorId(id);}
    public ResponseEntity<OrdemServicoResponseFullDTO> BuscarOrdemServicoPorcodigo(@RequestParam String codigo)
    {return ordemServicoGateway.BuscarOrdemServicoPorcodigo(codigo);}

}
