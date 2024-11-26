package App.Infra.Gateway;

import App.Domain.Response.ClienteDTO;
import App.Domain.Response.ClienteResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

public interface ClienteGateway {


    public List<ClienteDTO> ListarClientes();

    public ClienteResponseDTO BuscarClientesPorId(@RequestParam Long id);


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
                                  Double score);

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
                                            Double score);

    public ClienteResponseDTO AlterarScoreClientes(@RequestParam Long id,
                                                   @RequestParam Double score);

    public void DeletarClientesPorId(@RequestParam Long id);
}
