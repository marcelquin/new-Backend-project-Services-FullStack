package App.Infra.Persistence.Enum;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public enum STATUSORDEMSERVICO {

    AGUARDANDO,
    INICIADO,
    CONCLUIDO
}
