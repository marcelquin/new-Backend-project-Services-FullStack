package App.Domain.MsServicesDTO;

import java.time.LocalDateTime;

public record ServicoResponseDTO(
        String nome,
        String descricao,
        String codigo,
        String valor,
        String maoDeObra
) {
}
