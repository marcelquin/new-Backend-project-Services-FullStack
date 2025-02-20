package App.Domain.Response;

import App.Infra.Persistence.Enum.STATUSVENDA;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record CupomFiscal(
        String cliente,
        Long documento,
        String codigo,
        Double valorTotal,
        STATUSVENDA statusVenda,
        List<ItemVendaDTO> items,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataVenda,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataPagamento

) {
}
