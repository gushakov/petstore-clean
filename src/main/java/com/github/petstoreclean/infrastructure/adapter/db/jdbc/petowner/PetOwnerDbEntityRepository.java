package com.github.petstoreclean.infrastructure.adapter.db.jdbc.petowner;

import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface PetOwnerDbEntityRepository extends CrudRepository<PetOwnerDbEntity, String> {

    Stream<PetOwnerDbEntity> findAllAsStream();

}