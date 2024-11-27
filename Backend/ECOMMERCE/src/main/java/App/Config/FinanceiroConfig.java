package App.Config;

import App.Infra.Gateway.FinanceiroGateway;
import App.Infra.UseCase.Financeiro.UseCaseFinanceiroGet;
import App.Infra.UseCase.Financeiro.UseCaseFinanceiroPost;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinanceiroConfig {

    @Bean
    UseCaseFinanceiroGet useCaseFinanceiroGet(FinanceiroGateway financeiroGateway)
    {return new UseCaseFinanceiroGet(financeiroGateway);}

    @Bean
    UseCaseFinanceiroPost useCaseFinanceiroPost(FinanceiroGateway financeiroGateway)
    {return new UseCaseFinanceiroPost(financeiroGateway);}
}
