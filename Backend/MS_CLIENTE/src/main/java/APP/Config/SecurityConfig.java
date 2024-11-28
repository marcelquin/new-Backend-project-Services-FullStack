package APP.Config;

import APP.Infra.Gateway.SecurityGateway;
import APP.Infra.UseCase.Security.UseCaseSecurityPost;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    UseCaseSecurityPost useCaseSecurityPost(SecurityGateway securityGateway)
    {return new UseCaseSecurityPost(securityGateway);}
}
