package App.Infra.UseCase.Servico;

import App.Domain.Response.ServicoDTO;
import App.Domain.Response.ServicoResponseDTO;
import App.Infra.Gateway.ServicoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseServicoGet {

    private final ServicoGateway servicoGateway;


    public UseCaseServicoGet(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public ResponseEntity<List<ServicoDTO>> ListarServicos()
    { return servicoGateway.ListarServicos();}

    public ResponseEntity<ServicoResponseDTO> BuscarServicoPorId(@RequestParam Long id)
    { return servicoGateway.BuscarServicoPorId(id);}

}
