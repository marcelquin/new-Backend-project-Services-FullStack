package APP.Infra.UseCase.Servico;

import APP.Domain.ServicoResponseDTO;
import APP.Infra.Gateway.ServicoGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseServicoPut {

    private final ServicoGateway servicoGateway;

    public UseCaseServicoPut(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public ResponseEntity<ServicoResponseDTO> EditarServico(@RequestParam Long id,
                                                            @RequestParam String nome,
                                                            @RequestParam String descricao,
                                                            @RequestParam Double valorServico,
                                                            @RequestParam Double valorMaoDeObra)
    {return servicoGateway.EditarServico(id, nome, descricao, valorServico, valorMaoDeObra);}
    public ResponseEntity<ServicoResponseDTO> NovoValorServico(@RequestParam Long id,
                                                               @RequestParam Double novoValor)
    {return servicoGateway.NovoValorServico(id, novoValor);}
    public ResponseEntity<ServicoResponseDTO> reajusteValorServico(@RequestParam Long id,
                                                                   @RequestParam Double porcentagemReajuste)
    {return servicoGateway.reajusteValorServico(id, porcentagemReajuste);}

    public ResponseEntity<ServicoResponseDTO> DescontoValorServico(@RequestParam Long id,
                                                                   @RequestParam Double porcentagemDesconto)
    {return servicoGateway.DescontoValorServico(id, porcentagemDesconto);}

}
