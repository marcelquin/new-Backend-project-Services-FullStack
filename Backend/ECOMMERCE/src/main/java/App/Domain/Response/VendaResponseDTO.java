package App.Domain.Response;

import App.Infra.Persistence.Enum.STATUSVENDA;

import java.time.LocalDateTime;
import java.util.List;

public record VendaResponseDTO(
        String cliente,
        String codigo,
        Double valorTotal,
        STATUSVENDA STATUSVENDA,
        List<ItemVendaDTO> items,
        LocalDateTime dataVenda
) {
}
