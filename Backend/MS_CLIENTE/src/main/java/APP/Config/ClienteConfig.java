package APP.Config;

import APP.Infra.Gateway.ClienteGateway;
import APP.Infra.UseCase.Cliente.UseCaseClienteDelete;
import APP.Infra.UseCase.Cliente.UseCaseClienteGet;
import APP.Infra.UseCase.Cliente.UseCaseClientePost;
import APP.Infra.UseCase.Cliente.UseCaseClientePut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    UseCaseClienteGet useCaseClienteGet(ClienteGateway clienteGateway)
    {return new UseCaseClienteGet(clienteGateway);}
    @Bean
    UseCaseClientePost useCaseClientePost(ClienteGateway clienteGateway)
    {return new UseCaseClientePost(clienteGateway);}
    @Bean
    UseCaseClientePut useCaseClientePut(ClienteGateway clienteGateway)
    {return new UseCaseClientePut(clienteGateway);}
    @Bean
    UseCaseClienteDelete useCaseClienteDelete(ClienteGateway clienteGateway)
    {return new UseCaseClienteDelete(clienteGateway);}
}
