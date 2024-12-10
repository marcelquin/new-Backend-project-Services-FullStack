package App.Config;

import App.Infra.Gateway.SecurityGateway;
import App.Infra.UseCase.UseCaseSecurityPost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {

    private final SecurityGateway securityGateway;

    public AuthConfig(SecurityGateway securityGateway) {
        this.securityGateway = securityGateway;
    }

    @Bean
    UseCaseSecurityPost useCaseSecurityPost(SecurityGateway securityGateway)
    {return new UseCaseSecurityPost(securityGateway);}
}
