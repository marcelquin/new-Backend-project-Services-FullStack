package App.Domain;


import App.Domain.Response.BoletosResponseDTO;
import App.Domain.Response.VendaResponseFinalizadaDTO;

import java.util.List;

public record RelatorioDiarioDTO(
        int dia,
        String dataReferencia,
        List<VendaResponseFinalizadaDTO> vendasFinalizadas,
        String totalVendasDebito,

        String totalVendasCredito,

        String totalVendasDinheiro,

        String totalVendasPix,

        String totalVendasRecebida,


        String totalDebitos,

        List<BoletosResponseDTO> boletos
        ) {


}
