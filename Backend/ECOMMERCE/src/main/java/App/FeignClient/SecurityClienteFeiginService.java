package App.FeignClient;

import App.Domain.Response.AuthenticationDTO;
import App.Domain.Response.ClienteDTO;
import App.Domain.Response.ClienteResponseDTO;
import App.Domain.Response.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "clienteSecurity-service", url = "http://localhost:8081/ms_clienteauth")
public interface SecurityClienteFeiginService {

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data);

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data);


}
