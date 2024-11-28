package APP.Infra.UseCase.Cliente;

import APP.Domain.ClienteDTO;
import APP.Domain.ClienteResponseDTO;
import APP.Infra.Gateway.ClienteGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseClienteGet {

    private final ClienteGateway clienteGateway;

    public UseCaseClienteGet(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public ResponseEntity<List<ClienteDTO>> ListarClientes()
    {return clienteGateway.ListarClientes();}
    public ResponseEntity<ClienteResponseDTO> BuscarClientesPorId(@RequestParam Long id)
    {return clienteGateway.BuscarClientesPorId(id);}
}
