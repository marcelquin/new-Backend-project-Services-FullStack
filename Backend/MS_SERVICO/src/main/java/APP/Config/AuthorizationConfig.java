package APP.Config;

import APP.Infra.Gateway.AuthorizationGateway;
import APP.Infra.UseCase.JWT.UseCaseAuthorizationPost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorizationConfig {

    @Bean
    UseCaseAuthorizationPost useCaseAuthorizationPost(AuthorizationGateway authorizationGateway)
    {return new UseCaseAuthorizationPost(authorizationGateway);}
}
