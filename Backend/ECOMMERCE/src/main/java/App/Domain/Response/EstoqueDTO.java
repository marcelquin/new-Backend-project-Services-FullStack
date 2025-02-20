package App.Domain.Response;

public record EstoqueDTO(
        Long id,
        String nome,
        String descricao,
        String codigo,
        int quantidade,
        Double valor
) {
}
