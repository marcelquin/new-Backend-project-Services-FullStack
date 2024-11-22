package App.Domain;

public record ItemOrdemServicosResponseDTO(
        String servico,
        String descricao,
        String codigo,
        String valor
) {
}
