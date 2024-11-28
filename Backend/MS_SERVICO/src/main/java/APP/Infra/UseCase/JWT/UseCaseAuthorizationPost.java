package APP.Infra.UseCase.JWT;

import APP.Domain.AuthenticationDTO;
import APP.Domain.RegisterDTO;
import APP.Infra.Gateway.AuthorizationGateway;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class UseCaseAuthorizationPost {

    private final AuthorizationGateway authorizationGateway;


    public UseCaseAuthorizationPost(AuthorizationGateway authorizationGateway) {
        this.authorizationGateway = authorizationGateway;
    }

    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data)
    {return authorizationGateway.login(data);}


    public ResponseEntity register(@RequestBody @Valid RegisterDTO data)
    {return authorizationGateway.register(data);}
}
