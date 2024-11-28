package APP.Infra.UseCase.Servico;

import APP.Domain.ServicoDTO;
import APP.Domain.ServicoResponseDTO;
import APP.Infra.Gateway.ServicoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseServicoGet {

    private final ServicoGateway servicoGateway;

    public UseCaseServicoGet(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public ResponseEntity<List<ServicoDTO>> ListarServicos()
    {return servicoGateway.ListarServicos();}
    public ResponseEntity<ServicoResponseDTO> BuscarServicoPorId(@RequestParam Long id)
    {return servicoGateway.BuscarServicoPorId(id);}
}
