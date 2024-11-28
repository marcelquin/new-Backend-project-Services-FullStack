package App.Infra.Gateway;

import App.Domain.PagamentoResponseDTO;
import App.Infra.Persistence.Entity.PagamentoEntity;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PagamentoGateway {


    public ResponseEntity<List<PagamentoEntity>> ListarPagamentos();
    public ResponseEntity<PagamentoResponseDTO> NovoPagamento(@RequestParam FORMAPAGAMENTO formapagamento,
                                                              @RequestParam Double parcelas,
                                                              @RequestParam Double valorPago,
                                                              @RequestParam Double porcentagemDesconto,
                                                              @RequestParam Double valorVenda);
}
