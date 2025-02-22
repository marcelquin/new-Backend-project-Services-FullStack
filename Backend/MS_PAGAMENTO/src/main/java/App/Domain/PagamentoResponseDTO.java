package App.Domain;

import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record PagamentoResponseDTO(
        Long id,
        FORMAPAGAMENTO formaPagamento,
        Boolean pago,
        Double valorTotal,
        Double parcelas,
        Double valorParcela,
        Double valorPago,
        Double valorDesconto,
        Double valorTroco,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataPagamento,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataSistema
) {
}
