package App.FeignClient;


import App.Domain.MsServicesDTO.VendaRequestFinalziadaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "financeiro-service", url = "http://localhost:8000/financeiro/financeiroms")
public interface FinanceiroFeiginService {


    @PostMapping("/NovoLancamentoVendasRealizadas")
    public void NovoLancamentoVendasRealizadas(@RequestParam VendaRequestFinalziadaDTO dto);


}
