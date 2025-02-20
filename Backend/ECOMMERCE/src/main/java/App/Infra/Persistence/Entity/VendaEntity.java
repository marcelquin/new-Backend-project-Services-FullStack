package App.Infra.Persistence.Entity;

import App.Infra.Persistence.Enum.STATUSVENDA;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Ordem_Servico")
@Data
@Entity
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;

    private Long documento;

    private String codigo;

    private Double valorTotal;

    @Enumerated(EnumType.STRING)
    private STATUSVENDA STATUSVENDA;

    @OneToMany
    List<ItemVendaEntity> items;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataVenda;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataPagamento;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public Double calcularValor()
    {
        try
        {
            Double valorTotal = 0.0;
            for(ItemVendaEntity itemVenda : this.items)
            {
                valorTotal += itemVenda.getValorTotal();
                this.valorTotal += valorTotal;
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return 0.0;
    }

}
