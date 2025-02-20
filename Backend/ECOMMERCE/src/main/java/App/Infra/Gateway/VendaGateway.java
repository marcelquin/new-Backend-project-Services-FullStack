package App.Infra.Gateway;

import App.Domain.Response.CupomFiscal;
import App.Domain.Response.VendaResponseDTO;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface VendaGateway {

    public ResponseEntity<List<CupomFiscal>> ListarVendas();
    public ResponseEntity<CupomFiscal> BuscarVendaPorId(@RequestParam Long id);
    public ResponseEntity<CupomFiscal> BuscarVendaPorCodigo(@RequestParam String codigo);
    public ResponseEntity<VendaResponseDTO> NovaVenda();

    public ResponseEntity<VendaResponseDTO> AdicionarItem(@RequestParam Long idVenda,
                                                          @RequestParam Long idProduto,
                                                          @RequestParam Double quantidade);

    public ResponseEntity<CupomFiscal> AdicionarCLienteCadastrado(@RequestParam Long vendaId,
                                                                  @RequestParam Long clienteId);

    public ResponseEntity<CupomFiscal> AdicionarCLienteNaoCadastrado(@RequestParam Long vendaId,
                                                                     @RequestParam String cliente,
                                                                     @RequestParam Long documento);


    public ResponseEntity<CupomFiscal> FinalizarVenda(@RequestParam Long idVenda,
                                                      @RequestParam FORMAPAGAMENTO formapagamento,
                                                      Double valorPago,
                                                      Double parcelas);
}
