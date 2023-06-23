package com.bryan.db.repository;

import com.bryan.db.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDaoI extends JpaRepository<Order, Long> {

    Optional<Order> findById(Long id);

    @Query(value = "SELECT * FROM orders LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Order> findOrdersWithLimitAndOffset(@Param("limit") int limit, @Param("offset") int offset);
}
