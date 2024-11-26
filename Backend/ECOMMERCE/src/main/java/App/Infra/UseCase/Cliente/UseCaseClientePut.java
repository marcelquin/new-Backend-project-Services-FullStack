package App.Infra.UseCase.Cliente;

import App.Domain.Response.ClienteResponseDTO;
import App.Infra.Gateway.ClienteGateway;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public class UseCaseClientePut {

    private final ClienteGateway clienteGateway;

    public UseCaseClientePut(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }


    public ClienteResponseDTO EditarCliente(@RequestParam Long id,
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
    { return clienteGateway.EditarCliente(id, nome, sobrenome, dataNascimento, logradouro, numero, bairro, referencia, cep, prefixo, telefone, email, score);}

    public ClienteResponseDTO AlterarScoreClientes(@RequestParam Long id,
                                                   @RequestParam Double score)
    {return clienteGateway.AlterarScoreClientes(id, score);}

}
