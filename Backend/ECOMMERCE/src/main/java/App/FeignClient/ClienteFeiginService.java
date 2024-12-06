package App.FeignClient;

import App.Domain.Response.ClienteDTO;
import App.Domain.Response.ClienteResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "cliente-service", url = "http://localhost:8000/mscliente/mscliente")
public interface ClienteFeiginService {

    @GetMapping("/ListarClientes")
    public List<ClienteDTO> ListarClientes();

    @GetMapping("/BuscarClientesPorId")
    public ClienteResponseDTO BuscarClientesPorId(@RequestParam Long id);


    @PostMapping("/NovoCliente")
    public ClienteDTO NovoCliente(@RequestParam String nome,
                                  @RequestParam String sobrenome,
                                  @RequestParam LocalDate dataNascimento,
                                  @RequestParam String logradouro,
                                  @RequestParam String numero,
                                  @RequestParam String bairro,
                                  @RequestParam String referencia,
                                  @RequestParam String cep,
                                  @RequestParam Long prefixo,
                                  @RequestParam Long telefone,
                                  @RequestParam String email,
                                  @RequestParam Double score);

   @PutMapping("/EditarCliente")
    public ClienteResponseDTO EditarCliente(@RequestParam Long id,
                                                            @RequestParam String nome,
                                                            @RequestParam String sobrenome,
                                                            @RequestParam LocalDate dataNascimento,
                                                            @RequestParam String logradouro,
                                                            @RequestParam String numero,
                                                            @RequestParam String bairro,
                                                            @RequestParam String referencia,
                                                            @RequestParam String cep,
                                                            @RequestParam Long prefixo,
                                                            @RequestParam Long telefone,
                                                            @RequestParam String email,
                                                            @RequestParam Double score);

    @PutMapping("/AlterarScoreClientes")
    public ClienteResponseDTO AlterarScoreClientes(@RequestParam Long id,
                                                                   @RequestParam Double score);

    @DeleteMapping("/DeletarClientesPorId")
    public void DeletarClientesPorId(@RequestParam Long id);


}
