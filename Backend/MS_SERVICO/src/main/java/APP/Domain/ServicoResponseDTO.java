package APP.Domain;

import java.time.LocalDateTime;

public record ServicoResponseDTO(
        String nome,
        String descricao,
        String codigo,
        String valor,
        String maoDeObra
) {
}
