package App.Domain.Response;

public record ItemVendaDTO(
        String nome,
        String descricao,
        String codigo,
        Double valorUnitario,
        Double quantidade,
        Double valorTotal
) {
}
