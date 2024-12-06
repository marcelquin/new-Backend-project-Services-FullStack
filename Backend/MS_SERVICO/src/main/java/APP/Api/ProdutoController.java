package APP.Api;

import APP.Domain.ServicoDTO;
import APP.Domain.ServicoResponseDTO;
import APP.Infra.UseCase.Servico.UseCaseServicoDelete;
import APP.Infra.UseCase.Servico.UseCaseServicoGet;
import APP.Infra.UseCase.Servico.UseCaseServicoPost;
import APP.Infra.UseCase.Servico.UseCaseServicoPut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("msServico")
@Tag(name = "msProduto",
        description = "Gerencia informações referente a entidade")
@CrossOrigin(origins = "*")
public class ProdutoController {

    private final UseCaseServicoDelete caseServicoDelete;
    private final UseCaseServicoPost caseServicoPost;
    private final UseCaseServicoPut caseServicoPut;
    private final UseCaseServicoGet caseServicoGet;

    public ProdutoController(UseCaseServicoDelete caseServicoDelete, UseCaseServicoPost caseServicoPost, UseCaseServicoPut caseServicoPut, UseCaseServicoGet caseServicoGet) {
        this.caseServicoDelete = caseServicoDelete;
        this.caseServicoPost = caseServicoPost;
        this.caseServicoPut = caseServicoPut;
        this.caseServicoGet = caseServicoGet;
    }


    @Operation(summary = "Busca Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/ListarServicos")
    public ResponseEntity<List<ServicoDTO>> ListarServicos()
    {return caseServicoGet.ListarServicos();}

    @Operation(summary = "Busca Registro da tabela Por Id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/BuscarServicoPorId")
    public ResponseEntity<ServicoResponseDTO> BuscarServicoPorId(@RequestParam Long id)
    { return caseServicoGet.BuscarServicoPorId(id);}

    @Operation(summary = "Salva novo Registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("/NovoServico")
    public ResponseEntity<ServicoResponseDTO> NovoServico(@RequestParam String nome,
                                                          @RequestParam String descricao,
                                                          @RequestParam Double valorServico,
                                                          @RequestParam Double valorMaoDeObra)
    { return caseServicoPost.NovoServico(nome, descricao, valorServico, valorMaoDeObra);}

    @Operation(summary = "Altera Informação do Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/EditarServico")
    public ResponseEntity<ServicoResponseDTO> EditarServico(@RequestParam Long id,
                                                            @RequestParam String nome,
                                                            @RequestParam String descricao,
                                                            @RequestParam Double valorServico,
                                                            @RequestParam Double valorMaoDeObra)
    {return caseServicoPut.EditarServico(id, nome, descricao, valorServico, valorMaoDeObra);}

    @Operation(summary = "Altera Informação do Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/NovoValorServico")
    public ResponseEntity<ServicoResponseDTO> NovoValorServico(@RequestParam Long id,
                                                               @RequestParam Double novoValor)
    {return caseServicoPut.NovoValorServico(id, novoValor);}

    @Operation(summary = "Altera Informação do Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/reajusteValorServico")
    public ResponseEntity<ServicoResponseDTO> reajusteValorServico(@RequestParam Long id,
                                                                   @RequestParam Double porcentagemReajuste)
    {return  caseServicoPut.reajusteValorServico(id, porcentagemReajuste);}

    @Operation(summary = "Altera Informação do Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/DescontoValorServico")
    public ResponseEntity<ServicoResponseDTO> DescontoValorServico(@RequestParam Long id,
                                                                   @RequestParam Double porcentagemDesconto)
    { return  caseServicoPut.DescontoValorServico(id, porcentagemDesconto);}

    @Operation(summary = "Deleta Registro na tabela", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @DeleteMapping("/deletaServico")
    public void deletaServico(@RequestParam Long id)
    { caseServicoDelete.deletaServico(id);}
}
