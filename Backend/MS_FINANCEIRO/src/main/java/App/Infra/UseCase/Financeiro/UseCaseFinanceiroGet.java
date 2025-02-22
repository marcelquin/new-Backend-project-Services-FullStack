package App.Infra.UseCase.Financeiro;

import App.Domain.RelatorioAnualDTO;
import App.Domain.RelatorioDiarioDTO;
import App.Domain.RelatorioMensalDTO;
import App.Infra.Gateway.FinanceiroGateway;
import org.springframework.http.ResponseEntity;

public class UseCaseFinanceiroGet {

    private final FinanceiroGateway financeiroGateway;

    public UseCaseFinanceiroGet(FinanceiroGateway financeiroGateway) {
        this.financeiroGateway = financeiroGateway;
    }

    public ResponseEntity<RelatorioDiarioDTO> BuscarRelatorioDiario()
    {return financeiroGateway.BuscarRelatorioDiario();}
    public ResponseEntity<RelatorioMensalDTO> BuscarRelatorioMensal()
    {return financeiroGateway.BuscarRelatorioMensal();}
    public ResponseEntity<RelatorioAnualDTO> BuscarRelatorioAnual()
    {return financeiroGateway.BuscarRelatorioAnual();}
}
