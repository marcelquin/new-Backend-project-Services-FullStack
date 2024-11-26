package App.Infra.UseCase.Cliente;

import App.Domain.Response.ClienteDTO;
import App.Domain.Response.ClienteResponseDTO;
import App.Infra.Gateway.ClienteGateway;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseClienteGet {

    private final ClienteGateway clienteGateway;

    public UseCaseClienteGet(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public List<ClienteDTO> ListarClientes()
    {return clienteGateway.ListarClientes();}

    public ClienteResponseDTO BuscarClientesPorId(@RequestParam Long id)
    {return clienteGateway.BuscarClientesPorId(id);}

}
