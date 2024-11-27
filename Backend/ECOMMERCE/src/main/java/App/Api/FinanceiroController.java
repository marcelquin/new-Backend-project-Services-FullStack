package App.Api;

import App.Domain.Request.BoletosRequestDTO;
import App.Domain.Request.VendaRequestFinalziadaDTO;
import App.Domain.Response.RelatorioAnualDTO;
import App.Domain.Response.RelatorioDiarioDTO;
import App.Domain.Response.RelatorioMensalDTO;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import App.Infra.UseCase.Financeiro.UseCaseFinanceiroGet;
import App.Infra.UseCase.Financeiro.UseCaseFinanceiroPost;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("financeiro")
@Tag(name = "financeiro",
        description = "Manipula dados referente a entidade"
)
public class FinanceiroController {


    private final UseCaseFinanceiroGet caseFinanceiroGet;
    private final UseCaseFinanceiroPost caseFinanceiroPost;


    public FinanceiroController(UseCaseFinanceiroGet caseFinanceiroGet, UseCaseFinanceiroPost caseFinanceiroPost) {
        this.caseFinanceiroGet = caseFinanceiroGet;
        this.caseFinanceiroPost = caseFinanceiroPost;
    }

    @Operation(summary = "Busca Registro na tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/BuscarRelatorioDiario")
    public ResponseEntity<RelatorioDiarioDTO> BuscarRelatorioDiario()
    { return caseFinanceiroGet.BuscarRelatorioDiario();}


    @Operation(summary = "Busca Registro na tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/BuscarRelatorioMensal")
    public ResponseEntity<RelatorioMensalDTO> BuscarRelatorioMensal()
    { return caseFinanceiroGet.BuscarRelatorioMensal();}

    @Operation(summary = "Busca Registro na tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/BuscarRelatorioAnual")
    public ResponseEntity<RelatorioAnualDTO> BuscarRelatorioAnual()
    {return caseFinanceiroGet.BuscarRelatorioAnual();}


    @Operation(summary = "Salva Registros na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("/NovoLancamentoVendasRealizadas")
    public void NovoLancamentoVendasRealizadas(@RequestParam VendaRequestFinalziadaDTO dto)
    {caseFinanceiroPost.NovoLancamentoVendasRealizadas(dto);}



    @Operation(summary = "Salva Registros na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("/NovoLancamentoDebito")
    public void NovoLancamentoDebito(@RequestParam BoletosRequestDTO dto)
    {caseFinanceiroPost.NovoLancamentoDebito(dto);}

    @Operation(summary = "Salva Registros na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/NovoPagamentoDebito")
    public void NovoPagamentoDebito(@RequestParam Long idBoleto,
                                    @RequestParam FORMAPAGAMENTO formapagamento,
                                    @RequestParam Double parcelas,
                                    @RequestParam Double descontoPagamentoAntecipado)
    {caseFinanceiroPost.NovoPagamentoDebito(idBoleto, formapagamento, parcelas,descontoPagamentoAntecipado);}


}
