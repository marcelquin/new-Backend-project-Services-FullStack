package App.FeignClient;

import App.Domain.Response.ServicoDTO;
import App.Domain.Response.ServicoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "servico-service", url = "http://localhost:8000/msservico/msservico")
public interface ServicoFeiginService {

    @GetMapping("/ListarServicos")
    public ResponseEntity<List<ServicoDTO>> ListarServicos();

    @GetMapping("/BuscarServicoPorId")
    public ResponseEntity<ServicoResponseDTO> BuscarServicoPorId(@RequestParam Long id);

    @PostMapping("/NovoServico")
    public ResponseEntity<ServicoResponseDTO> NovoServico(@RequestParam String nome,
                                                          @RequestParam String descricao,
                                                          @RequestParam Double valorServico,
                                                          @RequestParam Double valorMaoDeObra);
    @PutMapping("/EditarServico")
    public ResponseEntity<ServicoResponseDTO> EditarServico(@RequestParam Long id,
                                                            @RequestParam String nome,
                                                            @RequestParam String descricao,
                                                            @RequestParam Double valorServico,
                                                            @RequestParam Double valorMaoDeObra);
    @PutMapping("/NovoValorServico")
    public ResponseEntity<ServicoResponseDTO> NovoValorServico(@RequestParam Long id,
                                                               @RequestParam Double novoValor);
    @PutMapping("/reajusteValorServico")
    public ResponseEntity<ServicoResponseDTO> reajusteValorServico(@RequestParam Long id,
                                                                   @RequestParam Double porcentagemReajuste);
    @PutMapping("/DescontoValorServico")
    public ResponseEntity<ServicoResponseDTO> DescontoValorServico(@RequestParam Long id,
                                                                   @RequestParam Double porcentagemDesconto);
    @DeleteMapping("/deletaServico")
    public void deletaServico(@RequestParam Long id);
}
