package App.Config;

import App.Infra.Gateway.FinanceiroGateway;
import App.Infra.UseCase.Financeiro.UseCaseFinanceiroGet;
import App.Infra.UseCase.Financeiro.UseCaseFinanceiroPost;
import App.Infra.UseCase.Financeiro.UseCaseFinanceiroPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinanceiroConfig {

    private final FinanceiroGateway financeiroGateway;

    public FinanceiroConfig(FinanceiroGateway financeiroGateway) {
        this.financeiroGateway = financeiroGateway;
    }


    @Bean
    UseCaseFinanceiroGet useCaseFinanceiroGet(FinanceiroGateway financeiroGateway)
    { return new UseCaseFinanceiroGet(financeiroGateway);}
    @Bean
    UseCaseFinanceiroPost useCaseFinanceiroPost(FinanceiroGateway financeiroGateway)
    {return new UseCaseFinanceiroPost(financeiroGateway);}
    @Bean
    UseCaseFinanceiroPut useCaseFinanceiroPut(FinanceiroGateway financeiroGateway)
    {return new UseCaseFinanceiroPut(financeiroGateway);}
}
