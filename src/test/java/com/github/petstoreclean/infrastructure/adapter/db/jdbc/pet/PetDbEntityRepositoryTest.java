package com.github.petstoreclean.infrastructure.adapter.db.jdbc.pet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
class PetDbEntityRepositoryTest {

    @Autowired
    private PetDbEntityRepository repository;

    @Test
    void should_save_and_retrieve_pet() {
        // Given
        PetDbEntity newPet = new PetDbEntity();
        newPet.setId("pet_123456");
        newPet.setName("Fido");
        newPet.setKindOfAnimal("Dog");
        newPet.setAge(3);
        newPet.setPetOwnerId("per_a7x2m9"); // Existing owner from Flyway

        // When
        PetDbEntity savedPet = repository.save(newPet);
        var retrievedPet = repository.findById(savedPet.getId());

        // Then
        assertThat(retrievedPet).isPresent();
        assertThat(retrievedPet.get().getId()).isEqualTo(newPet.getId());
        assertThat(retrievedPet.get().getName()).isEqualTo(newPet.getName());
        assertThat(retrievedPet.get().getKindOfAnimal()).isEqualTo(newPet.getKindOfAnimal());
        assertThat(retrievedPet.get().getAge()).isEqualTo(newPet.getAge());
        assertThat(retrievedPet.get().getPetOwnerId()).isEqualTo(newPet.getPetOwnerId());
        assertThat(retrievedPet.get().getVersion()).isNotNull();
    }
}
