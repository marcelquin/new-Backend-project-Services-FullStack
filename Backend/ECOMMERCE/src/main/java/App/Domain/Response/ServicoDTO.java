package App.Domain.Response;

public record ServicoDTO(
        Long id,
        String nome,
        String descricao,
        String codigo,
        String valor,
        String maoDeObra
) {
}
