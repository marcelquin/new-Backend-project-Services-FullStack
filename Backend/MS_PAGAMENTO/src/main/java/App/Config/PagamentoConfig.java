package App.Config;

import App.Bussness.PagamentoService;
import App.Infra.Gateway.PagamentoGateway;
import App.Infra.UseCase.Pagamento.UseCasePagamentoGet;
import App.Infra.UseCase.Pagamento.UseCasePagamentoPost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PagamentoConfig {

    @Bean
    UseCasePagamentoGet useCasePagamentoGet(PagamentoGateway pagamentoGateway)
    {return new UseCasePagamentoGet(pagamentoGateway);}

    @Bean
    UseCasePagamentoPost useCasePagamentoPost(PagamentoGateway pagamentoGateway)
    {return new UseCasePagamentoPost(pagamentoGateway);}
}
