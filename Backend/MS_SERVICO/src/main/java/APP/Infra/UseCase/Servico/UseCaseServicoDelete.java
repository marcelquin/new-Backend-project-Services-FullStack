package APP.Infra.UseCase.Servico;

import APP.Infra.Gateway.ServicoGateway;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseServicoDelete {

    private final ServicoGateway servicoGateway;

    public UseCaseServicoDelete(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public void deletaServico(@RequestParam Long id)
    {servicoGateway.deletaServico(id);}
}
