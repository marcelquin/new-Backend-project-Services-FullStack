package App.Infra.Gateway;

import App.Domain.RelatorioAnualDTO;
import App.Domain.RelatorioDiarioDTO;
import App.Domain.RelatorioMensalDTO;
import App.Domain.Request.BoletosRequestDTO;
import App.Domain.Request.VendaRequestFinalziadaDTO;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface FinanceiroGateway {

    public ResponseEntity<RelatorioDiarioDTO> BuscarRelatorioDiario();
    public ResponseEntity<RelatorioMensalDTO> BuscarRelatorioMensal();
    public ResponseEntity<RelatorioAnualDTO> BuscarRelatorioAnual();
    public void NovoLancamentoVendasRealizadas(@RequestParam VendaRequestFinalziadaDTO dto);
    public void NovoLancamentoDebito(@RequestParam BoletosRequestDTO dto);
    public void NovoPagamentoDebito(@RequestParam Long idBoleto,
                                    @RequestParam FORMAPAGAMENTO formapagamento,
                                    @RequestParam Double parcelas,
                                    @RequestParam Double descontoPagamentoAntecipado);
}
