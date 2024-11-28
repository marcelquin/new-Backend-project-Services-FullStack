package APP.Config;

import APP.Infra.Gateway.ServicoGateway;
import APP.Infra.UseCase.Servico.UseCaseServicoDelete;
import APP.Infra.UseCase.Servico.UseCaseServicoGet;
import APP.Infra.UseCase.Servico.UseCaseServicoPost;
import APP.Infra.UseCase.Servico.UseCaseServicoPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicoConfig {

    @Bean
    UseCaseServicoGet useCaseServicoGet(ServicoGateway servicoGateway)
    {return new UseCaseServicoGet(servicoGateway);}
    @Bean
    UseCaseServicoPost useCaseServicoPost(ServicoGateway servicoGateway)
    {return new UseCaseServicoPost(servicoGateway);}
    @Bean
    UseCaseServicoPut useCaseServicoPut(ServicoGateway servicoGateway)
    {return new UseCaseServicoPut(servicoGateway);}
    @Bean
    UseCaseServicoDelete useCaseServicoDelete(ServicoGateway servicoGateway)
    {return new UseCaseServicoDelete(servicoGateway);}
}
