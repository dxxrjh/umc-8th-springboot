package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}