package org.app.example.repository;

import org.app.example.model.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductIdRepository extends JpaRepository<ProductId, String> {
}
