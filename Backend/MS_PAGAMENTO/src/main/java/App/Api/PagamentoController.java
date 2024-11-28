package App.Api;

import App.Domain.PagamentoResponseDTO;
import App.Infra.Persistence.Entity.PagamentoEntity;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import App.Infra.UseCase.Pagamento.UseCasePagamentoGet;
import App.Infra.UseCase.Pagamento.UseCasePagamentoPost;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ms_pagamento")
@Tag(name = "Micro serviço pagamento",
        description = "Responsavel por efetuar, salvar e retornar informação sobre o pagamento"
)
@CrossOrigin(origins = "*")
public class PagamentoController {

    private final UseCasePagamentoGet casePagamentoGet;
    private final UseCasePagamentoPost casePagamentoPost;

    public PagamentoController(UseCasePagamentoGet casePagamentoGet, UseCasePagamentoPost casePagamentoPost) {
        this.casePagamentoGet = casePagamentoGet;
        this.casePagamentoPost = casePagamentoPost;
    }


    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/ListarPagamentos")
    public ResponseEntity<List<PagamentoEntity>> ListarPagamentos()
    {return casePagamentoGet.ListarPagamentos();}

    @Operation(summary = "Salva novo Registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("/NovoPagamento")
    public ResponseEntity<PagamentoResponseDTO> NovoPagamento(@RequestParam FORMAPAGAMENTO formapagamento,
                                                              @RequestParam Double parcelas,
                                                              @RequestParam Double valorPago,
                                                              @RequestParam Double porcentagemDesconto,
                                                              @RequestParam Double valorVenda)
    {return casePagamentoPost.NovoPagamento(formapagamento, parcelas, valorPago, porcentagemDesconto, valorVenda);}
}
