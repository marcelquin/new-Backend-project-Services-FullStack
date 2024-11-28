package App.Infra.UseCase.Pagamento;

import App.Infra.Gateway.PagamentoGateway;
import App.Infra.Persistence.Entity.PagamentoEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UseCasePagamentoGet {

    private final PagamentoGateway pagamentoGateway;

    public UseCasePagamentoGet(PagamentoGateway pagamentoGateway) {
        this.pagamentoGateway = pagamentoGateway;
    }

    public ResponseEntity<List<PagamentoEntity>> ListarPagamentos()
    {return pagamentoGateway.ListarPagamentos();}


}
