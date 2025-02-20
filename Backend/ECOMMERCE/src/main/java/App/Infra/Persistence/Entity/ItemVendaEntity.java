package App.Infra.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Item_Ordem_Servico")
@Data
@Entity
public class ItemVendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private String codigo;

    private Double valorUnitario;

    private Double valorTotal;

    private Double quantidade;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public Double CalcularValorTotal(Double valor, Double quantidade)
    {
        try
        {
            this.valorTotal = valor * quantidade;
        } catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }
}
