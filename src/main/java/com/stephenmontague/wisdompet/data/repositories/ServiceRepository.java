package com.stephenmontague.wisdompet.data.repositories;

import com.stephenmontague.wisdompet.data.entities.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {
}
