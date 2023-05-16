package com.stephenmontague.wisdompet.data.repositories;

import com.stephenmontague.wisdompet.data.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity findByEmailAddress(String email);
}
