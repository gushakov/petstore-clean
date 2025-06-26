
package com.github.petstoreclean.infrastructure.adapter.db.jdbc.petowner;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "pet_owner")
public class PetOwnerDbEntity {

    @Id
    @Column("id")
    private String id;

    @Column("name")
    private String name;

    @Column("address")
    private String address;

    @Version
    private Integer version;
}