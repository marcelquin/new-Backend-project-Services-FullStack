package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.ItemOrdemServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrdemServicoRepository extends JpaRepository<ItemOrdemServicoEntity, Long> {
}
