package App.Domain.MsServicesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ClienteResponseDTO(
        String nome,
        String sobrenome,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        String logradouro,
        String numero,
        String bairro,
        String referencia,
        String  cep,
        String  cidade,
        String  estado,
        Long prefixo,
        Long telefone,
        String email,
        String score

) {
}
