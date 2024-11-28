package App.Infra.UseCase.Security;


import App.Domain.AuthenticationDTO;
import App.Domain.RegisterDTO;
import App.Infra.Gateway.AuthorizationGateway;
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
