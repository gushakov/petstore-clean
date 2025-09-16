package com.github.petstoreclean.infrastructure.adapter.db.jdbc.pet;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "pet")
public class PetDbEntity {

    @Id
    @Column("id")
    private String id;

    @Column("name")
    private String name;

    @Column("kind_of_animal")
    private String kindOfAnimal;

    @Column("age")
    private Integer age;

    @Column("pet_owner_id")
    private String petOwnerId;

    @Version
    private Integer version;
}

