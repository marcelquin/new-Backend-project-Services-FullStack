package App.Bussness;

import App.Domain.Response.*;
import App.FeignClient.ClienteFeiginService;
import App.FeignClient.FinanceiroFeiginService;
import App.FeignClient.ServicoFeiginService;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.IllegalActionException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.VendaGateway;
import App.Infra.Persistence.Entity.ItemVendaEntity;
import App.Infra.Persistence.Entity.VendaEntity;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import App.Infra.Persistence.Enum.STATUSVENDA;
import App.Infra.Persistence.Repository.ItemVendaRepository;
import App.Infra.Persistence.Repository.VendaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class VendaService implements VendaGateway {

    private final VendaRepository vendaRepository;
    private final ItemVendaRepository itemVendaRepository;
    private final ClienteFeiginService clienteFeiginService;
    private final ServicoFeiginService servicoFeiginService;
    private final FinanceiroFeiginService financeiroFeiginService;
    Locale localBrasil = new Locale("pt", "BR");

    public VendaService(VendaRepository vendaRepository, ItemVendaRepository itemVendaRepository, ClienteFeiginService clienteFeiginService, ServicoFeiginService servicoFeiginService, FinanceiroFeiginService financeiroFeiginService) {
        this.vendaRepository = vendaRepository;
        this.itemVendaRepository = itemVendaRepository;
        this.clienteFeiginService = clienteFeiginService;
        this.servicoFeiginService = servicoFeiginService;
        this.financeiroFeiginService = financeiroFeiginService;
    }

    @Override
    public ResponseEntity<List<CupomFiscal>> ListarVendas()
    {
        try
        {
            List<VendaEntity> entities = vendaRepository.findAll();
            List<CupomFiscal> response = new ArrayList<>();
            for(VendaEntity entity : entities)
            {
                List<ItemVendaDTO> itemVendaDTOList = new ArrayList<>();
                for(ItemVendaEntity itemVenda : entity.getItems())
                {
                    ItemVendaDTO dto = new ItemVendaDTO(itemVenda.getNome(),
                            itemVenda.getDescricao(),
                            itemVenda.getCodigo(),
                            itemVenda.getValorUnitario(),
                            itemVenda.getQuantidade(),
                            itemVenda.getValorTotal());
                    itemVendaDTOList.add(dto);
                }
                CupomFiscal dto = new CupomFiscal(entity.getCliente(),
                        entity.getDocumento(),
                        entity.getCodigo(),
                        entity.getValorTotal(),
                        entity.getSTATUSVENDA(),
                        itemVendaDTOList,
                        entity.getDataVenda(),
                        entity.getDataPagamento());
                response.add(dto);
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @Override
    public ResponseEntity<CupomFiscal> BuscarVendaPorId(Long id)
    {
        try
        {
            if(id != null)
            {
                VendaEntity entity = vendaRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException()
                );
                List<ItemVendaDTO> itemVendaDTOList = new ArrayList<>();
                for(ItemVendaEntity itemVenda : entity.getItems())
                {
                    ItemVendaDTO dto = new ItemVendaDTO(itemVenda.getNome(),
                            itemVenda.getDescricao(),
                            itemVenda.getCodigo(),
                            itemVenda.getValorUnitario(),
                            itemVenda.getQuantidade(),
                            itemVenda.getValorTotal());
                    itemVendaDTOList.add(dto);
                }
                CupomFiscal response = new CupomFiscal(entity.getCliente(),
                        entity.getDocumento(),
                        entity.getCodigo(),
                        entity.getValorTotal(),
                        entity.getSTATUSVENDA(),
                        itemVendaDTOList,
                        entity.getDataVenda(),
                        entity.getDataPagamento());
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
    public ResponseEntity<CupomFiscal> BuscarVendaPorCodigo(String codigo)
    {
        try
        {
            if(codigo != null)
            {
                VendaEntity entity = vendaRepository.findBycodigo(codigo).orElseThrow(
                        () -> new EntityNotFoundException()
                );
                List<ItemVendaDTO> itemVendaDTOList = new ArrayList<>();
                for(ItemVendaEntity itemVenda : entity.getItems())
                {
                    ItemVendaDTO dto = new ItemVendaDTO(itemVenda.getNome(),
                            itemVenda.getDescricao(),
                            itemVenda.getCodigo(),
                            itemVenda.getValorUnitario(),
                            itemVenda.getQuantidade(),
                            itemVenda.getValorTotal());
                    itemVendaDTOList.add(dto);
                }
                CupomFiscal response = new CupomFiscal(entity.getCliente(),
                        entity.getDocumento(),
                        entity.getCodigo(),
                        entity.getValorTotal(),
                        entity.getSTATUSVENDA(),
                        itemVendaDTOList,
                        entity.getDataVenda(),
                        entity.getDataPagamento());
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
    public ResponseEntity<VendaResponseDTO> NovaVenda()
    {
        try
        {
            int codigo = (int) (111111 + Math.random() * 999999);
            VendaEntity entity = new VendaEntity();
            List<ItemVendaEntity> itemVendaEntities = new ArrayList<>();
            entity.setItems(itemVendaEntities);
            entity.setValorTotal(0.0);
            entity.setSTATUSVENDA(STATUSVENDA.AGUARDANDO);
            entity.setCliente("Consumidor");
            entity.setCodigo("pd_"+codigo);
            entity.setTimeStamp(LocalDateTime.now());
            vendaRepository.save(entity);
            List<ItemVendaDTO> itemVendaDTOList = new ArrayList<>();
            VendaResponseDTO response = new VendaResponseDTO(entity.getCliente(),
                    entity.getCodigo(),
                    entity.getValorTotal(),
                    entity.getSTATUSVENDA(),
                    itemVendaDTOList,
                    entity.getDataVenda());
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<VendaResponseDTO> AdicionarItem(Long idVenda,
                                                          Long idProduto,
                                                          Double quantidade)
    {
        try
        {
            if(quantidade < 1 ){throw new IllegalActionException();}
            if(idProduto != null && idVenda != null)
            {
               VendaEntity entity = vendaRepository.findById(idVenda).orElseThrow(
                       EntityNotFoundException::new
               );
               // condicional == aguardando
                if(entity.getSTATUSVENDA() == STATUSVENDA.AGUARDANDO)
                {
                    //chamar ms_produto
                    ServicoResponseDTO servico = servicoFeiginService.BuscarServicoPorId(idProduto).getBody();
                    //calcular novo valor via metodo interno da entidade
                    ItemVendaEntity itemVenda = new ItemVendaEntity();
                    itemVenda.setNome(servico.nome());
                    itemVenda.setDescricao(servico.descricao());
                    itemVenda.setCodigo(servico.codigo());
                    itemVenda.setValorUnitario(Double.valueOf(servico.valor()));
                    itemVenda.setQuantidade(quantidade);
                    itemVenda.setTimeStamp(LocalDateTime.now());
                    itemVenda.setValorTotal(itemVenda.CalcularValorTotal(Double.valueOf(servico.valor()), quantidade));
                    itemVendaRepository.save(itemVenda);
                    entity.getItems().add(itemVenda);
                    entity.setValorTotal(entity.calcularValor());
                    entity.setTimeStamp(LocalDateTime.now());
                    //salvar
                    vendaRepository.save(entity);
                    List<ItemVendaDTO> itemVendaDTOList = new ArrayList<>();
                    for(ItemVendaEntity itemVendaInterno : entity.getItems())
                    {
                        ItemVendaDTO dto = new ItemVendaDTO(itemVendaInterno.getNome(),
                                itemVendaInterno.getDescricao(),
                                itemVendaInterno.getCodigo(),
                                itemVendaInterno.getValorUnitario(),
                                itemVendaInterno.getQuantidade(),
                                itemVendaInterno.getValorTotal());
                        itemVendaDTOList.add(dto);
                    }
                    VendaResponseDTO response = new VendaResponseDTO(entity.getCliente(),
                            entity.getCodigo(),
                            entity.getValorTotal(),
                            entity.getSTATUSVENDA(),
                            itemVendaDTOList,
                            entity.getDataVenda());
                    return new ResponseEntity<>(response,HttpStatus.CREATED);
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

    @Override
    public ResponseEntity<CupomFiscal> AdicionarCLienteCadastrado(Long vendaId,Long clienteId)
    {
        try
        {
            if(vendaId != null && clienteId != null)
            {
                VendaEntity entity = vendaRepository.findById(vendaId).orElseThrow(
                        EntityNotFoundException::new
                );
                ClienteResponseDTO clienteResponseDTO = clienteFeiginService.BuscarClientesPorId(clienteId).getBody();
                String nome = clienteResponseDTO.nome()+" "+clienteResponseDTO.sobrenome();
                if(entity.getCliente() == nome){throw new IllegalActionException("cliente já adicionado");}
                if(entity.getDocumento() != null){throw new IllegalActionException("Documento já adicionado");}
                if(entity.getDocumento() == clienteResponseDTO.documento()){throw new IllegalActionException("documento já cadastrado");}
                if(entity.getCliente() != nome)
                {
                    entity.setCliente(nome);
                    entity.setDocumento(clienteResponseDTO.documento());
                    entity.setTimeStamp(LocalDateTime.now());
                    vendaRepository.save(entity);
                    List<ItemVendaDTO> itemVendaDTOList = new ArrayList<>();
                    for(ItemVendaEntity itemVenda : entity.getItems())
                    {
                        ItemVendaDTO dto = new ItemVendaDTO(itemVenda.getNome(),
                                itemVenda.getDescricao(),
                                itemVenda.getCodigo(),
                                itemVenda.getValorUnitario(),
                                itemVenda.getQuantidade(),
                                itemVenda.getValorTotal());
                        itemVendaDTOList.add(dto);
                    }
                    CupomFiscal response = new CupomFiscal(entity.getCliente(),
                            entity.getDocumento(),
                            entity.getCodigo(),
                            entity.getValorTotal(),
                            entity.getSTATUSVENDA(),
                            itemVendaDTOList,
                            entity.getDataVenda(),
                            entity.getDataPagamento());
                    return new ResponseEntity<>(response,HttpStatus.OK);
                }
            }
            else{throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<CupomFiscal> AdicionarCLienteNaoCadastrado(Long vendaId, String cliente,Long documento)
    {
        try
        {
            if(vendaId != null && cliente != null && documento != null)
            {
                VendaEntity entity = vendaRepository.findById(vendaId).orElseThrow(
                        EntityNotFoundException::new
                );
                if(entity.getDocumento() != null){throw new IllegalActionException("Documento já adicionado");}
                if(entity.getDocumento() == documento){throw new IllegalActionException("documento já cadastrado");}
                if(entity.getCliente() == cliente){throw new IllegalActionException("Cliente já adicionado");}
                if(entity.getCliente() != cliente)
                {
                    entity.setCliente(cliente);
                    entity.setDocumento(documento);
                    entity.setTimeStamp(LocalDateTime.now());
                    vendaRepository.save(entity);
                    List<ItemVendaDTO> itemVendaDTOList = new ArrayList<>();
                    for(ItemVendaEntity itemVenda : entity.getItems())
                    {
                        ItemVendaDTO dto = new ItemVendaDTO(itemVenda.getNome(),
                                itemVenda.getDescricao(),
                                itemVenda.getCodigo(),
                                itemVenda.getValorUnitario(),
                                itemVenda.getQuantidade(),
                                itemVenda.getValorTotal());
                        itemVendaDTOList.add(dto);
                    }
                    CupomFiscal response = new CupomFiscal(entity.getCliente(),
                            entity.getDocumento(),
                            entity.getCodigo(),
                            entity.getValorTotal(),
                            entity.getSTATUSVENDA(),
                            itemVendaDTOList,
                            entity.getDataVenda(),
                            entity.getDataPagamento());
                    return new ResponseEntity<>(response,HttpStatus.OK);
                }
            }
            else{throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<CupomFiscal> FinalizarVenda(Long idVenda,
                                                      FORMAPAGAMENTO formapagamento,
                                                      Double valorPago,
                                                      Double parcelas)
    {
        try
        {
            if(parcelas > 1 && formapagamento != FORMAPAGAMENTO.CREDITO)
            {throw new IllegalActionException();}
            if(idVenda != null && formapagamento != null)
            {
                VendaEntity entity = vendaRepository.findById(idVenda).orElseThrow(
                        EntityNotFoundException::new
                );
                if(entity.getSTATUSVENDA() == STATUSVENDA.AGUARDANDO)
                {
                    if(valorPago < entity.getValorTotal()){throw new IllegalActionException("O valor pago é insuficiente para quitar o débito.");}
                    //chamada financeiro-service
                    entity.setSTATUSVENDA(STATUSVENDA.PAGO);
                    entity.setTimeStamp(LocalDateTime.now());
                    entity.setDataPagamento(LocalDateTime.now());
                    vendaRepository.save(entity);
                    //Response metodo
                    Double valorParcela = entity.getValorTotal()/parcelas;
                    List<ItemVendaDTO> itemVendaDTOList = new ArrayList<>();
                    List<ItemVendaRequestDTO> itemVendaRequestDTOS = new ArrayList<>();
                    for(ItemVendaEntity itemVenda : entity.getItems())
                    {
                        ItemVendaDTO dto = new ItemVendaDTO(itemVenda.getNome(),
                                itemVenda.getDescricao(),
                                itemVenda.getCodigo(),
                                itemVenda.getValorUnitario(),
                                itemVenda.getQuantidade(),
                                itemVenda.getValorTotal());
                        ItemVendaRequestDTO requestDTO = new ItemVendaRequestDTO(itemVenda.getNome(),
                                itemVenda.getDescricao(),
                                itemVenda.getQuantidade(),
                                itemVenda.getValorUnitario(),
                                itemVenda.getValorTotal());
                        itemVendaDTOList.add(dto);
                        itemVendaRequestDTOS.add(requestDTO);
                    }
                    CupomFiscal response = new CupomFiscal(entity.getCliente(),
                            entity.getDocumento(),
                            entity.getCodigo(),
                            entity.getValorTotal(),
                            entity.getSTATUSVENDA(),
                            itemVendaDTOList,
                            entity.getDataVenda(),
                            entity.getDataPagamento());
                    VendaRequestFinalziadaDTO responseRequest = new VendaRequestFinalziadaDTO(entity.getCliente(),
                            entity.getCodigo(),
                            entity.getDataVenda(),
                            itemVendaRequestDTOS,
                            parcelas,
                            valorParcela,
                            entity.getValorTotal(),
                            formapagamento,
                            entity.getDataPagamento()
                            );
                    financeiroFeiginService.NovoLancamentoVendasRealizadas(responseRequest);
                    return new ResponseEntity<>(response,HttpStatus.OK);
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
