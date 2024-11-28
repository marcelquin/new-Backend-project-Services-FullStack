package App.Infra.Persistence.Repository;


import App.Infra.Persistence.Entity.BoletoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepository extends JpaRepository<BoletoEntity,Long> {
}
