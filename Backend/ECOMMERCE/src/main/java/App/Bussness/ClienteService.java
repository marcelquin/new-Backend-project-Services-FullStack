package App.Bussness;

import App.Domain.Response.ClienteDTO;
import App.Domain.Response.ClienteResponseDTO;
import App.FeignClient.ClienteFeiginService;
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
            ClienteResponseDTO response = clienteFeiginService.BuscarClientesPorId(id);
            return response;
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
            ClienteResponseDTO response = clienteFeiginService.AlterarScoreClientes(id, score);
            return response;
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
            clienteFeiginService.DeletarClientesPorId(id);
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
            ClienteDTO response = clienteFeiginService.NovoCliente(nome, sobrenome, dataNascimento, logradouro, numero, bairro, referencia, cep, prefixo, telefone, email, score);
            return response;
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
            ClienteResponseDTO response = clienteFeiginService.EditarCliente(id, nome, sobrenome, dataNascimento, logradouro, numero, bairro, referencia, cep, prefixo, telefone, email, score);
            return response;
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }




}
