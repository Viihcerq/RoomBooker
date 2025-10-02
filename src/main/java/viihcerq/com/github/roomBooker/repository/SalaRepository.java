package viihcerq.com.github.roomBooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import viihcerq.com.github.roomBooker.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
}
