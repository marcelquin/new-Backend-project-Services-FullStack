package App.Config;

import App.Infra.Gateway.ServicoGateway;
import App.Infra.UseCase.Cliente.UseCaseClientePut;
import App.Infra.UseCase.Servico.UseCaseServicoDelete;
import App.Infra.UseCase.Servico.UseCaseServicoGet;
import App.Infra.UseCase.Servico.UseCaseServicoPost;
import App.Infra.UseCase.Servico.UseCaseServicoPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicoConfig {

    @Bean
    UseCaseServicoGet useCaseServicoGet(ServicoGateway servicoGateway)
    {return new UseCaseServicoGet(servicoGateway);}

    @Bean
    UseCaseServicoPost useCaseServicoPost(ServicoGateway servicoGateway)
    { return new UseCaseServicoPost(servicoGateway);}

    @Bean
    UseCaseServicoPut useCaseServicoPut(ServicoGateway servicoGateway)
    {return new UseCaseServicoPut(servicoGateway);}
    @Bean
    UseCaseServicoDelete useCaseServicoDelete(ServicoGateway servicoGateway)
    {return new UseCaseServicoDelete(servicoGateway);}
}
