package App.Infra.UseCase.Financeiro;

import App.Domain.Request.BoletosRequestDTO;
import App.Domain.Request.VendaRequestFinalziadaDTO;
import App.Infra.Gateway.FinanceiroGateway;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseFinanceiroPost {

    private final FinanceiroGateway financeiroGateway;

    public UseCaseFinanceiroPost(FinanceiroGateway financeiroGateway) {
        this.financeiroGateway = financeiroGateway;
    }

    public void NovoLancamentoVendasRealizadas(@RequestParam VendaRequestFinalziadaDTO dto)
    {financeiroGateway.NovoLancamentoVendasRealizadas(dto);}
    public void NovoLancamentoDebito(@RequestParam BoletosRequestDTO dto)
    {financeiroGateway.NovoLancamentoDebito(dto);}
}
