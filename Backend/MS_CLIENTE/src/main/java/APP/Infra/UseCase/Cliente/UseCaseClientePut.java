package APP.Infra.UseCase.Cliente;

import APP.Domain.ClienteResponseDTO;
import APP.Infra.Gateway.ClienteGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public class UseCaseClientePut {

    private final ClienteGateway clienteGateway;

    public UseCaseClientePut(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public ResponseEntity<ClienteResponseDTO> EditarCliente(@RequestParam Long id,
                                                            @RequestParam String nome,
                                                            @RequestParam String sobrenome,
                                                            @RequestParam LocalDate dataNascimento,
                                                            String logradouro,
                                                            @RequestParam String numero,
                                                            String bairro,
                                                            String referencia,
                                                            @RequestParam String cep,
                                                            @RequestParam Long prefixo,
                                                            @RequestParam Long telefone,
                                                            @RequestParam String email,
                                                            Double score)
    {return clienteGateway.EditarCliente(id, nome, sobrenome, dataNascimento, logradouro, numero, bairro, referencia, cep, prefixo, telefone, email, score);}
    public ResponseEntity<ClienteResponseDTO> AlterarScoreClientes(@RequestParam Long id,
                                                                   @RequestParam Double score)
    {return clienteGateway.AlterarScoreClientes(id, score);}
}
