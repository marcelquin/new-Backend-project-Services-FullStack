package App.Domain.Request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record BoletosRequestDTO(
        String empresa,
        String cnpj,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataVencimento,
        Double parcelas,
        Double parcelasAtual,
        Double valorTotal
) {
}
