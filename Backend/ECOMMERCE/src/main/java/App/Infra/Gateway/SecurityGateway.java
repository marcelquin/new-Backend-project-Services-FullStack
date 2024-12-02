package App.Infra.Gateway;


import App.Domain.Response.AuthenticationDTO;
import App.Domain.Response.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface SecurityGateway {

    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data);

    public ResponseEntity register(@RequestBody @Valid RegisterDTO data);
}
