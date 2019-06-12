package ua.gladiator.taxi.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.gladiator.taxi.model.entity.Discount;
import ua.gladiator.taxi.model.entity.enums.SocialStatus;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, Integer> {

    @Query(value = "SELECT (SELECT discount FROM discounts WHERE social_status is NULL AND min_spent_value <= :min_spent ORDER BY discount DESC LIMIT 1) + (SELECT discount FROM discounts WHERE social_status = :soc_status)",
    nativeQuery = true)
    Integer getPersonalDiscount(@Param("min_spent") Long min_spent, @Param("soc_status") String socialStatus);

    @Query("SELECT d.discount from Discount d WHERE d.specialDiscount > 0")
    Integer getSpecialDiscount();
}
