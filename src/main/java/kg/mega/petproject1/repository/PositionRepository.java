package kg.mega.petproject1.repository;

import kg.mega.petproject1.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
