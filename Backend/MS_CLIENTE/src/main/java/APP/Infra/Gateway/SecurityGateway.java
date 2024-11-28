package APP.Infra.Gateway;

import APP.Domain.AuthenticationDTO;
import APP.Domain.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface SecurityGateway {

    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data);

    public ResponseEntity register(@RequestBody @Valid RegisterDTO data);
}
