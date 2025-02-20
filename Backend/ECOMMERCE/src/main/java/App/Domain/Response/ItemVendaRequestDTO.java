package App.Domain.Response;

public record ItemVendaRequestDTO(
        String nome,
        String descricao,
        Double quantidade,
        Double valorUnitario,
        Double valorTotal
) {
}
