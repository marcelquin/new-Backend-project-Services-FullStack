package App.Infra.Gateway;

import App.Domain.OrdemServicoResponseDTO;
import App.Domain.OrdemServicoResponseFullDTO;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrdemServicoGateway {

    public ResponseEntity<List<OrdemServicoResponseFullDTO>> ListarOrdemServico();
    public ResponseEntity<OrdemServicoResponseFullDTO> BuscarOrdemServicoPorId(@RequestParam Long id);
    public ResponseEntity<OrdemServicoResponseFullDTO> BuscarOrdemServicoPorcodigo(@RequestParam String codigo);
    public ResponseEntity<OrdemServicoResponseDTO> NovaOrdemServico(Long idCliente,
                                                                    String cliente,
                                                                    @RequestParam Long prefixo,
                                                                    @RequestParam Long telefone,
                                                                    String email,
                                                                    @RequestParam String relato);
    public ResponseEntity<OrdemServicoResponseDTO> AdicionarServico(@RequestParam Long idOrdemServico,
                                                                    @RequestParam Long idServico);

    public ResponseEntity<OrdemServicoResponseDTO> IniciarOrdemServico(@RequestParam Long idOrdemServico);

    public ResponseEntity<OrdemServicoResponseDTO> FinalizarOrdemServico(@RequestParam Long idOrdemServico,
                                                                         @RequestParam FORMAPAGAMENTO formapagamento,
                                                                         Double valorPago,
                                                                         Double parcelas);
}
