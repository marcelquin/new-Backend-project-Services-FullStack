package App.Infra.UseCase.Financeiro;

import App.Infra.Gateway.FinanceiroGateway;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseFinanceiroPut {

    private final FinanceiroGateway financeiroGateway;

    public UseCaseFinanceiroPut(FinanceiroGateway financeiroGateway) {
        this.financeiroGateway = financeiroGateway;
    }

    public void NovoPagamentoDebito(@RequestParam Long idBoleto,
                                    @RequestParam FORMAPAGAMENTO formapagamento,
                                    @RequestParam Double parcelas,
                                    @RequestParam Double descontoPagamentoAntecipado)
    {financeiroGateway.NovoPagamentoDebito(idBoleto, formapagamento, parcelas, descontoPagamentoAntecipado);}
}
