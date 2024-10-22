package edu.icet.crm.product.repository;

import edu.icet.crm.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,String> {
    Optional<ProductEntity> findByName(String name);
}
