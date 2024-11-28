package App.Infra.Persistence.Repository;





import App.Infra.Persistence.Entity.VendasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<VendasEntity,Long> {
}
