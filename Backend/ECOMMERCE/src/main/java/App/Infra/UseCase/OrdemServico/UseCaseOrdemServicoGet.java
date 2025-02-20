package App.Infra.UseCase.OrdemServico;

import App.Domain.Response.CupomFiscal;
import App.Infra.Gateway.VendaGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseOrdemServicoGet {

    private final VendaGateway vendaGateway;


    public UseCaseOrdemServicoGet(VendaGateway vendaGateway) {
        this.vendaGateway = vendaGateway;
    }

    public ResponseEntity<List<CupomFiscal>> ListarVendas()
    { return vendaGateway.ListarVendas();}
    public ResponseEntity<CupomFiscal> BuscarVendaPorId(@RequestParam Long id)
    {return vendaGateway.BuscarVendaPorId(id);}
    public ResponseEntity<CupomFiscal> BuscarVendaPorCodigo(@RequestParam String codigo)
    {return vendaGateway.BuscarVendaPorCodigo(codigo);}

}
