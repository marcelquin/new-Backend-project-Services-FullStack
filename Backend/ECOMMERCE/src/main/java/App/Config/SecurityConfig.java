package App.Config;


import App.Infra.Gateway.SecurityGateway;
import App.Infra.UseCase.Security.UseCaseSecurityPost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    UseCaseSecurityPost useCaseSecurityPost(SecurityGateway securityGateway)
    {return new UseCaseSecurityPost(securityGateway);}
}
