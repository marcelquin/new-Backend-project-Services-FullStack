package App.Infra.Persistence.Entity;

import App.Infra.Persistence.Enum.STATUSORDEMSERVICO;
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
public class OrdemServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;

    private String relato;

    private String resolucao;

    private String codigo;

    private Double valorTotal;

    @OneToOne
    @JoinColumn(name = "contatoEntity_id", referencedColumnName = "id")
    private ContatoEntity contato;

    @Enumerated(EnumType.STRING)
    private STATUSORDEMSERVICO statusordemservico;

    @OneToMany
    List<ItemOrdemServicoEntity> items;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCadastro;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataConclusao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;
}
