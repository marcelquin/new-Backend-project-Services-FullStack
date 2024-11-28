package App.Infra.UseCase.Pagamento;

import App.Domain.PagamentoResponseDTO;
import App.Infra.Gateway.PagamentoGateway;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePagamentoPost {

    private final PagamentoGateway pagamentoGateway;

    public UseCasePagamentoPost(PagamentoGateway pagamentoGateway) {
        this.pagamentoGateway = pagamentoGateway;
    }

    public ResponseEntity<PagamentoResponseDTO> NovoPagamento(@RequestParam FORMAPAGAMENTO formapagamento,
                                                              @RequestParam Double parcelas,
                                                              @RequestParam Double valorPago,
                                                              @RequestParam Double porcentagemDesconto,
                                                              @RequestParam Double valorVenda)
    {return pagamentoGateway.NovoPagamento(formapagamento, parcelas, valorPago, porcentagemDesconto, valorVenda);}
}
