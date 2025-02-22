package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.ItemVendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVendaEntity, Long> {
}
