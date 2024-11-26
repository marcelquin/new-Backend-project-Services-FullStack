package App.Config;

import App.Infra.Gateway.OrdemServicoGateway;
import App.Infra.UseCase.OrdemServico.UseCaseOrdemServicoGet;
import App.Infra.UseCase.OrdemServico.UseCaseOrdemServicoPost;
import App.Infra.UseCase.OrdemServico.UseCaseOrdemServicoPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrdemServicoConfig {

    @Bean
    UseCaseOrdemServicoGet useCaseOrdemServicoGet(OrdemServicoGateway ordemServicoGateway)
    {return new UseCaseOrdemServicoGet(ordemServicoGateway);}

    @Bean
    UseCaseOrdemServicoPost useCaseOrdemServicoPost(OrdemServicoGateway ordemServicoGateway)
    {return new UseCaseOrdemServicoPost(ordemServicoGateway);}

    @Bean
    UseCaseOrdemServicoPut useCaseOrdemServicoPut(OrdemServicoGateway ordemServicoGateway)
    {return new UseCaseOrdemServicoPut(ordemServicoGateway);}
}
