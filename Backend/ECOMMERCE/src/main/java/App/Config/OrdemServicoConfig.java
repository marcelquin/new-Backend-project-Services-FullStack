package App.Config;

import App.Infra.Gateway.VendaGateway;
import App.Infra.UseCase.OrdemServico.UseCaseOrdemServicoGet;
import App.Infra.UseCase.OrdemServico.UseCaseOrdemServicoPost;
import App.Infra.UseCase.OrdemServico.UseCaseOrdemServicoPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrdemServicoConfig {

    @Bean
    UseCaseOrdemServicoGet useCaseOrdemServicoGet(VendaGateway vendaGateway)
    {return new UseCaseOrdemServicoGet(vendaGateway);}

    @Bean
    UseCaseOrdemServicoPost useCaseOrdemServicoPost(VendaGateway vendaGateway)
    {return new UseCaseOrdemServicoPost(vendaGateway);}

    @Bean
    UseCaseOrdemServicoPut useCaseOrdemServicoPut(VendaGateway vendaGateway)
    {return new UseCaseOrdemServicoPut(vendaGateway);}
}
