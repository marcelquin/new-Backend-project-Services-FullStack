package App.Bussness;

import App.Domain.PagamentoResponseDTO;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.PagamentoGateway;
import App.Infra.Persistence.Entity.PagamentoEntity;
import App.Infra.Persistence.Enum.FORMAPAGAMENTO;
import App.Infra.Exceptions.IllegalActionException;

import App.Infra.Persistence.Repository.PagamentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Service
public class PagamentoService implements PagamentoGateway {

    private final PagamentoRepository pagamentoRepository;
    
    Locale localBrasil = new Locale("pt", "BR");
    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public ResponseEntity<List<PagamentoEntity>> ListarPagamentos()
    {
        try
        {
/*            List<PagamentoResponseDTO> response = new ArrayList<>();
            List<PagamentoEntity> entities = pagamentoRepository.findAll();
            for(PagamentoEntity entity : entities)
            {

            }*/
            //return new ResponseEntity<>(response, HttpStatus.OK);
            return new ResponseEntity<>(pagamentoRepository.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<PagamentoResponseDTO> BuscarPagamentoPorId(Long id)
    {
        try
        {

        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<PagamentoResponseDTO> NovoPagamento(FORMAPAGAMENTO formapagamento,
                                                                 Double parcelas,
                                                                 Double valorPago,
                                                                 Double porcentagemDesconto,
                                                                 Double valorVenda)
    {
        try
        {
            if(parcelas < 0){throw new IllegalActionException("valor invalido");}
            if(valorVenda < 0){throw new IllegalActionException("valor invalido");}
            if(valorPago < 0){throw new IllegalActionException("valor invalido");}
            if(porcentagemDesconto < 0){throw new IllegalActionException("valor invalido");}
            if(formapagamento != FORMAPAGAMENTO.CREDITO && parcelas > 1 ) {throw new IllegalActionException("Acão invalido");}
            if(formapagamento != FORMAPAGAMENTO.DINHEIRO && valorPago > 0) {throw new IllegalActionException("Acão invalido");}
            if(formapagamento == FORMAPAGAMENTO.DINHEIRO && valorPago == 0) {throw new IllegalActionException("Acão invalido");}
            if(formapagamento == FORMAPAGAMENTO.DINHEIRO && valorPago < valorVenda) {throw new IllegalActionException("Acão invalido");}
            if(formapagamento != null &&
            parcelas != null &&
            valorVenda != null &&
            porcentagemDesconto != null &&
            valorPago != null)
            {
               PagamentoEntity entity = new PagamentoEntity();
               entity.setFormaPagamento(formapagamento);
               entity.setValorTotal(valorVenda);
               entity.setParcelas(parcelas);
               entity.setValorPago(valorVenda);
               entity.setValorParcela(valorVenda);
               entity.setValorTroco(0.0);
               entity.setValorDesconto(0.0);
               entity.setPago(true);
               entity.setDataPagamento(LocalDateTime.now());
               entity.setTimeStamp(LocalDateTime.now());
               if(porcentagemDesconto > 0)
               {
                   Double porcentagem = porcentagemDesconto /100;
                   Double novoValorVenda = valorVenda -(valorVenda * porcentagem);
                   entity.setValorDesconto(valorVenda * porcentagem);
                   entity.setValorTotal(novoValorVenda);
                   entity.setValorPago(entity.getValorTotal());
                   entity.setValorParcela(entity.getValorTotal());
               }
               if(formapagamento ==FORMAPAGAMENTO.DINHEIRO)
               {
                   entity.setValorTroco(valorPago - entity.getValorTotal());
               }
               if(formapagamento == FORMAPAGAMENTO.CREDITO && formapagamento == FORMAPAGAMENTO.DEBITO)
               {
                   entity.setValorParcela(entity.getValorTotal() / parcelas);
               }
               pagamentoRepository.save(entity);
               PagamentoResponseDTO response = new PagamentoResponseDTO(entity.getId(),
                       entity.getFormaPagamento(),
                       entity.getPago(),
                       entity.getValorTotal(),
                       entity.getParcelas(),
                       entity.getValorParcela(),
                       entity.getValorPago(),
                       entity.getValorDesconto(),
                       entity.getValorTotal(),
                       entity.getDataPagamento(),
                       entity.getTimeStamp()
                       );
               return new ResponseEntity<>(response, HttpStatus.CREATED);
            }
            else
            { throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<PagamentoResponseDTO> NovoPagamentoScore(FORMAPAGAMENTO formapagamento,
                                                                   Double parcelas,
                                                                   Double valorPago,
                                                                   Double valorVenda)
    {
        try
        {
            if(parcelas < 0){throw new IllegalActionException("valor invalido");}
            if(valorVenda < 0){throw new IllegalActionException("valor invalido");}
            if(valorPago < 0){throw new IllegalActionException("valor invalido");}
            if(formapagamento != null &&
                    parcelas != null &&
                    valorVenda != null &&
                    valorPago != null)
            {

            }
            else
            { throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
