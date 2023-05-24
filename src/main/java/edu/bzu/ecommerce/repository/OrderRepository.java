package edu.bzu.ecommerce.repository;

import edu.bzu.ecommerce.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface OrderRepository extends CrudRepository<Order, Long> {

    //This is example for custom query using JPQL and @Query annotation
    @Query("SELECT o FROM Order o where o.id <> ?1")
    Iterable<Order> findAllExcept(Long excludedId);

    @Query("SELECT o FROM Order o where o.id <> :excludedId")
    Iterable<Order> findAllExceptWithParam(@Param("excludedId") Long excludedId);

    @Query(value = "SELECT * FROM orders", nativeQuery = true)
    Iterable<Order> findAllNative();

    Iterable<Order> findAllByStatusAndDateCreatedLessThan(
            String status, LocalDate currentDay);
}
