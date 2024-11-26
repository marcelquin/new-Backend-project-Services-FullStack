package App.Bussness;

import App.Domain.Response.ClienteDTO;
import App.Domain.Response.ClienteResponseDTO;
import App.FeignClient.ClienteFeiginService;
import App.Infra.Exceptions.IllegalActionException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.ClienteGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClienteService implements ClienteGateway {

    private final ClienteFeiginService clienteFeiginService;

    public ClienteService(ClienteFeiginService clienteFeiginService) {
        this.clienteFeiginService = clienteFeiginService;
    }

    @Override
    public List<ClienteDTO> ListarClientes()
    {
        try
        {
            List<ClienteDTO> response = clienteFeiginService.ListarClientes();
            return response;
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ClienteResponseDTO BuscarClientesPorId(Long id)
    {
        try
        {
            if(id != null)
            {
                ClienteResponseDTO response = clienteFeiginService.BuscarClientesPorId(id);
                return response;
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ClienteResponseDTO AlterarScoreClientes(Long id,
                                                   Double score)
    {
        try
        {
            if(score < 0){throw new IllegalActionException();}
            if(id != null && score != null)
            {
                ClienteResponseDTO response = clienteFeiginService.AlterarScoreClientes(id, score);
                return response;
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public void DeletarClientesPorId(Long id)
    {
        try
        {
            if(id != null)
            {
                clienteFeiginService.DeletarClientesPorId(id);
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }


    @Override
    public ClienteDTO NovoCliente(String nome,
                                  String sobrenome,
                                  LocalDate dataNascimento,
                                  String logradouro,
                                  String numero,
                                  String bairro,
                                  String referencia,
                                  String cep,
                                  Long prefixo,
                                  Long telefone,
                                  String email,
                                  Double score)
    {
        try
        {
            if(score < 0) {throw new IllegalActionException();}
            if(nome != null && sobrenome != null && dataNascimento != null && logradouro != null &&
            numero != null && bairro != null && referencia != null && cep != null && prefixo != null &&
            telefone != null && email != null && score != null)
            {
                ClienteDTO response = clienteFeiginService.NovoCliente(nome, sobrenome, dataNascimento, logradouro, numero, bairro, referencia, cep, prefixo, telefone, email, score);
                return response;
            }
            else
            { throw  new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ClienteResponseDTO EditarCliente(Long id,
                                            String nome,
                                            String sobrenome,
                                            LocalDate dataNascimento,
                                            String logradouro,
                                            String numero,
                                            String bairro,
                                            String referencia,
                                            String cep,
                                            Long prefixo,
                                            Long telefone,
                                            String email,
                                            Double score)
    {
        try
        {
            if(score < 0) {throw new IllegalActionException();}
            if(id != null && nome != null && sobrenome != null && dataNascimento != null && logradouro != null &&
                    numero != null && bairro != null && referencia != null && cep != null && prefixo != null &&
                    telefone != null && email != null && score != null)
            {
                ClienteResponseDTO response = clienteFeiginService.EditarCliente(id, nome, sobrenome, dataNascimento, logradouro, numero, bairro, referencia, cep, prefixo, telefone, email, score);
                return response;
            }
            else
            { throw  new NullargumentsException();}

        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }




}
