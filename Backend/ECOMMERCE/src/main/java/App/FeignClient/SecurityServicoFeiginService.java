package App.FeignClient;

import App.Domain.Response.AuthenticationDTO;
import App.Domain.Response.RegisterDTO;
import App.Domain.Response.ServicoDTO;
import App.Domain.Response.ServicoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "servicoSecurity-service", url = "http://localhost:8082/ms_servicoauth")
public interface SecurityServicoFeiginService {

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data);

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data);
}
