package APP.Api;

import APP.Domain.ClienteDTO;
import APP.Domain.ClienteResponseDTO;
import APP.Infra.UseCase.Cliente.UseCaseClienteDelete;
import APP.Infra.UseCase.Cliente.UseCaseClienteGet;
import APP.Infra.UseCase.Cliente.UseCaseClientePost;
import APP.Infra.UseCase.Cliente.UseCaseClientePut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("mscliente")
@Tag(name = "Micro serviço Clientes",
        description = "Manipula informações relacionadas a entidade")
@CrossOrigin(origins = "*")
public class CLienteController {

        private final UseCaseClienteGet caseClienteGet;
        private final UseCaseClientePost caseClientePost;
        private final UseCaseClientePut caseClientePut;
        private final UseCaseClienteDelete caseClienteDelete;

        public CLienteController(UseCaseClienteGet caseClienteGet, UseCaseClientePost caseClientePost, UseCaseClientePut caseClientePut, UseCaseClienteDelete caseClienteDelete) {
                this.caseClienteGet = caseClienteGet;
                this.caseClientePost = caseClientePost;
                this.caseClientePut = caseClientePut;
                this.caseClienteDelete = caseClienteDelete;
        }


        @Operation(summary = "Lista Registros da tabela", method = "GET")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
                @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
                @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
                @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
        })
        @GetMapping("/ListarClientes")
        public ResponseEntity<List<ClienteDTO>> ListarClientes()
        { return caseClienteGet.ListarClientes();}


        @Operation(summary = "Busca Registro da tabela Por Id", method = "GET")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
                @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
                @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
                @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
        })
        @GetMapping("/BuscarClientesPorId")
        public ResponseEntity<ClienteResponseDTO> BuscarClientesPorId(@RequestParam Long id)
        { return caseClienteGet.BuscarClientesPorId(id);}

        @Operation(summary = "Salva novo Registro na tabela", method = "POST")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
                @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
                @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
                @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
        })
        @PostMapping("/NovoCliente")
        public ResponseEntity<ClienteDTO> NovoCliente(@RequestParam String nome,
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
        {return caseClientePost.NovoCliente(nome, sobrenome, dataNascimento, logradouro, numero, bairro, referencia, cep, prefixo, telefone, email, score);}

        @Operation(summary = "Edita Registro na tabela", method = "PUT")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
                @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
                @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
                @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
        })
        @PutMapping("/EditarCliente")
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
        {return caseClientePut.EditarCliente(id, nome, sobrenome, dataNascimento, logradouro, numero, bairro, referencia, cep, prefixo, telefone, email, score);}


        @Operation(summary = "Edita Registro na tabela", method = "PUT")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
                @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
                @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
                @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
        })
        @PutMapping("/AlterarScoreClientes")
        public ResponseEntity<ClienteResponseDTO> AlterarScoreClientes(@RequestParam Long id,
                                                                       @RequestParam Double score)
        { return caseClientePut.AlterarScoreClientes(id, score);}

        @Operation(summary = "Deleta Registro na tabela", method = "DELETE")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
                @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
                @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
                @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
        })
        @DeleteMapping("/DeletarClientesPorId")
        public void DeletarClientesPorId(@RequestParam Long id)
        { caseClienteDelete.DeletarClientesPorId(id);}
}
