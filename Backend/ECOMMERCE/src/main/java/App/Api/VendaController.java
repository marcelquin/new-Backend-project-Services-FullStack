package App.Api;

import App.Domain.Response.CupomFiscal;
import App.Domain.Response.VendaResponseDTO;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import App.Infra.UseCase.OrdemServico.UseCaseOrdemServicoGet;
import App.Infra.UseCase.OrdemServico.UseCaseOrdemServicoPost;
import App.Infra.UseCase.OrdemServico.UseCaseOrdemServicoPut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ecommerce")
@Tag(name = "ecommerce",
        description = "Manipula dados referente a entidade"
)
public class VendaController {

    private final UseCaseOrdemServicoGet caseOrdemServicoGet;
    private final UseCaseOrdemServicoPost caseOrdemServicoPost;
    private final UseCaseOrdemServicoPut caseOrdemServicoPut;

    public VendaController(UseCaseOrdemServicoGet caseOrdemServicoGet, UseCaseOrdemServicoPost caseOrdemServicoPost, UseCaseOrdemServicoPut caseOrdemServicoPut) {
        this.caseOrdemServicoGet = caseOrdemServicoGet;
        this.caseOrdemServicoPost = caseOrdemServicoPost;
        this.caseOrdemServicoPut = caseOrdemServicoPut;
    }


    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/ListarVendas")
    public ResponseEntity<List<CupomFiscal>> ListarVendas()
    { return caseOrdemServicoGet.ListarVendas();}

    @Operation(summary = "Busca Registros da tabela por Id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/BuscarVendaPorId")
    public ResponseEntity<CupomFiscal> BuscarVendaPorId(@RequestParam Long id)
    { return caseOrdemServicoGet.BuscarVendaPorId(id);}

    @Operation(summary = "Busca Registros da tabela por Código", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/BuscarVendaPorCodigo")
    public ResponseEntity<CupomFiscal> BuscarVendaPorCodigo(@RequestParam String codigo)
    { return caseOrdemServicoGet.BuscarVendaPorCodigo(codigo);}

    @Operation(summary = "Salva novo Registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("/NovaVenda")
    public ResponseEntity<VendaResponseDTO> NovaVenda()
    { return caseOrdemServicoPost.NovaVenda();}

    @Operation(summary = "Edita Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/AdicionarItem")
    public ResponseEntity<VendaResponseDTO> AdicionarItem(@RequestParam Long idVenda,
                                                          @RequestParam Long idProduto,
                                                          @RequestParam Double quantidade)
    {return caseOrdemServicoPut.AdicionarItem(idVenda, idProduto,quantidade);}

    @Operation(summary = "Edita Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/AdicionarCLienteCadastrado")
    public ResponseEntity<CupomFiscal> AdicionarCLienteCadastrado(@RequestParam Long vendaId,
                                                                  @RequestParam Long clienteId)
    {return caseOrdemServicoPut.AdicionarCLienteCadastrado(vendaId,clienteId);}

    @Operation(summary = "Edita Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/AdicionarCLienteNaoCadastrado")
    public ResponseEntity<CupomFiscal> AdicionarCLienteNaoCadastrado(@RequestParam Long vendaId,
                                                                     @RequestParam String cliente,
                                                                     @RequestParam Long documento)
    {return caseOrdemServicoPut.AdicionarCLienteNaoCadastrado(vendaId, cliente, documento);}

    @Operation(summary = "Edita Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/FinalizarVenda")
    public ResponseEntity<CupomFiscal> FinalizarVenda(@RequestParam Long idVenda,
                                                      @RequestParam FORMAPAGAMENTO formapagamento,
                                                      Double valorPago,
                                                      Double parcelas)
    { return caseOrdemServicoPut.FinalizarVenda(idVenda, formapagamento, valorPago, parcelas);}

}
