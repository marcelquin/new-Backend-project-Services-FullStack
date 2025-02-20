package APP.Infra.Gateway;

import APP.Domain.ClienteDTO;
import APP.Domain.ClienteResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface ClienteGateway {

    public ResponseEntity<List<ClienteDTO>> ListarClientes();
    public ResponseEntity<ClienteResponseDTO> BuscarClientesPorId(@RequestParam Long id);
    public ResponseEntity<ClienteDTO> NovoCliente(@RequestParam String nome,
                                                  @RequestParam String sobrenome,
                                                  @RequestParam Long cpf,
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
    public ResponseEntity<ClienteResponseDTO> EditarCliente(@RequestParam Long id,
                                                            @RequestParam String nome,
                                                            @RequestParam String sobrenome,
                                                            @RequestParam Long cpf,
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
    public ResponseEntity<ClienteResponseDTO> AlterarScoreClientes(@RequestParam Long id,
                                                                   @RequestParam Double score);
    public void DeletarClientesPorId(@RequestParam Long id);
}
