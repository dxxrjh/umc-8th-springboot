package umc.study.repository.ReviewRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.Review;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Review> findReviewsByRestaurantId(Long restaurantId) {
        String jpql = "SELECT r FROM Review r WHERE r.restaurant.id = :restaurantId";
        TypedQuery<Review> query = entityManager.createQuery(jpql, Review.class);
        query.setParameter("restaurantId", restaurantId);
        return query.getResultList();
    }
}

