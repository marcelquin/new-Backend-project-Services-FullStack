package App.FeignClient;

import App.Domain.Request.BoletosRequestDTO;
import App.Domain.Request.VendaRequestFinalziadaDTO;
import App.Domain.Response.*;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "financeiroSecurity-service", url = "http://localhost:8085/ms_financeirooauth")
public interface SecurityFinanceiroFeiginService {

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data);

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data);
}
