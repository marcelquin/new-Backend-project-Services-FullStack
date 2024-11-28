package App.Config;


import App.Infra.Gateway.AuthorizationGateway;
import App.Infra.UseCase.Security.UseCaseAuthorizationPost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorizationConfig {

    @Bean
    UseCaseAuthorizationPost useCaseAuthorizationPost(AuthorizationGateway authorizationGateway)
    {return new UseCaseAuthorizationPost(authorizationGateway);}
}
