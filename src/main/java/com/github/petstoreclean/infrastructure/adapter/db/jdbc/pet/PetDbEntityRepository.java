package com.github.petstoreclean.infrastructure.adapter.db.jdbc.pet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetDbEntityRepository extends CrudRepository<PetDbEntity, String> {
}
