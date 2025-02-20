package App.Infra.UseCase.OrdemServico;

import App.Domain.Response.CupomFiscal;
import App.Domain.Response.VendaResponseDTO;
import App.Infra.Gateway.VendaGateway;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseOrdemServicoPut {

    private final VendaGateway vendaGateway;

    public UseCaseOrdemServicoPut(VendaGateway vendaGateway) {
        this.vendaGateway = vendaGateway;
    }

    public ResponseEntity<VendaResponseDTO> AdicionarItem(@RequestParam Long idVenda,
                                                          @RequestParam Long idProduto,
                                                          @RequestParam Double quantidade)
    {return vendaGateway.AdicionarItem(idVenda, idProduto,quantidade);}

    public ResponseEntity<CupomFiscal> AdicionarCLienteCadastrado(@RequestParam Long vendaId,
                                                                  @RequestParam Long clienteId)
    {return vendaGateway.AdicionarCLienteCadastrado(vendaId, clienteId);}

    public ResponseEntity<CupomFiscal> AdicionarCLienteNaoCadastrado(@RequestParam Long vendaId,
                                                                     @RequestParam String cliente,
                                                                     @RequestParam Long documento)
    {return vendaGateway.AdicionarCLienteNaoCadastrado(vendaId, cliente, documento);}

    public ResponseEntity<CupomFiscal> FinalizarVenda(@RequestParam Long idVenda,
                                                      @RequestParam FORMAPAGAMENTO formapagamento,
                                                      Double valorPago,
                                                      Double parcelas)
    {return vendaGateway.FinalizarVenda(idVenda, formapagamento, valorPago, parcelas);}

}
