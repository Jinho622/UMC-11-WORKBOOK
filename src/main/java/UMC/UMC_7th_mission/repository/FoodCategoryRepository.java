package UMC.UMC_7th_mission.repository;

import UMC.UMC_7th_mission.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
