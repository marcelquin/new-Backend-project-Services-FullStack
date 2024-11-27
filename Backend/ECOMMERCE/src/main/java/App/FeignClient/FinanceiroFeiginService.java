package App.FeignClient;

import App.Domain.Request.BoletosRequestDTO;
import App.Domain.Request.VendaRequestFinalziadaDTO;
import App.Domain.Response.RelatorioAnualDTO;
import App.Domain.Response.RelatorioDiarioDTO;
import App.Domain.Response.RelatorioMensalDTO;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "financeiro-service", url = "http://localhost:8085/ms_financeiro")
public interface FinanceiroFeiginService {

    @GetMapping("/BuscarRelatorioDiario")
    public ResponseEntity<RelatorioDiarioDTO> BuscarRelatorioDiario();


    @GetMapping("/BuscarRelatorioMensal")
    public ResponseEntity<RelatorioMensalDTO> BuscarRelatorioMensal();

    @GetMapping("/BuscarRelatorioAnual")
    public ResponseEntity<RelatorioAnualDTO> BuscarRelatorioAnual();


    @PostMapping("/NovoLancamentoVendasRealizadas")
    public void NovoLancamentoVendasRealizadas(@RequestParam VendaRequestFinalziadaDTO dto);

    @PostMapping("/NovoLancamentoDebito")
    public void NovoLancamentoDebito(@RequestParam BoletosRequestDTO dto);
    @PutMapping("/NovoPagamentoDebito")
    public void NovoPagamentoDebito(@RequestParam Long idBoleto,
                                    @RequestParam FORMAPAGAMENTO formapagamento,
                                    @RequestParam Double parcelas,
                                    @RequestParam Double descontoPagamentoAntecipado);
}
