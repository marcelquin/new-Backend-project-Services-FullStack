package App.Infra.UseCase.Cliente;

import App.Domain.Response.ClienteDTO;
import App.Infra.Gateway.ClienteGateway;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public class UseCaseClientePost {

    private final ClienteGateway clienteGateway;

    public UseCaseClientePost(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public ClienteDTO NovoCliente(@RequestParam String nome,
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
    {return clienteGateway.NovoCliente(nome, sobrenome, dataNascimento, logradouro, numero, bairro, referencia, cep, prefixo, telefone, email, score);}


}