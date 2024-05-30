package org.app.example.repository;

import org.app.example.model.ProductMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductMetaData, String> {
}
