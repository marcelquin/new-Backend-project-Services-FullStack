package App.Infra.Gateway;


import App.Domain.AuthenticationDTO;
import App.Domain.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthorizationGateway {

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data);

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data);
}
