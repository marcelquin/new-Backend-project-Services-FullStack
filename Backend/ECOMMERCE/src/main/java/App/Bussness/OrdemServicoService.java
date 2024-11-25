package App.Bussness;

import App.Domain.ItemOrdemServicosResponseDTO;
import App.Domain.OrdemServicoResponseDTO;
import App.Domain.OrdemServicoResponseFullDTO;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.IllegalActionException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Persistence.Entity.ContatoEntity;
import App.Infra.Persistence.Entity.ItemOrdemServicoEntity;
import App.Infra.Persistence.Entity.OrdemServicoEntity;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import App.Infra.Persistence.Enum.STATUSORDEMSERVICO;
import App.Infra.Persistence.Repository.ContatoRepository;
import App.Infra.Persistence.Repository.ItemOrdemServicoRepository;
import App.Infra.Persistence.Repository.OrdemServicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final ItemOrdemServicoRepository itemOrdemServicoRepository;

    private final ContatoRepository contatoRepository;
    Locale localBrasil = new Locale("pt", "BR");

    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository, ItemOrdemServicoRepository itemOrdemServicoRepository, ContatoRepository contatoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.itemOrdemServicoRepository = itemOrdemServicoRepository;
        this.contatoRepository = contatoRepository;
    }
    //NumberFormat.getCurrencyInstance(localBrasil).format(item.getServico().getValor()));

    public ResponseEntity<List<OrdemServicoResponseFullDTO>> ListarOrdemServico()
    {
        try
        {
            List<OrdemServicoEntity> ordemServicoEntities = ordemServicoRepository.findAll();
            List<OrdemServicoResponseFullDTO> response = new ArrayList<>();
            for(OrdemServicoEntity entity : ordemServicoEntities)
            {
                List<ItemOrdemServicosResponseDTO> dtos = new ArrayList<>();
                for(ItemOrdemServicoEntity itemOrdem : entity.getItems())
                {
                     ItemOrdemServicosResponseDTO dto = new ItemOrdemServicosResponseDTO(itemOrdem.getNome(),
                             itemOrdem.getDescricao(),
                             itemOrdem.getCodigo(),
                             NumberFormat.getCurrencyInstance(localBrasil).format(itemOrdem.getValor()));
                     dtos.add(dto);
                }
                OrdemServicoResponseFullDTO dtoResponse = new OrdemServicoResponseFullDTO(entity.getId(),
                        entity.getCodigo(),
                        entity.getCliente(),
                        entity.getDataCadastro(),
                        dtos,
                        entity.getDataInicio(),
                        entity.getDataConclusao(),
                        NumberFormat.getCurrencyInstance(localBrasil).format(entity.getValorTotal()),
                        entity.getStatusordemservico(),
                        "("+entity.getContato().getPrefixo()+") "+entity.getContato().getTelefone(),
                        entity.getContato().getEmail(),
                        entity.getDataConclusao());
                response.add(dtoResponse);
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<OrdemServicoResponseFullDTO> BuscarOrdemServicoPorId(Long id)
    {
        try
        {
            if(id != null)
            {
                OrdemServicoEntity entity = ordemServicoRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException()
                );
                List<ItemOrdemServicosResponseDTO> dtos = new ArrayList<>();
                for(ItemOrdemServicoEntity itemOrdem : entity.getItems())
                {
                    ItemOrdemServicosResponseDTO dto = new ItemOrdemServicosResponseDTO(itemOrdem.getNome(),
                            itemOrdem.getDescricao(),
                            itemOrdem.getCodigo(),
                            NumberFormat.getCurrencyInstance(localBrasil).format(itemOrdem.getValor()));
                    dtos.add(dto);
                }
                OrdemServicoResponseFullDTO dtoResponse = new OrdemServicoResponseFullDTO(entity.getId(),
                        entity.getCodigo(),
                        entity.getCliente(),
                        entity.getDataCadastro(),
                        dtos,
                        entity.getDataInicio(),
                        entity.getDataConclusao(),
                        NumberFormat.getCurrencyInstance(localBrasil).format(entity.getValorTotal()),
                        entity.getStatusordemservico(),
                        "("+entity.getContato().getPrefixo()+") "+entity.getContato().getTelefone(),
                        entity.getContato().getEmail(),
                        entity.getDataConclusao());
                return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
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

    public ResponseEntity<OrdemServicoResponseFullDTO> BuscarOrdemServicoPorcodigo(String codigo)
    {
        try
        {
            if(codigo != null)
            {
                OrdemServicoEntity entity = ordemServicoRepository.findBycodigo(codigo).orElseThrow(
                        () -> new EntityNotFoundException()
                );
                List<ItemOrdemServicosResponseDTO> dtos = new ArrayList<>();
                for(ItemOrdemServicoEntity itemOrdem : entity.getItems())
                {
                    ItemOrdemServicosResponseDTO dto = new ItemOrdemServicosResponseDTO(itemOrdem.getNome(),
                            itemOrdem.getDescricao(),
                            itemOrdem.getCodigo(),
                            NumberFormat.getCurrencyInstance(localBrasil).format(itemOrdem.getValor()));
                    dtos.add(dto);
                }
                OrdemServicoResponseFullDTO dtoResponse = new OrdemServicoResponseFullDTO(entity.getId(),
                        entity.getCodigo(),
                        entity.getCliente(),
                        entity.getDataCadastro(),
                        dtos,
                        entity.getDataInicio(),
                        entity.getDataConclusao(),
                        NumberFormat.getCurrencyInstance(localBrasil).format(entity.getValorTotal()),
                        entity.getStatusordemservico(),
                        "("+entity.getContato().getPrefixo()+") "+entity.getContato().getTelefone(),
                        entity.getContato().getEmail(),
                        entity.getDataConclusao());
                return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
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

    public ResponseEntity<OrdemServicoResponseDTO> NovaOrdemServico(Long idCliente,
                                                                    String cliente,
                                                                    Long prefixo,
                                                                    Long telefone,
                                                                    String email,
                                                                    String relato)
    {
        try
        {
            if(prefixo < 0 && prefixo > 99){throw new IllegalActionException();}
            if(telefone != null && prefixo != null && relato != null && email != null)
            {
                OrdemServicoEntity entity = new OrdemServicoEntity();
                int codigo = (int) (111111 + Math.random() * 999999);
                entity.setDataCadastro(LocalDateTime.now());
                entity.setCodigo("OS_"+codigo);
                entity.setRelato(relato);
                if(idCliente != null)
                {
                    entity.setCliente("teste");
                }
                if(cliente != null)
                {
                    entity.setCliente(cliente);
                }
                entity.setValorTotal(0.0);
                entity.setStatusordemservico(STATUSORDEMSERVICO.AGUARDANDO);
                entity.setTimeStamp(LocalDateTime.now());
                ContatoEntity contato = new ContatoEntity();
                contato.setEmail(email);
                contato.setPrefixo(prefixo);
                contato.setTelefone(telefone);
                contato.setTimeStamp(LocalDateTime.now());
                contatoRepository.save(contato);
                entity.setContato(contato);
                ordemServicoRepository.save(entity);
                List<ItemOrdemServicosResponseDTO> dtos = new ArrayList<>();
                OrdemServicoResponseDTO dtoResponse = new OrdemServicoResponseDTO(
                        entity.getCodigo(),
                        entity.getCliente(),
                        entity.getDataCadastro(),
                        dtos,
                        null,
                        null,
                        NumberFormat.getCurrencyInstance(localBrasil).format(entity.getValorTotal()),
                        entity.getStatusordemservico(),
                        "("+entity.getContato().getPrefixo()+") "+entity.getContato().getTelefone(),
                        entity.getContato().getEmail(),
                        null);
                return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<OrdemServicoResponseDTO> AdicionarServico(Long idOrdemServico,
                                                                        Long idServico)
    {
        try
        {
            if(idServico != null && idOrdemServico != null)
            {
               OrdemServicoEntity entity = ordemServicoRepository.findById(idOrdemServico).orElseThrow(
                       ()-> new EntityNotFoundException()
               );
               if(entity.getStatusordemservico() == STATUSORDEMSERVICO.INICIADO)
               {
                   //chama ms_servico
                   ItemOrdemServicoEntity itemOrdemServico = new ItemOrdemServicoEntity();
                   itemOrdemServico.setCodigo("teste");
                   itemOrdemServico.setNome("teste");
                   itemOrdemServico.setDescricao("teste");
                   itemOrdemServico.setValor(80.0);
                   itemOrdemServico.setTimeStamp(LocalDateTime.now());
                   itemOrdemServicoRepository.save(itemOrdemServico);
                   entity.setValorTotal(entity.getValorTotal()+itemOrdemServico.getValor());
                   entity.setTimeStamp(LocalDateTime.now());
                   entity.getItems().add(itemOrdemServico);
                   ordemServicoRepository.save(entity);
                   List<ItemOrdemServicosResponseDTO> dtos = new ArrayList<>();
                   for(ItemOrdemServicoEntity itemOrdem : entity.getItems())
                   {
                       ItemOrdemServicosResponseDTO dto = new ItemOrdemServicosResponseDTO(itemOrdem.getNome(),
                               itemOrdem.getDescricao(),
                               itemOrdem.getCodigo(),
                               NumberFormat.getCurrencyInstance(localBrasil).format(itemOrdem.getValor()));
                       dtos.add(dto);
                   }
                   OrdemServicoResponseDTO dtoResponse = new OrdemServicoResponseDTO(
                           entity.getCodigo(),
                           entity.getCliente(),
                           entity.getDataCadastro(),
                           dtos,
                           entity.getDataInicio(),
                           entity.getDataConclusao(),
                           NumberFormat.getCurrencyInstance(localBrasil).format(entity.getValorTotal()),
                           entity.getStatusordemservico(),
                           "("+entity.getContato().getPrefixo()+") "+entity.getContato().getTelefone(),
                           entity.getContato().getEmail(),
                           entity.getDataConclusao());
                   return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
               }
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<OrdemServicoResponseDTO> FinalizarOrdemServico(Long idOrdemServico,
                                                                         FORMAPAGAMENTO formapagamento,
                                                                         Double valorPago,
                                                                         Double parcelas)
    {
        try
        {
            if(idOrdemServico != null && formapagamento != null)
            {
                OrdemServicoEntity entity = ordemServicoRepository.findById(idOrdemServico).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                if(entity.getStatusordemservico() == STATUSORDEMSERVICO.INICIADO)
                {
                    entity.setStatusordemservico(STATUSORDEMSERVICO.CONCLUIDO);
                    entity.setTimeStamp(LocalDateTime.now());
                    entity.setDataConclusao(LocalDateTime.now());
                    ordemServicoRepository.save(entity);
                    List<ItemOrdemServicosResponseDTO> dtos = new ArrayList<>();
                    for(ItemOrdemServicoEntity itemOrdem : entity.getItems())
                    {
                        ItemOrdemServicosResponseDTO dto = new ItemOrdemServicosResponseDTO(itemOrdem.getNome(),
                                itemOrdem.getDescricao(),
                                itemOrdem.getCodigo(),
                                NumberFormat.getCurrencyInstance(localBrasil).format(itemOrdem.getValor()));
                        dtos.add(dto);
                    }
                    OrdemServicoResponseDTO dtoResponse = new OrdemServicoResponseDTO(
                            entity.getCodigo(),
                            entity.getCliente(),
                            entity.getDataCadastro(),
                            dtos,
                            entity.getDataInicio(),
                            entity.getDataConclusao(),
                            NumberFormat.getCurrencyInstance(localBrasil).format(entity.getValorTotal()),
                            entity.getStatusordemservico(),
                            "("+entity.getContato().getPrefixo()+") "+entity.getContato().getTelefone(),
                            entity.getContato().getEmail(),
                            entity.getDataConclusao());
                    return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
                }
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


    public ResponseEntity<OrdemServicoResponseDTO> IniciarOrdemServico(Long idOrdemServico)
    {
        try
        {
            if(idOrdemServico != null)
            {
                OrdemServicoEntity entity = ordemServicoRepository.findById(idOrdemServico).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                if(entity.getStatusordemservico() == STATUSORDEMSERVICO.AGUARDANDO)
                {
                    entity.setStatusordemservico(STATUSORDEMSERVICO.INICIADO);
                    entity.setTimeStamp(LocalDateTime.now());
                    entity.setDataInicio(LocalDateTime.now());
                    ordemServicoRepository.save(entity);
                    List<ItemOrdemServicosResponseDTO> dtos = new ArrayList<>();
                    for(ItemOrdemServicoEntity itemOrdem : entity.getItems())
                    {
                        ItemOrdemServicosResponseDTO dto = new ItemOrdemServicosResponseDTO(itemOrdem.getNome(),
                                itemOrdem.getDescricao(),
                                itemOrdem.getCodigo(),
                                NumberFormat.getCurrencyInstance(localBrasil).format(itemOrdem.getValor()));
                        dtos.add(dto);
                    }
                    OrdemServicoResponseDTO dtoResponse = new OrdemServicoResponseDTO(
                            entity.getCodigo(),
                            entity.getCliente(),
                            entity.getDataCadastro(),
                            dtos,
                            entity.getDataInicio(),
                            entity.getDataConclusao(),
                            NumberFormat.getCurrencyInstance(localBrasil).format(entity.getValorTotal()),
                            entity.getStatusordemservico(),
                            "("+entity.getContato().getPrefixo()+") "+entity.getContato().getTelefone(),
                            entity.getContato().getEmail(),
                            entity.getDataConclusao());
                    return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
                }
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


}
