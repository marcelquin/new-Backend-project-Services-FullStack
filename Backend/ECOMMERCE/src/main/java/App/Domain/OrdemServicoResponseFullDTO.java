package App.Domain;


import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import App.Infra.Persistence.Enum.STATUSORDEMSERVICO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record OrdemServicoResponseFullDTO(
        Long id,
        String codigo,
        String cliente,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCadastro,
        List<ItemOrdemServicosResponseDTO> itens,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataInicio,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataConclusao,
        String valor,
        STATUSORDEMSERVICO statusordemservico,
        String telefone,
        String email,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataPagamento
) {
}
