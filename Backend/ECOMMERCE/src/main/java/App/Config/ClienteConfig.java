package App.Config;

import App.Infra.Gateway.ClienteGateway;
import App.Infra.UseCase.Cliente.UseCaseClienteDelete;
import App.Infra.UseCase.Cliente.UseCaseClienteGet;
import App.Infra.UseCase.Cliente.UseCaseClientePost;
import App.Infra.UseCase.Cliente.UseCaseClientePut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    UseCaseClienteGet useCaseClienteGet(ClienteGateway clienteGateway)
    { return new UseCaseClienteGet(clienteGateway);}

    @Bean
    UseCaseClientePost useCaseClientePost(ClienteGateway clienteGateway)
    {return new UseCaseClientePost(clienteGateway);}

    @Bean
    UseCaseClientePut useCaseClientePut(ClienteGateway clienteGateway)
    { return new UseCaseClientePut(clienteGateway);}

    @Bean
    UseCaseClienteDelete useCaseClienteDelete(ClienteGateway clienteGateway)
    { return new UseCaseClienteDelete(clienteGateway);}
}
