package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.OrdemServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServicoEntity, Long> {

    Optional<OrdemServicoEntity> findBycodigo(String codigo);
}
