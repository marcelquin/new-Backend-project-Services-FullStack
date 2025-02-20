package App.Domain.Response;

public record EstoqueResponseDTO(
        String nome,
        String descricao,
        String codigo,
        Double quantidade,
        String valor
) {
}
