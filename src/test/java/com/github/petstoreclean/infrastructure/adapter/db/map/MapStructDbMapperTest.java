package com.github.petstoreclean.infrastructure.adapter.db.map;

import com.github.petstoreclean.core.model.pet.Pet;
import com.github.petstoreclean.core.model.pet.PetId;
import com.github.petstoreclean.core.model.petowner.PetOwnerId;
import com.github.petstoreclean.infrastructure.adapter.db.jdbc.pet.PetDbEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class MapStructDbMapperTest {

    private final MapStructDbMapper mapper = Mappers.getMapper(MapStructDbMapper.class);

    @Test
    void should_correctly_map_pet_to_pet_db_entity() {
        // Given
        PetId petId = PetId.of("pet_123");
        PetOwnerId petOwnerId = PetOwnerId.of("owner_456");
        Pet pet = Pet.builder()
                .id(petId)
                .name("Fido")
                .kindOfAnimal("Dog")
                .age(Integer.valueOf(5))
                .petOwnerId(petOwnerId)
                .version(Integer.valueOf(1))
                .build();

        // When
        PetDbEntity petDbEntity = mapper.convert(pet);

        // Then
        assertThat(petDbEntity).isNotNull();
        assertThat(petDbEntity.getId()).isEqualTo(petId.getId());
        assertThat(petDbEntity.getName()).isEqualTo(pet.getName());
        assertThat(petDbEntity.getKindOfAnimal()).isEqualTo(pet.getKindOfAnimal());
        assertThat(petDbEntity.getAge()).isEqualTo(pet.getAge());
        assertThat(petDbEntity.getPetOwnerId()).isEqualTo(petOwnerId.getId());
        assertThat(petDbEntity.getVersion()).isEqualTo(pet.getVersion());
    }
}
