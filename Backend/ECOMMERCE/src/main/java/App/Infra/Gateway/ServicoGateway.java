package App.Infra.Gateway;

import App.Domain.Response.ServicoDTO;
import App.Domain.Response.ServicoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ServicoGateway {

    public ResponseEntity<List<ServicoDTO>> ListarServicos();

    public ResponseEntity<ServicoResponseDTO> BuscarServicoPorId(@RequestParam Long id);

    public ResponseEntity<ServicoResponseDTO> NovoServico(@RequestParam String nome,
                                                          @RequestParam String descricao,
                                                          @RequestParam Double valorServico,
                                                          @RequestParam Double valorMaoDeObra);

    public ResponseEntity<ServicoResponseDTO> EditarServico(@RequestParam Long id,
                                                            @RequestParam String nome,
                                                            @RequestParam String descricao,
                                                            @RequestParam Double valorServico,
                                                            @RequestParam Double valorMaoDeObra);

    public ResponseEntity<ServicoResponseDTO> NovoValorServico(@RequestParam Long id,
                                                               @RequestParam Double novoValor);

    public ResponseEntity<ServicoResponseDTO> reajusteValorServico(@RequestParam Long id,
                                                                   @RequestParam Double porcentagemReajuste);

    public ResponseEntity<ServicoResponseDTO> DescontoValorServico(@RequestParam Long id,
                                                                   @RequestParam Double porcentagemDesconto);

    public void deletaServico(@RequestParam Long id);
}
