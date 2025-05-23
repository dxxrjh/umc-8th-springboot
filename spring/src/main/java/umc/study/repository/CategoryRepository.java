package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
