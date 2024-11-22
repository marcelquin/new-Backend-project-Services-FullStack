package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity,Long> {
}
