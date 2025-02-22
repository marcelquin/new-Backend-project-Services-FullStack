package APP.Infra.Persistence.Repository;


import APP.Infra.Persistence.Entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoEntity,Long> {

    Optional<ServicoEntity> findBynome(String nome);

    Optional<ServicoEntity> findBycodigo(String codigo);
}
