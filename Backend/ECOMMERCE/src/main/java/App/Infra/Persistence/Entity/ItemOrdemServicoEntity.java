package App.Infra.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Item_Ordem_Servico")
@Data
@Entity
public class ItemOrdemServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private String codigo;

    private Double valor;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;
}
