package App.Bussness;

import App.Domain.Request.BoletosRequestDTO;
import App.Domain.Request.VendaRequestFinalziadaDTO;
import App.Domain.Response.RelatorioAnualDTO;
import App.Domain.Response.RelatorioDiarioDTO;
import App.Domain.Response.RelatorioMensalDTO;
import App.FeignClient.FinanceiroFeiginService;
import App.Infra.Exceptions.IllegalActionException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.FinanceiroGateway;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FinanceiroService implements FinanceiroGateway {

    private final FinanceiroFeiginService service;


    public FinanceiroService(FinanceiroFeiginService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<RelatorioDiarioDTO> BuscarRelatorioDiario()
    {
        try
        {
            RelatorioDiarioDTO response = service.BuscarRelatorioDiario().getBody();
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<RelatorioMensalDTO> BuscarRelatorioMensal()
    {
        try
        {
            RelatorioMensalDTO response = service.BuscarRelatorioMensal().getBody();
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<RelatorioAnualDTO> BuscarRelatorioAnual()
    {
        try
        {
            RelatorioAnualDTO response = service.BuscarRelatorioAnual().getBody();
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public void NovoLancamentoVendasRealizadas(VendaRequestFinalziadaDTO dto)
    {
        try
        {
            service.NovoLancamentoVendasRealizadas(dto);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void NovoLancamentoDebito(BoletosRequestDTO dto)
    {
        try
        {
            service.NovoLancamentoDebito(dto);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void NovoPagamentoDebito(Long idBoleto, FORMAPAGAMENTO formapagamento, Double parcelas, Double descontoPagamentoAntecipado)
    {
        try
        {
            if(parcelas < 0){throw new IllegalActionException();}
            if(descontoPagamentoAntecipado < 0){throw new IllegalActionException();}
            if(idBoleto != null && formapagamento != null && parcelas != null && descontoPagamentoAntecipado != null)
            {
                service.NovoPagamentoDebito(idBoleto, formapagamento, parcelas, descontoPagamentoAntecipado);
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}
