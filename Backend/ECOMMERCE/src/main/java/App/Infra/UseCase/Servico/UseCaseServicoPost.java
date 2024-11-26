package App.Infra.UseCase.Servico;

import App.Domain.Response.ServicoResponseDTO;
import App.Infra.Gateway.ServicoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseServicoPost {

    private final ServicoGateway servicoGateway;


    public UseCaseServicoPost(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public ResponseEntity<ServicoResponseDTO> NovoServico(@RequestParam String nome,
                                                          @RequestParam String descricao,
                                                          @RequestParam Double valorServico,
                                                          @RequestParam Double valorMaoDeObra)
    { return servicoGateway.NovoServico(nome, descricao, valorServico, valorMaoDeObra);}
}