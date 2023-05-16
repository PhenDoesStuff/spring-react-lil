package com.stephenmontague.wisdompet.data.repositories;

import com.stephenmontague.wisdompet.data.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}
