package App.Domain.Response;

public record ServicoResponseDTO(
        String nome,
        String descricao,
        String codigo,
        String valor,
        String maoDeObra
) {
}
