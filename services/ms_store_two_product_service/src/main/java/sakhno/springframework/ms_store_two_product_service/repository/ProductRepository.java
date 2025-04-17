package sakhno.springframework.ms_store_two_product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sakhno.springframework.ms_store_two_product_service.enteties.ProductEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findAllByIdInOrderById(List<Integer> ids);
}
