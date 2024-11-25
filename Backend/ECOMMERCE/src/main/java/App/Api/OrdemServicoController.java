package App.Api;

import App.Bussness.OrdemServicoService;
import App.Domain.OrdemServicoResponseDTO;
import App.Domain.OrdemServicoResponseFullDTO;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ordem_servico")
@Tag(name = "ordem_servico",
        description = "Manipula dados referente a entidade"
)
public class OrdemServicoController {

    private final OrdemServicoService service;

    public OrdemServicoController(OrdemServicoService service) {
        this.service = service;
    }

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/ListarOrdemServico")
    public ResponseEntity<List<OrdemServicoResponseFullDTO>> ListarOrdemServico()
    { return service.ListarOrdemServico();}

    @Operation(summary = "Busca Registros da tabela por Id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/BuscarOrdemServicoPorId")
    public ResponseEntity<OrdemServicoResponseFullDTO> BuscarOrdemServicoPorId(@RequestParam Long id)
    { return service.BuscarOrdemServicoPorId(id);}

    @Operation(summary = "Busca Registros da tabela por Código", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/BuscarOrdemServicoPorcodigo")
    public ResponseEntity<OrdemServicoResponseFullDTO> BuscarOrdemServicoPorcodigo(@RequestParam String codigo)
    { return service.BuscarOrdemServicoPorcodigo(codigo);}

    @Operation(summary = "Salva novo Registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("/NovaOrdemServico")
    public ResponseEntity<OrdemServicoResponseDTO> NovaOrdemServico(Long idCliente,
                                                                    String cliente,
                                                                    @RequestParam Long prefixo,
                                                                    @RequestParam Long telefone,
                                                                    String email,
                                                                    @RequestParam String relato)
    { return service.NovaOrdemServico(idCliente, cliente, prefixo, telefone, email, relato);}

    @Operation(summary = "Edita Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/AdicionarServico")
    public ResponseEntity<OrdemServicoResponseDTO> AdicionarServico(@RequestParam Long idOrdemServico,
                                                                    @RequestParam Long idServico)
    {return service.AdicionarServico(idOrdemServico, idServico);}

    @Operation(summary = "Edita Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/IniciarOrdemServico")
    public ResponseEntity<OrdemServicoResponseDTO> IniciarOrdemServico(@RequestParam Long idOrdemServico)
    { return service.IniciarOrdemServico(idOrdemServico);}

    @Operation(summary = "Edita Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/FinalizarOrdemServico")
    public ResponseEntity<OrdemServicoResponseDTO> FinalizarOrdemServico(@RequestParam Long idOrdemServico,
                                                                         @RequestParam FORMAPAGAMENTO formapagamento,
                                                                         Double valorPago,
                                                                         Double parcelas)
    { return service.FinalizarOrdemServico(idOrdemServico, formapagamento, valorPago, parcelas);}

}
