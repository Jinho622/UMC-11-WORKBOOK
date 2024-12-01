package umc.study.spring.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.spring.domain.Review;
import umc.study.spring.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
}
