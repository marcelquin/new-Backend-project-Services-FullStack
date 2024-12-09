package APP.Bussness;

import APP.Domain.ServicoDTO;
import APP.Domain.ServicoResponseDTO;
import APP.Infra.Gateway.ServicoGateway;
import APP.Infra.Persistence.Entity.ServicoEntity;
import APP.Infra.Exceptions.EntityNotFoundException;
import APP.Infra.Exceptions.IllegalActionException;
import APP.Infra.Exceptions.NullargumentsException;
import APP.Infra.Persistence.Repository.ServicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ServicoService implements ServicoGateway {

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }
    Locale localBrasil = new Locale("pt", "BR");

    @Override
    public ResponseEntity<List<ServicoDTO>> ListarServicos()
    {
        try
        {
            List<ServicoDTO> response = new ArrayList<>();
            List<ServicoEntity> list = servicoRepository.findAll();
            for(ServicoEntity servico : list)
            {
                ServicoDTO dto = new ServicoDTO(servico.getId(),
                        servico.getNome(),
                        servico.getDescricao(),
                        servico.getCodigo(),
                        NumberFormat.getCurrencyInstance(localBrasil).format(servico.getValor()),
                        NumberFormat.getCurrencyInstance(localBrasil).format(servico.getMaoDeObra()));
                response.add(dto);
            }
            return new ResponseEntity<> (response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> BuscarServicoPorId(Long id)
    {
        try
        {
            if(id != null)
            {
                ServicoEntity servico = servicoRepository.findById(id).orElseThrow(
                        ()->new EntityNotFoundException()
                );
                ServicoResponseDTO dto = new ServicoResponseDTO(servico.getNome(),
                                                                servico.getDescricao(),
                                                                servico.getCodigo(),
                                                                NumberFormat.getCurrencyInstance(localBrasil).format(servico.getValor()),
                                                                NumberFormat.getCurrencyInstance(localBrasil).format(servico.getMaoDeObra()));
                return new ResponseEntity<>(dto,HttpStatus.OK);
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> NovoServico(String nome,
                                                          String descricao,
                                                          Double valorServico,
                                                          Double valorMaoDeObra)
    {
        try
        {
            if(valorServico < 0){throw new IllegalActionException("Valor Invalido");}
            if(valorMaoDeObra < 0){throw new IllegalActionException("Valor Invalido");}
            if(nome != null &&
               descricao != null &&
               valorServico != null &&
               valorMaoDeObra != null)
            {
               Double valorTotal = valorServico + valorMaoDeObra;
               int codServico1 = (int) (111 + Math.random() * 999);
               int codServico2 = (int) (111 + Math.random() * 999);
               ServicoEntity servico = new ServicoEntity();
               servico.setNome(nome);
               servico.setDescricao(descricao);
               servico.setCodigo(codServico1+"-"+codServico2);
               servico.setTimeStamp(LocalDateTime.now());
               servico.setValor(valorTotal);
                ServicoResponseDTO dto = new ServicoResponseDTO(servico.getNome(),
                        servico.getDescricao(),
                        servico.getCodigo(),
                        NumberFormat.getCurrencyInstance(localBrasil).format(servico.getValor()),
                        NumberFormat.getCurrencyInstance(localBrasil).format(servico.getMaoDeObra()));
                return new ResponseEntity<>(dto,HttpStatus.CREATED);
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> EditarServico(Long id,
                                                            String nome,
                                                            String descricao,
                                                            Double valorServico,
                                                            Double valorMaoDeObra)
    {
        try
        {
            if(valorServico < 0){throw new IllegalActionException("Valor Invalido");}
            if(valorMaoDeObra < 0){throw new IllegalActionException("Valor Invalido");}
            if(nome != null &&
                    descricao != null &&
                    valorServico != null &&
                    valorMaoDeObra != null)
            {
                Double valorTotal = valorServico + valorMaoDeObra;
                ServicoEntity servico = servicoRepository.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                servico.setNome(nome);
                servico.setDescricao(descricao);
                servico.setTimeStamp(LocalDateTime.now());
                servico.setValor(valorTotal);
                ServicoResponseDTO dto = new ServicoResponseDTO(servico.getNome(),
                        servico.getDescricao(),
                        servico.getCodigo(),
                        NumberFormat.getCurrencyInstance(localBrasil).format(servico.getValor()),
                        NumberFormat.getCurrencyInstance(localBrasil).format(servico.getMaoDeObra()));
                return new ResponseEntity<>(dto,HttpStatus.OK);
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> NovoValorServico(Long id,
                                                               Double novoValor)
    {
        try
        {
            if(novoValor < 0){throw new IllegalActionException("valor Invalido");}
            if(id != null &&
               novoValor != null)
            {
                ServicoEntity servico = servicoRepository.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                servico.setValor(novoValor);
                servico.setTimeStamp(LocalDateTime.now());
                servicoRepository.save(servico);
                ServicoResponseDTO dto = new ServicoResponseDTO(servico.getNome(),
                        servico.getDescricao(),
                        servico.getCodigo(),
                        NumberFormat.getCurrencyInstance(localBrasil).format(servico.getValor()),
                        NumberFormat.getCurrencyInstance(localBrasil).format(servico.getMaoDeObra()));
                return new ResponseEntity<>(dto,HttpStatus.OK);
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> reajusteValorServico(Long id,
                                                                   Double porcentagemReajuste)
    {
        try
        {
            if(porcentagemReajuste < 0){throw new IllegalActionException("valor Invalido");}
            if(id != null && porcentagemReajuste != null)
            {
                Double porcentagem =  porcentagemReajuste/ 100;
                ServicoEntity servico = servicoRepository.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                Double valorAtual = (servico.getValor() * porcentagem) + servico.getValor();
                servico.setValor(valorAtual);
                servico.setTimeStamp(LocalDateTime.now());
                servicoRepository.save(servico);
                ServicoResponseDTO dto = new ServicoResponseDTO(servico.getNome(),
                        servico.getDescricao(),
                        servico.getCodigo(),
                        NumberFormat.getCurrencyInstance(localBrasil).format(servico.getValor()),
                        NumberFormat.getCurrencyInstance(localBrasil).format(servico.getMaoDeObra()));
                return new ResponseEntity<>(dto,HttpStatus.OK);
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> DescontoValorServico(Long id,
                                                                   Double porcentagemDesconto)
    {
        try
        {
            if(porcentagemDesconto < 0){throw new IllegalActionException("valor Invalido");}
            if(id != null && porcentagemDesconto != null)
            {
                Double porcentagem =  porcentagemDesconto/ 100;
                ServicoEntity servico = servicoRepository.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                Double valorAtual = (servico.getValor() * porcentagem) - servico.getValor();
                servico.setValor(valorAtual);
                servico.setTimeStamp(LocalDateTime.now());
                servicoRepository.save(servico);
                ServicoResponseDTO dto = new ServicoResponseDTO(servico.getNome(),
                        servico.getDescricao(),
                        servico.getCodigo(),
                        NumberFormat.getCurrencyInstance(localBrasil).format(servico.getValor()),
                        NumberFormat.getCurrencyInstance(localBrasil).format(servico.getMaoDeObra()));
                return new ResponseEntity<>(dto,HttpStatus.OK);
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public void deletaServico(Long id)
    {
        try
        {

            if(id != null)
            {
                ServicoEntity entity = servicoRepository.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                servicoRepository.deleteById(entity.getId());
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}
