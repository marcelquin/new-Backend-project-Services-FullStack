package App.Bussness;

import App.Domain.Response.AuthenticationDTO;
import App.Domain.Response.LoginResponseDTO;
import App.Domain.Response.ServicoDTO;
import App.Domain.Response.ServicoResponseDTO;
import App.FeignClient.SecurityServicoFeiginService;
import App.FeignClient.ServicoFeiginService;
import App.Infra.Exceptions.IllegalActionException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.ServicoGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService implements ServicoGateway {


    private final ServicoFeiginService service;
    private final SecurityServicoFeiginService securityService;

    public ServicoService(ServicoFeiginService service, SecurityServicoFeiginService securityService) {
        this.service = service;
        this.securityService = securityService;
    }

    @Override
    public ResponseEntity<List<ServicoDTO>> ListarServicos()
    {
        try {
            List<ServicoDTO> response = service.ListarServicos().getBody();
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> BuscarServicoPorId(Long id)
    {
        try
        {
            if(id != null)
            {
                ServicoResponseDTO response = service.BuscarServicoPorId(id).getBody();
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            else
            { throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> NovoServico(String nome, String descricao, Double valorServico, Double valorMaoDeObra)
    {
        try
        {
            if(valorServico < 0){throw new IllegalActionException();}
            if(valorMaoDeObra < 0){throw new IllegalActionException();}
            if(nome != null && descricao != null && valorServico != null && valorMaoDeObra != null)
            {
                ServicoResponseDTO response = service.NovoServico(nome, descricao, valorServico, valorMaoDeObra).getBody();
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            else
            { throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> EditarServico(Long id, String nome, String descricao, Double valorServico, Double valorMaoDeObra)
    {
        try
        {
            if(valorServico < 0){throw new IllegalActionException();}
            if(valorMaoDeObra < 0){throw new IllegalActionException();}
            if(id != null && nome != null && descricao != null && valorServico != null && valorMaoDeObra != null)
            {
                ServicoResponseDTO response = service.EditarServico(id,nome, descricao, valorServico, valorMaoDeObra).getBody();
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            else
            { throw new NullargumentsException();}

        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> NovoValorServico(Long id, Double novoValor)
    {
        try
        {
            if(novoValor < 0){throw new IllegalActionException();}
            if(id != null && novoValor != null)
            {
                ServicoResponseDTO response = service.NovoValorServico(id, novoValor).getBody();
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            else
            { throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> reajusteValorServico(Long id, Double porcentagemReajuste)
    {
        try
        {
            if(porcentagemReajuste < 0){throw new IllegalActionException();}
            if(id != null && porcentagemReajuste != null)
            {
                ServicoResponseDTO response = service.reajusteValorServico(id, porcentagemReajuste).getBody();
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            else
            { throw new NullargumentsException();}

        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> DescontoValorServico(Long id, Double porcentagemDesconto)
    {
        try
        {
            if(porcentagemDesconto < 0){throw new IllegalActionException();}
            if(id != null && porcentagemDesconto != null)
            {
                ServicoResponseDTO response = service.DescontoValorServico(id, porcentagemDesconto).getBody();
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            else
            { throw new NullargumentsException();}

        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public void deletaServico(Long id)
    {
        try
        {
            if(id != null)
            {
                service.deletaServico(id);
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
