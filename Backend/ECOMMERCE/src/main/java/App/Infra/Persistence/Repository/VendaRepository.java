package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Long> {

    Optional<VendaEntity> findBycodigo(String codigo);
}
