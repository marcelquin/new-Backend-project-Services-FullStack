package App.Domain.Response;

public record ItemVendaResponseDTO(
        String nome,
        String descricao,
        Double quantidade,
        String valorUnitario,
        String valorTotal
) {
}
