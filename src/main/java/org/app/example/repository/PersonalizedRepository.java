package org.app.example.repository;

import org.app.example.model.Shopper;
import org.app.example.model.ShopperInformation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonalizedRepository extends JpaRepository<Shopper, String> {
    @Query(value = "select product.productId as productId, " +
            "meta.brand as brand, meta.category as category from Shopper shopper " +
            "inner join ProductId product on product.id = shopper.id " +
            "inner join ProductMetaData meta on product.productId = meta.productId " +
            "where shopper.shopperId = :shopperId and (:category is null or meta.category = :category) " +
            "and (:brand is null or meta.brand = :brand)")
    List<ShopperInformation> findProductsByShopperId(@Param("shopperId") String shopperId, @Param("category") String category,
                                             @Param("brand") String brand, Pageable pageable);

    Optional<Shopper> findByShopperId(String shopperId);
}
