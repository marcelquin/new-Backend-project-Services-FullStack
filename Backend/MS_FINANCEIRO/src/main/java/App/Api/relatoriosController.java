package App.Api;

import App.Domain.RelatorioAnualDTO;
import App.Domain.RelatorioDiarioDTO;
import App.Domain.RelatorioMensalDTO;
import App.Domain.Request.BoletosRequestDTO;
import App.Domain.Request.VendaRequestFinalziadaDTO;
import App.Infra.Persistence.Entity.RelatorioMensalEntity;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import App.Infra.UseCase.Financeiro.UseCaseFinanceiroGet;
import App.Infra.UseCase.Financeiro.UseCaseFinanceiroPost;
import App.Infra.UseCase.Financeiro.UseCaseFinanceiroPut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("financeiroms")
@Tag(name = "Relatorios Financeiros",
        description = "Manipula informações referentes a entidade"
)
@CrossOrigin(origins = "*")
public class relatoriosController {

    private final UseCaseFinanceiroGet caseFinanceiroGet;
    private final UseCaseFinanceiroPost caseFinanceiroPost;
    private final UseCaseFinanceiroPut caseFinanceiroPut;

    public relatoriosController(UseCaseFinanceiroGet caseFinanceiroGet, UseCaseFinanceiroPost caseFinanceiroPost, UseCaseFinanceiroPut caseFinanceiroPut) {
        this.caseFinanceiroGet = caseFinanceiroGet;
        this.caseFinanceiroPost = caseFinanceiroPost;
        this.caseFinanceiroPut = caseFinanceiroPut;
    }


/*    @GetMapping("/teste")
    public String teste()
    {
        return "teste aqui";
    }*/

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
    {caseFinanceiroPut.NovoPagamentoDebito(idBoleto, formapagamento, parcelas,descontoPagamentoAntecipado);}



}
