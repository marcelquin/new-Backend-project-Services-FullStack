package App.Infra.UseCase.Security;


import App.Domain.Response.AuthenticationDTO;
import App.Domain.Response.RegisterDTO;
import App.Infra.Gateway.SecurityGateway;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class UseCaseSecurityPost {

    private final SecurityGateway securityGateway;


    public UseCaseSecurityPost(SecurityGateway securityGateway) {
        this.securityGateway = securityGateway;
    }

    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data)
    {return securityGateway.login(data);}

    public ResponseEntity register(@RequestBody @Valid RegisterDTO data)
    {return securityGateway.register(data);}
}
